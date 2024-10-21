package pe.proyecto.ExamenG7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.proyecto.ExamenG7.entity.PedidoEntity;

public interface PedidoRepository extends JpaRepository<PedidoEntity, Long> {
}
