package com.ejemplo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Gestiona los pedidos de clientes, proporcionando funcionalidad para registrar y obtener pedidos.
 * Garantiza una encapsulación adecuada y validación de datos de pedidos.
 */
public class OrderManager {
  private final List<Pedido> pedidos;

  /**
   * Construye un OrderManager con una lista vacía de pedidos.
   */
  public OrderManager() {
    this.pedidos = new ArrayList<>();
  }

  /**
   * Registra un nuevo pedido para un cliente con el producto especificado.
   *
   * @param nombreCliente el nombre del cliente
   * @param producto     el producto solicitado
   * @throws IllegalArgumentException si nombreCliente o producto es nulo o vacío
   */
  public void registrarPedido(String nombreCliente, String producto) {
    Objects.requireNonNull(nombreCliente, "El nombre del cliente no puede ser nulo");
    Objects.requireNonNull(producto, "El producto no puede ser nulo");
    if (nombreCliente.trim().isEmpty() || producto.trim().isEmpty()) {
      throw new IllegalArgumentException(
          "El nombre del cliente y el producto no deben estar vacíos");
    }

    Pedido pedido = new Pedido(nombreCliente, producto);
    pedidos.add(pedido);
  }

  /**
   * Obtiene una lista de solo lectura de todos los pedidos registrados.
   *
   * @return una lista inmodificable de pedidos
   */
  public List<Pedido> obtenerPedidos() {
    return List.copyOf(pedidos);
  }

  /**
   * Representa un pedido realizado por un cliente.
   */
  public static class Pedido {
    private final String nombreCliente;
    private final String producto;

    /**
     * Construye un Pedido con el nombre del cliente y el producto especificados.
     *
     * @param nombreCliente el nombre del cliente
     * @param producto     el producto solicitado
     */
    private Pedido(String nombreCliente, String producto) {
      this.nombreCliente = nombreCliente;
      this.producto = producto;
    }

    /**
     * Obtiene el nombre del cliente para este pedido.
     *
     * @return el nombre del cliente
     */
    public String getNombreCliente() {
      return nombreCliente;
    }

    /**
     * Obtiene el producto para este pedido.
     *
     * @return el producto
     */
    public String getProducto() {
      return producto;
    }

    /**
     * Devuelve una representación en cadena del pedido.
     *
     * @return la representación en cadena del pedido
     */
    @Override
    public String toString() {
      return "Pedido{nombreCliente='" + nombreCliente + "', producto='" + producto + "'}";
    }
  }

  /**
   * Método principal para fines de demostración.
   *
   * @param args argumentos de línea de comandos
   */
  public static void main(String[] args) {
    OrderManager gestorPedidos = new OrderManager();
    gestorPedidos.registrarPedido("Alice", "Laptop");
    gestorPedidos.registrarPedido("Bob", "Phone");
    gestorPedidos.obtenerPedidos().forEach(System.out::println);
  }
}