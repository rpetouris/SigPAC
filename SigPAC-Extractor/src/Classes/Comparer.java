package Classes;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comparer extends Shared{
    /**
     * Constructor for Shared, contains shared features between Extractor and Comparer classes
     *
     * @param inputScanner scanner that detects user inputs
     */
    public Comparer(Scanner inputScanner) {
        super(inputScanner);
    }

    public void dataComparer() {
        System.out.println("SigPAC Extractor por Rafael Petouris");

        System.out.println("Archivo 1");
        String firstFileName = super.fileNameInput();
        System.out.println("Ha decidido abrir el archivo \"" + firstFileName + "\"");
        File firstFile = new File("./Files/" + firstFileName + ".txt").getAbsoluteFile();

        System.out.println("Archivo 2");
        String secondFileName = super.fileNameInput();
        System.out.println("Ha decidido abrir el archivo \"" + secondFileName + "\"");
        File secondFile = new File("./Files/" + secondFileName + ".txt").getAbsoluteFile();

        dataSorter(firstFile, secondFile);

        System.out.println("Comparando Información:");
    }

    private List<List<Recinto>> dataSorter(File file1, File file2) {
        List<List<Recinto>> listArray = new ArrayList<>();
        List<Recinto> firstFile = listFiller(file1);
        List<Recinto> secondFile = listFiller(file2);



        return listArray;
    }

    private List<Recinto> listFiller(File file){
        List<Recinto> fileText = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(file);

            Recinto recinto;
            while (fileScanner.hasNextLine()) {
                String currentLine = fileScanner.nextLine();
                recinto = extractRecinto(currentLine);

                fileText.add(recinto);
            }
            System.out.println(fileText.get(0));
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("File was not found");
            e.printStackTrace();
        }

        return fileText;
    }

    private static Recinto extractRecinto(String currentLine) {
        String[] currentLineArray = currentLine.split(" ");
        Recinto recinto = new Recinto();

        recinto.setCodProvincia(Integer.parseInt(currentLineArray[0]));
        recinto.setCodMunicipio(Integer.parseInt(currentLineArray[1]));
        recinto.setAgregado(Integer.parseInt(currentLineArray[2]));
        recinto.setZona(Integer.parseInt(currentLineArray[3]));
        recinto.setCodPoligono(Integer.parseInt(currentLineArray[4]));
        recinto.setCodParcela(Integer.parseInt(currentLineArray[5]));
        recinto.setCodRecinto(Integer.parseInt(currentLineArray[6]));
        recinto.setNumParcelaAgricola(Integer.parseInt(currentLineArray[7]));
        recinto.setCodProducto(Integer.parseInt(currentLineArray[8]));
        recinto.setVariedad(Integer.parseInt(currentLineArray[9]));
        recinto.setSuperDeclarada(Double.parseDouble(currentLineArray[10].replace(',', '.')));
        recinto.setIrrigacion(currentLineArray[11].charAt(0));
        recinto.setUsoSigPac(currentLineArray[12]);

        return recinto;
    }

}
