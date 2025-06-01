package org.example;

import org.example.entidades.CarritoCompra;
import org.example.entidades.ItemCarrito;
import org.example.entidades.Producto;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestCarritoCompra {
    private CarritoCompra carrito;
    private Producto prodA;
    private Producto prodB;

    @Before
    public void setup() {
        carrito = new CarritoCompra();
        prodA = new Producto("A1", "Mouse", 100.0);
        prodB = new Producto("B2", "Teclado", 50.0);
    }

    @Test
    public void testCarritoInicial_Vacio() {
        // Al crearse, no debe tener ítems y el total debe ser 0
        List<ItemCarrito> items = carrito.getItems();
        assertTrue(items.isEmpty());
        assertEquals(0.0, carrito.calcularTotal(), 0.0001);
    }

    @Test
    public void testAgregarProducto_NuevoItem() {
        carrito.agregarProducto(prodA, 2);
        List<ItemCarrito> items = carrito.getItems();
        assertEquals(1, items.size());
        ItemCarrito item = items.get(0);
        assertEquals(prodA, item.getProducto());
        assertEquals(2, item.getCantidad());
        assertEquals(200.0, carrito.calcularTotal(), 0.0001);
    }

    @Test
    public void testAgregarProducto_IncrementarCantidadExistente() {
        carrito.agregarProducto(prodA, 2);
        carrito.agregarProducto(prodA, 3);
        List<ItemCarrito> items = carrito.getItems();
        assertEquals(1, items.size());
        ItemCarrito item = items.get(0);
        assertEquals(5, item.getCantidad());
        assertEquals(500.0, carrito.calcularTotal(), 0.0001);
    }

    @Test
    public void testAgregarProductoParametrosInvalidos() {
        // Producto nulo
        assertThrows(IllegalArgumentException.class, () -> carrito.agregarProducto(null, 1));
        // Cantidad inválida
        assertThrows(IllegalArgumentException.class, () -> carrito.agregarProducto(prodA, 0));
        assertThrows(IllegalArgumentException.class, () -> carrito.agregarProducto(prodA, -3));
    }

    @Test
    public void testEliminarProducto_Existente() {
        carrito.agregarProducto(prodA, 1);
        carrito.eliminarProducto(prodA);
        assertTrue(carrito.getItems().isEmpty());
        assertEquals(0.0, carrito.calcularTotal(), 0.0001);
    }

    @Test
    public void testModificarCantidad_ModificarYCacular() {
        carrito.agregarProducto(prodA, 2);
        carrito.agregarProducto(prodB, 1);
        // ProdA: 2 × 100.0 = 200.0; ProdB: 1 × 50.0 = 50.0; Total = 250.0
        assertEquals(250.0, carrito.calcularTotal(), 0.0001);

        // Cambiar cantidad de prodA a 5: 5 × 100.0 = 500.0; Total = 500.0 + 50.0 = 550.0
        carrito.modificarCantidadProducto(prodA, 5);
        assertEquals(550.0, carrito.calcularTotal(), 0.0001);

        // Establecer cantidad de prodB a 0, debe eliminarse
        carrito.modificarCantidadProducto(prodB, 0);
        // Ahora solo queda prodA: 5 × 100.0 = 500.0
        assertEquals(1, carrito.getItems().size());
        assertEquals(500.0, carrito.calcularTotal(), 0.0001);
    }

    @Test
    public void testModificarCantidad_NoExistente() {
        assertThrows(IllegalArgumentException.class, () -> carrito.modificarCantidadProducto(prodB, 1));
    }

    @Test
    public void testCalcularTotal_VariosItems() {
        carrito.agregarProducto(prodA, 1); // 100.0
        carrito.agregarProducto(prodB, 2); // 2 x 50.0 = 100.0
        assertEquals(200.0, carrito.calcularTotal(), 0.0001);
    }
}
