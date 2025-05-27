package org.esteban.ManejoDeSesiones.models;

public class Categoría {

    //Implementar e inicializar las variables de objeto encapsulados

    private  Long  idCategoria;
    private  String nombre;
    private String descripcion;
    private  int  condicion;

public Categoría() {

}
public Categoría(Long idCategoria, String nombre, String descripcion, int condicion) {
    this.idCategoria=idCategoria;
    this.nombre=nombre;
    this.descripcion=descripcion;
    this.condicion=condicion;
}

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCondicion() {
        return condicion;
    }

    public void setCondicion(int condicion) {
        this.condicion = condicion;
    }
}

