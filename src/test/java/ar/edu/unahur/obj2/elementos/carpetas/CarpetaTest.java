package ar.edu.unahur.obj2.elementos.carpetas;

import ar.edu.unahur.obj2.elementos.archivos.Archivo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarpetaTest {

    private Carpeta carpetaRaiz;
    private Archivo archivo100;
    private Archivo archivo500;
    private Archivo archivo800;
    private Carpeta subCarpeta;

    @BeforeEach
    void setUp() {
        carpetaRaiz = new Carpeta("MiMusica");
        subCarpeta = new Carpeta("Rock");

        archivo100 = new Archivo("Playlist", "txt", 100);
        archivo500 = new Archivo("Foto", "jpg", 500);
        archivo800 = new Archivo("Tema", "mp3", 800);
    }

    @Test
    void getNombre() {
        assertEquals("MiMusica", carpetaRaiz.getNombre());
    }

    @Test
    void carpetaVacia() {
        assertEquals(0, carpetaRaiz.getTamañoEnBytes());
        assertNull(carpetaRaiz.archivoMasPesado());
        carpetaRaiz.mostrar(0); 
    }

    @Test
    void getTamañoEnBytesConHijos() {
        carpetaRaiz.agregarElemento(archivo100);
        carpetaRaiz.agregarElemento(archivo500);
        assertEquals(600, carpetaRaiz.getTamañoEnBytes());
    }

    @Test
    void eliminarElemento() {
        carpetaRaiz.agregarElemento(archivo100);
        assertEquals(100, carpetaRaiz.getTamañoEnBytes());

        carpetaRaiz.eliminarElemento(archivo100);
        assertEquals(0, carpetaRaiz.getTamañoEnBytes());
    }

    @Test
    void eliminarElementoInexistente() {
        assertThrows(IllegalArgumentException.class, () -> {
            carpetaRaiz.eliminarElemento(archivo100);
        });
    }

    @Test
    void archivoMasPesadoConHijos() {
        carpetaRaiz.agregarElemento(archivo100);
        carpetaRaiz.agregarElemento(archivo500);
        assertSame(archivo500, carpetaRaiz.archivoMasPesado());
    }

    @Test
    void testRecursividad() {
        subCarpeta.agregarElemento(archivo800);
        subCarpeta.agregarElemento(archivo500);
        
        carpetaRaiz.agregarElemento(archivo100);
        carpetaRaiz.agregarElemento(subCarpeta);

        //tamaño(100 + (800 + 500))
        assertEquals(1400, carpetaRaiz.getTamañoEnBytes());

        //archivo más pesado
        assertSame(archivo800, carpetaRaiz.archivoMasPesado());

        carpetaRaiz.mostrar(0);
    }
}