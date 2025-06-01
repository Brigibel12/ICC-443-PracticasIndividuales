package org.example;

import org.example.entidades.Producto;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestProducto {
    @Test
    public void testConstructorYGetters() {
        Producto p = new Producto("P001", "Lapicero", 2.5);
        assertEquals("P001", p.getId());
        assertEquals("Lapicero", p.getNombre());
        assertEquals(2.5, p.getPrecio(), 0.0001);
    }

    @Test
    public void testSettersValidos() {
        Producto p = new Producto("P002", "Cuaderno", 10.0);
        p.setNombre("Cuaderno Anillado");
        p.setPrecio(12.0);
        assertEquals("Cuaderno Anillado", p.getNombre());
        assertEquals(12.0, p.getPrecio(), 0.0001);
    }

    @Test
    public void testConstructorParametrosInvalidos() {
        // id nulo
        assertThrows(IllegalArgumentException.class, () -> new Producto(null, "Test", 1.0));
        // nombre vacío
        assertThrows(IllegalArgumentException.class, () -> new Producto("ID", "", 1.0));
        // precio negativo
        assertThrows(IllegalArgumentException.class, () -> new Producto("ID2", "Algo", -5.0));
    }

    @Test
    public void testSettersInvalidos() {
        Producto p = new Producto("P003", "Regla", 3.0);
        // setId nulo o vacío
        assertThrows(IllegalArgumentException.class, () -> p.setId(""));
        assertThrows(IllegalArgumentException.class, () -> p.setId(null));
        // setNombre nulo o vacío
        assertThrows(IllegalArgumentException.class, () -> p.setNombre(null));
        // setPrecio negativo
        assertThrows(IllegalArgumentException.class, () -> p.setPrecio(-1.0));
    }
}
