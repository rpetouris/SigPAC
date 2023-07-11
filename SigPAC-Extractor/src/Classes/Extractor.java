package Classes;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Extractor extends Shared {

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
    public void pdfExtractor() {
        System.out.println("SigPAC Extractor por Rafael Petouris");

        String pdfFileName = super.fileNameInput();
        System.out.println("Ha decidido abrir el archivo pdf \"" + pdfFileName + "\"");

        String s = readPDF(pdfFileName);
        if (s != null) {
            System.out.println("¿Cómo quiere llamar a esta tabla?");
            String tableName = super.getInputScanner().nextLine();
            File file = new File("./Files/" + tableName + ".txt");
            writeToFile(s, file);
            System.out.println("La tabla se ha guardado como \"" + file.getAbsolutePath() + "\"");
        }

    }

    /**
     * Method that parses through a given pdf and outputs the text within it.
     *
     * @param fileName path to file to be read
     * @return String with text within file
     * @throws IOException if file not found
     */
    public static String readPDF(String fileName) {

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
            } else {return null;}

        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo.");
            return null;
        }

        return textParser(text);
    }

    /**
     * Method that parses through the text and outputs only the necessary information
     * @param text to retrieve information
     * @return ordered text of plots of land
     */
    private static String textParser(String text) {
        int indexBegin = text.indexOf("DATOS DE LINEAS DE AYUDA / RECINTOS"); //beginning
        int indexEnd = text.indexOf("Declaración Responsable(Agricultor Activo)"); //end

        //System.out.println(indexBegin + " " + indexEnd);

        String proper = text.substring(indexBegin, indexEnd + 1);

        String[] plots = proper.split("\n");

        String table = "";

        for (String p : plots) {
            if (p.matches("\\d+ \\d+ \\d+ \\d+ \\d+ \\d+ \\d+ \\d+ \\d+ \\d+ \\d+,\\d+ \\w \\w+")) {
                table += p + "\n";
            }
        }

        return table;
    }

    /**
     * Method that writes the table to a txt file with the name introduced.
     * If a file with the given name already exists, it is replaced.
     * @param text table to be inserted in the txt
     * @param file name of the file to add in the information
     * @throws Exception if there is an error to create the file
     */
    public static void writeToFile(String text, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
            fileWriter.write(text);
            fileWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ha habido un error al crear el archivo.");
        }
    }

    /**
     * Equals method for Extractor
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        return this.getClass().equals(obj.getClass()) && super.equals(obj.getClass().getSuperclass());
    }
}
