package pe.proyecto.ExamenG7.service;

import pe.proyecto.ExamenG7.entity.PedidoEntity;

import java.util.List;

public interface PedidoService {
    PedidoEntity guardarPedido(Long id, PedidoEntity pedido);
    PedidoEntity obtenerPedidoPorId(Long id);
    List<PedidoEntity> obtenerTodosLosPedidos();
    PedidoEntity actualizarPedido(Long id, PedidoEntity pedido);
    void eliminarPedido(Long id);

}
