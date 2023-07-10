package Classes;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Extractor extends Shared {

    private static Shared shared;

    /**
     * Constructor for Extractor, inherits from Shared
     *
     * @param inputScanner scanner that detects user inputs
     */
    public Extractor(Scanner inputScanner) {
        super(inputScanner);
    }

    /**
     * Method to extract the table contents of a pdf to a table format
     */
    public static void pdfExtractor() {
        System.out.println("SigPAC Extractor por Rafael Petouris");

        String pdfFileName = shared.fileNameInput();
        System.out.println("Ha decidido abrir el archivo pdf \"" + pdfFileName + "\"");



        String s = readPDF(pdfFileName);
        if (s != null) {
            System.out.println("¿Cómo quiere llamar a esta tabla?");
            String tableName = shared.getInputScanner().nextLine();
            File file = new File("./Files/" + tableName + ".txt");
            writeToFile(s, file);
            System.out.println("La tabla se ha guardado como \"" + file.getAbsolutePath() + "\"");
        }


    }


    private static String readPDF(String fileName) {

        String text = "";

        try (PDDocument document = PDDocument.load(new File(fileName))) {

            document.getClass();

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);
                PDFTextStripper tStripper = new PDFTextStripper();
                String pdfFileInText = tStripper.getText(document);

                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    text += line + "\n";
                }

            }

        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo.");
            return null;
        }

        int indexBegin = text.indexOf("DATOS DE LINEAS DE AYUDA / RECINTOS"); //beginning
        int indexEnd = text.indexOf("Declaración Responsable(Agricultor Activo)"); //end

        System.out.println(indexBegin + " " + indexEnd);

        String proper = text.substring(indexBegin,indexEnd + 1);

        //test
        String[] recints = proper.split("\n");

        String r = "";

        for (String recint : recints) {
            if (recint.matches("\\d+ \\d+ \\d+ \\d+ \\d+ \\d+ \\d+ \\d+ \\d+ \\d+ \\d+,\\d+ \\w \\w+")){
                r += recint + "\n";
            }
        }

        return r;
    }

    private static void writeToFile(String text, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
            fileWriter.write(text);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ha habido un error al crear el archivo.");
        }
    }
}
