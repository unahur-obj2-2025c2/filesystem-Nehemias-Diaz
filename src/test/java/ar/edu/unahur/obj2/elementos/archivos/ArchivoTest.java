package ar.edu.unahur.obj2.elementos.archivos;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArchivoTest {

    private Archivo archivo;

    @BeforeEach
    void setUp() {
        archivo = new Archivo("Cancion", "mp3", 1500);
    }

    @Test
    void getNombre() {
        assertEquals("Cancion", archivo.getNombre());
    }

    @Test
    void getTamañoEnBytes() {
        assertEquals(1500, archivo.getTamañoEnBytes());
    }

    @Test
    void archivoMasPesado() {
        assertEquals(archivo, archivo.archivoMasPesado());
    }
}