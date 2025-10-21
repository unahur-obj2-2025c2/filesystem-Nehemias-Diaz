package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.elementos.Elemento; // Asumo que necesitarás esto
import ar.edu.unahur.obj2.elementos.carpetas.Carpeta;

public class FileSystem {
    private static FileSystem instancia;
    private Carpeta carpetaRaiz;

    private FileSystem() {
        this.carpetaRaiz = new Carpeta("root");
    }

    public static FileSystem getInstancia() {
        if (instancia == null) {
            instancia = new FileSystem();
        }
        return instancia;
    }

    public Integer getTamañoTotal() {
        return this.carpetaRaiz.getTamañoEnBytes();
    }

    public void mostrarSistema() {
        this.carpetaRaiz.mostrar(0); 
    }
    
    public Elemento getArchivoMasPesado() {
        return this.carpetaRaiz.archivoMasPesado();
    }
    
    public Carpeta getRaiz() {
        return this.carpetaRaiz;
    }
}