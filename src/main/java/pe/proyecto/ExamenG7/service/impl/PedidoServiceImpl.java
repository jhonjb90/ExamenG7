package pe.proyecto.ExamenG7.service.impl;

import org.springframework.stereotype.Service;
import pe.proyecto.ExamenG7.entity.PedidoEntity;
import pe.proyecto.ExamenG7.entity.PersonaEntity;
import pe.proyecto.ExamenG7.repository.PedidoRepository;
import pe.proyecto.ExamenG7.repository.PersonaRepository;
import pe.proyecto.ExamenG7.service.PedidoService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final PersonaRepository personaRepository;

    public PedidoServiceImpl(PedidoRepository pedidoRepository, PersonaRepository personaRepository) {
        this.pedidoRepository = pedidoRepository;
        this.personaRepository = personaRepository;
    }

    @Override
    public PedidoEntity guardarPedido(Long id, PedidoEntity pedido) {
        PersonaEntity personaExiste = personaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Error Persona no existe"));
        pedido.setPersona(personaExiste);
        return pedidoRepository.save(pedido);
    }

    @Override
    public PedidoEntity obtenerPedidoPorId(Long id) {
        return pedidoRepository.findById(id).orElseThrow(()
                -> new NoSuchElementException("Pedido no encontrado"));
    }

    @Override
    public List<PedidoEntity> obtenerTodosLosPedidos() {
        return pedidoRepository.findAll();
    }

    @Override
    public PedidoEntity actualizarPedido(Long id, PedidoEntity pedido) {
        PedidoEntity pedidoExistente = obtenerPedidoPorId(id);
        pedidoExistente.setDescripcion(pedido.getDescripcion());
        pedidoExistente.setCantidad(pedido.getCantidad());
        return pedidoRepository.save(pedidoExistente);
    }

    @Override
    public void eliminarPedido(Long id) {
        PedidoEntity pedidoExistente = obtenerPedidoPorId(id);
        pedidoRepository.delete(pedidoExistente);
    }
}
