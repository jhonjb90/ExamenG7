package pe.proyecto.ExamenG7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.proyecto.ExamenG7.entity.PersonaEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<PersonaEntity, Long> {

    //para buscar a todos por estado ejmeplo "activo"
    List<PersonaEntity> findAllByEstado(String estado);

    //para buscar por dni
    Optional<PersonaEntity> findByDni(String dni);
}
