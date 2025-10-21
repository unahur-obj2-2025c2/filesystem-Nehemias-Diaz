package ar.edu.unahur.obj2.elementos;

public interface Elemento {
    public Integer getTamañoEnBytes();

    public void mostrar(Integer indentacion);

    public String getNombre();

    public Elemento archivoMasPesado();
}
