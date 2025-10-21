package ar.edu.unahur.obj2.elementos.carpetas;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.elementos.Elemento;

public class Carpeta implements Elemento {
    private String nombre;
    private List<Elemento> elementos;

    public Carpeta(String unNombre) {
        this.nombre = unNombre;
        this.elementos = new ArrayList<>();
    }

    public void agregarElemento(Elemento unElemento) {
        this.elementos.add(unElemento);
    }

    public void eliminarElemento(Elemento unElemento) {
        if (this.elementos.contains(unElemento)) {
            this.elementos.remove(unElemento);
        } else {
            throw new IllegalArgumentException("El elemento no se encuentra en la carpeta");
        }
    }

    @Override
    public Integer getTamañoEnBytes() {
        return elementos.stream().mapToInt(Elemento::getTamañoEnBytes).sum();
    }

    @Override
    public void mostrar(Integer indentacion) {
        String tamañoDeIndentacion = " ".repeat(indentacion);
        System.out.println(tamañoDeIndentacion + "Carpeta: " + this.nombre);
        elementos.forEach(e -> e.mostrar(indentacion + 2));
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public Elemento archivoMasPesado() {
        return this.elementos.stream()
                .map(Elemento::archivoMasPesado)
                .max((elemento1, elemento2) -> elemento1.getTamañoEnBytes()
                .compareTo(elemento2.getTamañoEnBytes()))
                .orElse(null);
    }
}
