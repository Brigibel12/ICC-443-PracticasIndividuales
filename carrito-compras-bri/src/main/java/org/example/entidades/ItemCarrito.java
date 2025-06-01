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
        validarCantidadMayorACero(cantidad, "Cantidad");
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
        validarCantidadMayorACero(cantidad, "Cantidad");
        this.cantidad = cantidad;
    }

    /*
        Funcion: Valida que un valor no sea null.
        Argumento: - valor (Object): Valor a validar.
                - mensajeCampo (String): Mensaje de error en caso de que el valor sea null.
        Objetivo: Lanzar una excepción si el valor es null.
        Retorno: No retorna ningún valor.
    */
    private void validarNoNull(Object valor, String mensajeCampo) {
        if (valor == null) {
            throw new IllegalArgumentException(mensajeCampo + " no puede ser null");
        }
    }

    /*
        Funcion: Valida que una cantidad sea mayor que cero.
        Argumento: - cantidad (int): Cantidad a validar.
              - mensajeCampo (String): Mensaje de error en caso de que la cantidad sea menor o igual a 0.
        Objetivo: Lanzar una excepción si la cantidad es negativa o si es igual a cero.
        Retorno: No retorna ningún valor.
     */
    private void validarCantidadMayorACero(int cantidad, String mensajeCampo) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException(mensajeCampo + " no puede ser negativa ni igual a cero");
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
