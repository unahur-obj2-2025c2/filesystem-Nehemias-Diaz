package ar.edu.unahur.obj2;

import ar.edu.unahur.obj2.elementos.archivos.Archivo;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class FileSystemTest {

    @BeforeEach
    void resetSingleton() throws Exception {
        Field instancia = FileSystem.class.getDeclaredField("instancia");
        instancia.setAccessible(true);
        instancia.set(null, null);
    }

    @Test
    void getInstancia() {
        FileSystem fs1 = FileSystem.getInstancia();
        FileSystem fs2 = FileSystem.getInstancia();

        assertNotNull(fs1);
        assertSame(fs1, fs2, "getInstancia() debe devolver siempre el mismo objeto");
    }

    @Test
    void raizInicializadaVacia() {
        FileSystem fs = FileSystem.getInstancia();

        assertEquals(0, fs.getTamañoTotal());
        assertNull(fs.getArchivoMasPesado());
        assertNotNull(fs.getRaiz());
        assertEquals("root", fs.getRaiz().getNombre());
    }

    @Test
    void delegaLlamadas() {
        FileSystem fs = FileSystem.getInstancia();
        Archivo archivo = new Archivo("Test", "txt", 123);

        fs.getRaiz().agregarElemento(archivo);

        assertEquals(123, fs.getTamañoTotal());
        assertSame(archivo, fs.getArchivoMasPesado());
    }

    @Test
    void mostrarSistema() {
        FileSystem fs = FileSystem.getInstancia();
        fs.getRaiz().agregarElemento(new Archivo("Test", "txt", 10));

        fs.mostrarSistema();
    }
}