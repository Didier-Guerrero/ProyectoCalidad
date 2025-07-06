package com.ejemplo;

import java.util.List;

/**
 * Gestiona los pedidos de clientes.
 */
public class OrderManager {
  private final PedidoRepository repo;
  private final PedidoValidator validador;

  /**
   * Construye un OrderManager.
   *
   * @param repo repositorio de pedidos
   * @param validador validador de pedidos
   */
  public OrderManager(PedidoRepository repo, PedidoValidator validador) {
    this.repo = repo;
    this.validador = validador;
  }

  /**
   * Registra un nuevo pedido.
   *
   * @param nombreCliente el nombre del cliente
   * @param producto el producto solicitado
   */
  public void registrarPedido(String nombreCliente, String producto) {
    validador.validar(nombreCliente, producto);
    repo.guardar(new Pedido(nombreCliente, producto));
  }

  /**
   * Obtiene todos los pedidos registrados.
   *
   * @return lista de pedidos
   */
  public List<Pedido> obtenerPedidos() {
    return repo.obtenerTodos();
  }

  /**
   * Verifica si hay pedidos registrados.
   *
   * @return true si hay pedidos, false en caso contrario
   */
  public boolean hayPedidos() {
    return !repo.obtenerTodos().isEmpty();
  }
}
