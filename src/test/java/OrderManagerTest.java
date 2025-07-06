package com.ejemplo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SistemaPedidosTest {

    private OrderManager orderManager;

    @BeforeEach
    void setUp() {
        PedidoRepository repo = new PedidoRepositoryMemoria();
        PedidoValidator validador = new PedidoValidatorImpl();
        orderManager = new OrderManager(repo, validador);
    }

    @Test
    void registrarPedido_Correcto_GuardaPedido() {
        orderManager.registrarPedido("María", "Laptop");

        List<Pedido> pedidos = orderManager.obtenerPedidos();
        assertEquals(1, pedidos.size());

        Pedido pedido = pedidos.get(0);
        assertEquals("María", pedido.getNombreCliente());
        assertEquals("Laptop", pedido.getProducto());
        assertTrue(orderManager.hayPedidos());
    }

    @Test
    void registrarPedido_NombreVacio_LanzaExcepcion() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                orderManager.registrarPedido("", "Tablet"));
        assertEquals("Cliente y producto no pueden estar vacíos", ex.getMessage());
    }

    @Test
    void registrarPedido_ProductoNulo_LanzaExcepcion() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                orderManager.registrarPedido("Carlos", null));
        assertEquals("Cliente y producto no pueden estar vacíos", ex.getMessage());
    }

    @Test
    void registrarPedido_ClienteNulo_LanzaExcepcion() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                orderManager.registrarPedido(null, "Teclado"));
        assertEquals("Cliente y producto no pueden estar vacíos", ex.getMessage());
    }

    @Test
    void registrarPedido_ProductoVacio_LanzaExcepcion() {
        Exception ex = assertThrows(IllegalArgumentException.class, () ->
                orderManager.registrarPedido("Luis", ""));
        assertEquals("Cliente y producto no pueden estar vacíos", ex.getMessage());
    }

    @Test
    void obtenerPedidos_CuandoNoHayPedidos_DevuelveListaVacia() {
        assertTrue(orderManager.obtenerPedidos().isEmpty());
        assertFalse(orderManager.hayPedidos());
    }

    @Test
    void pedido_toString_DevuelveCadenaCorrecta() {
        Pedido pedido = new Pedido("Ana", "Mouse");
        String esperado = "Pedido{nombreCliente='Ana', producto='Mouse'}";
        assertEquals(esperado, pedido.toString());
    }
}
