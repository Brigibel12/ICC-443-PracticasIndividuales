package org.example.entidades;

public class ItemCarrito {
    private Producto producto;
    private int cantidad;

    /*
       Funcion: Constructor de la clase ItemCarrito.
       Argumento: - producto (Producto): Producto asociado al item del carrito.
                 - cantidad (int): Cantidad del producto en el carrito.
       Objetivo: Inicializar un objeto ItemCarrito con los valores proporcionados.
       Retorno: No retorna ningún valor, ya que es un constructor.
    */
    public ItemCarrito(Producto producto, int cantidad) {
        validarNoNull(producto, "Producto");
        validarCantidadNoNegativa(cantidad, "Cantidad");
        this.producto = producto;
        this.cantidad = cantidad;
    }

    // Getters y setters

    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        validarNoNull(producto, "Producto");
        this.producto = producto;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        validarCantidadNoNegativa(cantidad, "Cantidad");
        this.cantidad = cantidad;
    }
    private void validarNoNull(Object valor, String mensajeCampo) {
        if (valor == null) {
            throw new IllegalArgumentException(mensajeCampo + " no puede ser null");
        }
    }
    private void validarCantidadNoNegativa(int cantidad, String mensajeCampo) {
        if (cantidad < 0) {
            throw new IllegalArgumentException(mensajeCampo + " no puede ser negativa");
        }
    }

    /*
       Funcion: Calcula el subtotal del item del carrito.
       Objetivo: Calcular el subtotal multiplicando el precio del producto por la cantidad.
       Retorno: Retorna el subtotal como un valor double.
    */

    public double getSubtotal() {
        return producto.getPrecio() * cantidad;
    }
}
