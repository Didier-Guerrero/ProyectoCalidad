package com.ejemplo;

public class Main {
    public static void main(String[] args) {
        PedidoRepository repo = new PedidoRepositoryMemoria();
        PedidoValidator validador = new PedidoValidatorImpl();
        OrderManager manager = new OrderManager(repo, validador);

        manager.registrarPedido("Alice", "Laptop");
        manager.registrarPedido("Bob", "Tablet");
        manager.registrarPedido("Carlos", "Smartphone");
        manager.registrarPedido("Diana", "Monitor");
        manager.registrarPedido("Elena", "Teclado");
        manager.registrarPedido("Fernando", "Mouse");
        manager.registrarPedido("Gabriela", "Impresora");
        manager.registrarPedido("Hugo", "Auriculares");
        manager.registrarPedido("Irene", "Webcam");
        manager.registrarPedido("Javier", "Disco Duro");

        for (Pedido p : manager.obtenerPedidos()) {
            System.out.println(p);
        }
    }
} 