package com.ejemplo;

import java.util.List;

/**
 * Repositorio de pedidos.
 */
public interface PedidoRepository {
  /**
   * Guarda un pedido.
   *
   * @param pedido el pedido a guardar
   */
  void guardar(Pedido pedido);

  /**
   * Obtiene todos los pedidos.
   *
   * @return lista de pedidos
   */
  List<Pedido> obtenerTodos();
}