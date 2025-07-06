package com.ejemplo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class OrderManager {
    private final List<Pedido> pedidos;


    public OrderManager() {
        this.pedidos = new ArrayList<>();
    }


    public void registrarPedido(String nombreCliente, String producto) {
        Objects.requireNonNull(nombreCliente, "El nombre del cliente no puede ser nulo");
        Objects.requireNonNull(producto, "El producto no puede ser nulo");
        if (nombreCliente.trim().isEmpty() || producto.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del cliente y el producto no deben estar vacíos");
        }

        Pedido pedido = new Pedido(nombreCliente, producto);
        pedidos.add(pedido);
    }


    public List<Pedido> obtenerPedidos() {
        return new ArrayList<>(pedidos);
    }


    public static class Pedido {
        private final String nombreCliente;
        private final String producto;


        private Pedido(String nombreCliente, String producto) {
            this.nombreCliente = nombreCliente;
            this.producto = producto;
        }

        public String getNombreCliente() {
            return nombreCliente;
        }


        public String getProducto() {
            return producto;
        }

        @Override
        public String toString() {
            return "Pedido{nombreCliente='" + nombreCliente + "', producto='" + producto + "'}";
        }
    }

    public static void main(String[] args) {
        OrderManager gestorPedidos = new OrderManager();
        gestorPedidos.registrarPedido("Alice", "Laptop");
        gestorPedidos.registrarPedido("Bob", "Phone");
        gestorPedidos.obtenerPedidos().forEach(System.out::println);
    }
}