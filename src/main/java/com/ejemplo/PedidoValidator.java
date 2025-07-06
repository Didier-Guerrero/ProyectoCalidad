package com.ejemplo;

/**
 * Valida los datos de un pedido.
 */
public interface PedidoValidator {
  /**
   * Valida los datos del pedido.
   *
   * @param nombreCliente el nombre del cliente
   * @param producto el producto solicitado
   * @throws IllegalArgumentException si los datos no son válidos
   */
  void validar(String nombreCliente, String producto);
}