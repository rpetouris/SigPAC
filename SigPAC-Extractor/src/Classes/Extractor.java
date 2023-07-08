package Classes;

import java.util.Scanner;

import static Classes.Shared.fileNameInput;

public class Extractor{

    private static Shared shared;

    /**
     * Method to extract the table contents of a pdf to a table format
     */
    public static void pdfExtractor() {
        System.out.println("SigPAC Extractor por Rafael Petouris");

        String pdfFileName = shared.fileNameInput();
        System.out.println("Ha decidido abrir el archivo pdf \"" + pdfFileName +"\"");

        //Fill in extraction function

        System.out.println("¿Cómo quiere llamar a esta tabla?");
        String tableName = shared.getInputScanner().nextLine();

        System.out.println("La tabla se ha guardado como \"" + tableName +"\""); //change to path after implementing
    }
}
