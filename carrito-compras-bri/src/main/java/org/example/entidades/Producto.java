package org.example.entidades;

public class Producto {
    private String id;
    private String nombre;
    private double precio;

    /*
       Funcion: Contrustor de la clase Producto.
       Argumento: - id (String): Identificador del producto.
                 - nombre (String): Nombre del producto.
                 - precio (double): Precio del producto.
       Objetivo: Inicializar un objeto Producto con los valores proporcionados.
       Retorno: No retorna ningún valor, ya que es un constructor.
    */
    public Producto(String id, String nombre, double precio) {
        validarNoNull(id, "ID");
        validarNoNull(nombre, "Nombre");
        validarPrecioNoNegativo(precio, "Precio");
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        validarNoNull(id, "ID");
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        validarNoNull(nombre, "Nombre");
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        validarPrecioNoNegativo(precio, "Precio");
        this.precio = precio;
    }

    private void validarNoNull(Object valor, String mensajeCampo) {
        if (valor == null) {
            throw new IllegalArgumentException(mensajeCampo + " no puede ser null");
        }
    }

    private void validarPrecioNoNegativo(double precio, String mensajeCampo) {
        if (precio < 0) {
            throw new IllegalArgumentException(mensajeCampo + " no puede ser negativo");
        }
    }
}
