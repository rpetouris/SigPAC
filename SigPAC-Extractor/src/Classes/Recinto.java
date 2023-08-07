package Classes;

import java.util.Objects;

public class Recinto {
    private int codProvincia;
    private int codMunicipio;
    private int agregado;
    private int zona;
    private int codPoligono;
    private int codParcela;
    private int codRecinto;
    private int numParcelaAgricola;
    private int codProducto;
    private int variedad;
    private double superDeclarada;
    private char irrigacion;
    private String usoSigPac;

    /**
     * Constructor for Recinto
     * @param codProvincia province code
     * @param codMunicipio Municipal code
     * @param agregado Aggregate
     * @param zona Zone
     * @param codPoligono Code Polygon
     * @param codParcela Code Plot
     * @param codRecinto Code Enclosure
     * @param numParcelaAgricola Number of Plot
     * @param codProducto Code Product
     * @param variedad Type
     * @param superDeclarada Declared Surface
     * @param irrigacion Type of Irrigation
     * @param usoSigPac Use in SigPac
     */
    public Recinto (int codProvincia, int codMunicipio, int agregado, int zona, int codPoligono, int codParcela,
                   int codRecinto, int numParcelaAgricola, int codProducto, int variedad, double superDeclarada,
                   char irrigacion, String usoSigPac) {
        this.codProvincia = codProvincia;
        this.codMunicipio = codMunicipio;
        this.agregado = agregado;
        this.zona = zona;
        this.codPoligono = codPoligono;
        this.codParcela = codParcela;
        this.codRecinto = codRecinto;
        this.numParcelaAgricola = numParcelaAgricola;
        this.codProducto = codProducto;
        this.variedad = variedad;
        this.superDeclarada = superDeclarada;
        this.irrigacion = irrigacion;
        this.usoSigPac = usoSigPac;
    }

    public Recinto(){

    }

    public int getCodProvincia() {
        return codProvincia;
    }

    public void setCodProvincia(int codProvincia) {
        this.codProvincia = codProvincia;
    }

    public int getCodMunicipio() {
        return codMunicipio;
    }

    public void setCodMunicipio(int codMunicipio) {
        this.codMunicipio = codMunicipio;
    }

    public int getAgregado() {
        return agregado;
    }

    public void setAgregado(int agregado) {
        this.agregado = agregado;
    }

    public int getZona() {
        return zona;
    }

    public void setZona(int zona) {
        this.zona = zona;
    }

    public int getCodPoligono() {
        return codPoligono;
    }

    public void setCodPoligono(int codPoligono) {
        this.codPoligono = codPoligono;
    }

    public int getCodParcela() {
        return codParcela;
    }

    public void setCodParcela(int codParcela) {
        this.codParcela = codParcela;
    }

    public int getCodRecinto() {
        return codRecinto;
    }

    public void setCodRecinto(int codRecinto) {
        this.codRecinto = codRecinto;
    }

    public int getNumParcelaAgricola() {
        return numParcelaAgricola;
    }

    public void setNumParcelaAgricola(int numParcelaAgricola) {
        this.numParcelaAgricola = numParcelaAgricola;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public int getVariedad() {
        return variedad;
    }

    public void setVariedad(int variedad) {
        this.variedad = variedad;
    }

    public double getSuperDeclarada() {
        return superDeclarada;
    }

    public void setSuperDeclarada(double superDeclarada) {
        this.superDeclarada = superDeclarada;
    }

    public char getIrrigacion() {
        return irrigacion;
    }

    public void setIrrigacion(char irrigacion) {
        this.irrigacion = irrigacion;
    }

    public String getUsoSigPac() {
        return usoSigPac;
    }

    public void setUsoSigPac(String usoSigPac) {
        this.usoSigPac = usoSigPac;
    }

    @Override
    public String toString() {

        String ir;

        if (irrigacion == 'S') {
            ir = "Secano";
        } else {
            ir = "Regadío";
        }
        return "[Provincia " + codProvincia +
                ", Municipio " + codMunicipio +
                ", Agregado " + agregado +
                ", Zona " + zona +
                ", Poligono " + codPoligono +
                ", Parcela " + codParcela +
                ", Recinto " + codRecinto +
                ", Número " + numParcelaAgricola +
                ", Producto " + codProducto +
                ", Variedad " + variedad +
                ", Superficie Declarada " + superDeclarada +
                ", " + ir +
                ", Uso '" + usoSigPac + '\'' +
                ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recinto recinto)) return false;
        return getCodProvincia() == recinto.getCodProvincia() && getCodMunicipio() == recinto.getCodMunicipio()
                && getAgregado() == recinto.getAgregado() && getZona() == recinto.getZona()
                && getCodPoligono() == recinto.getCodPoligono() && getCodParcela() == recinto.getCodParcela()
                && getCodRecinto() == recinto.getCodRecinto()
                && getNumParcelaAgricola() == recinto.getNumParcelaAgricola()
                && getCodProducto() == recinto.getCodProducto() && getVariedad() == recinto.getVariedad()
                && Double.compare(recinto.getSuperDeclarada(), getSuperDeclarada()) == 0
                && getIrrigacion() == recinto.getIrrigacion()
                && Objects.equals(getUsoSigPac(), recinto.getUsoSigPac());
    }

}
