package org.example.entidades;

import java.util.ArrayList;
import java.util.List;

public class CarritoCompra {
    private List<ItemCarrito> items;

    /*
       Funcion: Constructor de la clase CarritoCompra por defecto.
       Objetivo: Inicializar un objeto CarritoCompra con una lista vacía de items.
       Retorno: No retorna ningún valor, ya que es un constructor.
    */
    public CarritoCompra() {
        this.items = new ArrayList<>();
    }

    /*
       Funcion: Constructor de la clase CarritoCompra.
       Argumento: - items (List<ItemCarrito>): Lista de items en el carrito.
       Objetivo: Inicializar un objeto CarritoCompra con los items proporcionados.
       Retorno: No retorna ningún valor, ya que es un constructor.
    */
    public CarritoCompra(List<ItemCarrito> items) {
        validarNoNull(items, "Items");
        this.items = items;
    }

    // Getters y setters

    public List<ItemCarrito> getItems() {
        return items;
    }
    public void setItems(List<ItemCarrito> items) {
        validarNoNull(items, "Items");
        this.items = items;
    }

    /*
       Funcion: Agregar un producto al carrito de compra.
       Argumento: - producto (Producto): Producto a agregar al carrito.
                  - cantidad (int): Cantidad del producto a agregar.
       Objetivo: Añadir un item al carrito de compra o si ya existe aumentar su cantidad.
       Retorno: No retorna ningún valor.
    */
    public void agregarProducto(Producto producto, int cantidad) {
        validarNoNull(producto, "Item");
        validarCantidadNoNegativa(cantidad, "Cantidad");

        for (ItemCarrito ic : items) {
            if (ic.getProducto().equals(producto)) {
                // Si ya existe, simplemente se aumenta la cantidad
                ic.setCantidad(ic.getCantidad() + cantidad);
                return;
            }
        }
        // Si no existe, se crea uno nuevo
        items.add(new ItemCarrito(producto, cantidad));
    }

    /*
       Funcion: Eliminar un producto del carrito de compra.
       Argumento: - producto (Producto): Producto a eliminar del carrito.
       Objetivo: Eliminar un item del carrito de compra.
       Retorno: No retorna ningún valor.
    */
    public void eliminarProducto(Producto producto) {
        validarNoNull(producto, "Item");
        items.removeIf(ic -> ic.getProducto().equals(producto));
    }

    /*
       Funcion: Modificar la cantidad de un producto en el carrito de compra.
       Argumento: - producto (Producto): Producto cuyo item se desea modificar.
                  - nuevaCantidad (int): Nueva cantidad del producto.
       Objetivo: Actualizar la cantidad de un item en el carrito de compra o eliminarlo si la cantidad es 0.
       Retorno: No retorna ningún valor.
    */
    public void modificarCantidadProducto(Producto producto, int nuevaCantidad) {
        validarNoNull(producto, "Item");
        validarCantidadNoNegativa(nuevaCantidad, "Nueva cantidad");

        for (ItemCarrito ic : items) {
            if (ic.getProducto().equals(producto)) {
                if (nuevaCantidad == 0) {
                    // Si la nueva cantidad es 0, se elimina el producto
                    items.remove(ic);
                } else {
                    ic.setCantidad(nuevaCantidad);
                }
                return;
            }
        }
        throw new IllegalArgumentException("El producto no está en el carrito");
    }

    /*
        Funcion: Calcular el total del carrito de compra.
        Objetivo: Sumar el subtotal de todos los items en el carrito.
        Retorno: Retorna el total como un double.
    */
    public double calcularTotal() {
        double total = 0.0;
        for (ItemCarrito ic : items) {
            total += ic.getSubtotal();
        }
        return total;
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
        Funcion: Valida que una cantidad no sea negativa.
        Argumento: - cantidad (int): Cantidad a validar.
              - mensajeCampo (String): Mensaje de error en caso de que la cantidad sea negativa.
        Objetivo: Lanzar una excepción si la cantidad es negativa.
        Retorno: No retorna ningún valor.
    */
    private void validarCantidadNoNegativa(int cantidad, String mensajeCampo) {
        if (cantidad < 0) {
            throw new IllegalArgumentException(mensajeCampo + " no puede ser negativa");
        }
    }
}
