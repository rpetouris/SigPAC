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
                            "1 - Escanear pdf a fichero \n" +
                            "2 - Comparar diferencias entre ficheros \n" +
                            "3 - Cerrar aplicación \n" +
                            "-------------------------------- "
            );

            option = inputScanner.nextLine();

            optionSwitchCase(option);
        }


        inputScanner.close();

    }

    private static void optionSwitchCase(String option) {
        switch (option) {
            case "1":
                System.out.println("Ha elegido 'Escanear pdf a fichero:'");
                pdfExtractor();
                break;
            case "2":
                System.out.println("Ha elegido 'Comparar diferencias entre ficheros'");
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

    private static void pdfExtractor() {
        System.out.println("SigPAC Extractor por Rafael Petouris");

        String fileName = fileNameInput();
        System.out.println(fileName);
    }


    /**
     * Method to scan fileName from user input;
     *
     * @return String fileName
     */
    private static String fileNameInput() {

        System.out.print("Por favor, escriba el nombre del pdf a leer: \n");
        String fileName = inputScanner.nextLine();

        return fileName;
    }
}