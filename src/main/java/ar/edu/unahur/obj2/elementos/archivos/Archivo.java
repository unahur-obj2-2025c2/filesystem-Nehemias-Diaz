package ar.edu.unahur.obj2.elementos.archivos;

import ar.edu.unahur.obj2.elementos.Elemento;

public class Archivo implements Elemento {
    private String nombre;
    private String extension;
    private Integer tamañoEnBytes;

    public Archivo(String unNombre, String unaExtension, Integer unTamañoEnBytes) {
        this.nombre = unNombre;
        this.extension = unaExtension;
        this.tamañoEnBytes = unTamañoEnBytes;
    }

    @Override
    public Integer getTamañoEnBytes() {
        return tamañoEnBytes;
    }

    @Override
    public void mostrar(Integer indentacion) {
        String tamañoDeIndentacion = " ".repeat(indentacion);
        System.out.println(tamañoDeIndentacion + "Archivo: " + this.nombre + "." + this.extension + " ("
                + this.tamañoEnBytes + " bytes)");
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Elemento archivoMasPesado() {
        return this;
    }

}
