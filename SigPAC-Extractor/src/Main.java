import java.util.Scanner;


public class Main {
    static Scanner inputScanner;

    public static void main(String[] args) {
        System.out.println("SigPAC ToolKit por Rafael Petouris");
        inputScanner = new Scanner(System.in);

        String option = "";

        while (!option.equals("3")) {
            System.out.println(
                    "-------------------------------- \n" +
                            "Por favor, indique el número de la opción a realizar: \n" +
                            "1 - Escanear pdf a tabla \n" +
                            "2 - Comparar diferencias entre tablas \n" +
                            "3 - Cerrar aplicación \n" +
                            "-------------------------------- "
            );

            option = inputScanner.nextLine();

            optionSwitchCase(option);
        }


        inputScanner.close();

    }

    /**
     * Switch case for selection of tools to use.
     *
     * @param option the option selected.
     */
    private static void optionSwitchCase(String option) {
        switch (option) {
            case "1":
                System.out.println("Ha elegido 'Escanear pdf a tabla:'");
                pdfExtractor();
                break;
            case "2":
                System.out.println("Ha elegido 'Comparar diferencias entre tablas'");
                break;
            case "3":
                System.out.println("Muchas gracias por usar este servicio.\n" +
                        "Si ha tenido problemas, por favor contacte con r.petouris@gmail.com");
                break;
            default:
                System.out.println("La opción introducida no es válida. Inténtelo de nuevo \n");
                break;
        }
    }

    /**
     * Method to extract the table contents of a pdf to a table format
     */

    private static void pdfExtractor() {
        System.out.println("SigPAC Extractor por Rafael Petouris");

        String pdfFileName = fileNameInput();
        System.out.println("Ha decidido abrir el archivo pdf " + pdfFileName);

        //Fill in extraction function

        System.out.println("Como quiere llamar esta tabla?:");
        String txtFileName = inputScanner.nextLine();

        System.out.println("La tabla se ha guardado como " + txtFileName); //change to path
    }


    /**
     * Method to scan fileName from user input.
     *
     * @return String fileName
     */
    private static String fileNameInput() {

        System.out.println("Por favor, escriba el nombre del pdf a leer:");
        String fileName = inputScanner.nextLine();

        return fileName;
    }
}