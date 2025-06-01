package org.example;

import org.example.entidades.ItemCarrito;
import org.example.entidades.Producto;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestItemProducto {
    @Test
    public void testConstructorYGetSubtotal() {
        Producto p = new Producto("P001", "Lapicero", 2.5);
        ItemCarrito item = new ItemCarrito(p, 3);
        assertEquals(p, item.getProducto());
        assertEquals(3, item.getCantidad());
        // Subtotal: 2.5 * 3 = 7.5
        assertEquals(7.5, item.getSubtotal(), 0.0001);
    }

    @Test
    public void testConstructorParametrosInvalidos() {
        Producto p = new Producto("P002", "Cuaderno", 5.0);
        // Producto nulo
        assertThrows(IllegalArgumentException.class, () -> new ItemCarrito(null, 2));
        // Cantidad <= 0
        assertThrows(IllegalArgumentException.class, () -> new ItemCarrito(p, 0));
        assertThrows(IllegalArgumentException.class, () -> new ItemCarrito(p, -1));
    }

    @Test
    public void testSettersInvalidos() {
        Producto p1 = new Producto("P003", "Regla", 3.0);
        ItemCarrito item = new ItemCarrito(p1, 1);

        // setProducto a nulo → excepción
        assertThrows(IllegalArgumentException.class, () -> item.setProducto(null));
        // setCantidad a <= 0 → excepción
        assertThrows(IllegalArgumentException.class, () -> item.setCantidad(0));
        assertThrows(IllegalArgumentException.class, () -> item.setCantidad(-5));
    }

    @Test
    public void testModificarCantidadYSubtotal() {
        Producto p = new Producto("P005", "Marcador", 4.0);
        ItemCarrito item = new ItemCarrito(p, 2);
        assertEquals(8.0, item.getSubtotal(), 0.0001);

        item.setCantidad(5);
        assertEquals(5, item.getCantidad());
        assertEquals(20.0, item.getSubtotal(), 0.0001);
    }
}
