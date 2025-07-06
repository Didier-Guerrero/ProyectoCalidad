package com.ejemplo;

/**
 * Implementación de validador de pedidos.
 */
public class PedidoValidatorImpl implements PedidoValidator {
  @Override
  public void validar(String nombreCliente, String producto) {
    if (nombreCliente == null
            || nombreCliente.isEmpty()
            || producto == null
            || producto.isEmpty()) {
      throw new IllegalArgumentException("Cliente y producto no pueden estar vacíos");
    }
  }

  /**
   * Verifica si un pedido es válido.
   *
   * @param pedido el pedido a validar
   * @return true si el pedido es válido, false de lo contrario
   */
  public boolean esValido(Pedido pedido) {
    return pedido.getNombreCliente() != null
            && !pedido.getNombreCliente().isEmpty()
            && pedido.getProducto() != null
            && !pedido.getProducto().isEmpty();
  }
}