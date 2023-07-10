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

        //Fill in extraction function

        System.out.println("¿Cómo quiere llamar a esta tabla?");
        String tableName = shared.getInputScanner().nextLine();

        File file = new File("./Files/" + tableName + ".txt");

        writeToFile(readPDF(pdfFileName), file);

        System.out.println("La tabla se ha guardado como \"" + tableName + "\""); //change to path after implementing
    }


    private static String extract(String fileName) {
        String text = "";

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            while (fileScanner.hasNextLine()) {
                text += fileScanner.nextLine() + "\n";
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return text;
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
            e.printStackTrace();
        }

        return text;
    }

    private static void writeToFile(String text, File file) {
        try {
            FileWriter fileWriter = new FileWriter(file.getAbsolutePath());
            fileWriter.write(text);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("There was an error creating the file.");
        }
    }
}
