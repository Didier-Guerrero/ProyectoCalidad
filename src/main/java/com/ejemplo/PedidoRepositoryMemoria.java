package com.ejemplo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Implementación en memoria del repositorio de pedidos.
 */
public class PedidoRepositoryMemoria implements PedidoRepository {
  private final List<Pedido> pedidos = new ArrayList<>();

  @Override
  public void guardar(Pedido pedido) {
    pedidos.add(pedido);
  }

  @Override
  public List<Pedido> obtenerTodos() {
    return Collections.unmodifiableList(pedidos);
  }
}