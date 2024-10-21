package pe.proyecto.ExamenG7.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.proyecto.ExamenG7.entity.PedidoEntity;
import pe.proyecto.ExamenG7.service.PedidoService;

import java.util.List;

@RestController
@RequestMapping("/pedidos/v1")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/crear/{id}")
    public ResponseEntity<PedidoEntity> crearPedido(@PathVariable Long id,
                                                    @RequestBody PedidoEntity pedido) {
        PedidoEntity nuevoPedido = pedidoService.guardarPedido(id, pedido);
        return new ResponseEntity<>(nuevoPedido, HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<PedidoEntity> obtenerPedido(@PathVariable Long id) {
        PedidoEntity pedido = pedidoService.obtenerPedidoPorId(id);
        return new ResponseEntity<>(pedido, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<PedidoEntity> obtenerTodosLosPedidos() {
        return pedidoService.obtenerTodosLosPedidos();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminarPedido(@PathVariable Long id) {
        pedidoService.eliminarPedido(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
