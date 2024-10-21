package pe.proyecto.ExamenG7.service;

import pe.proyecto.ExamenG7.entity.PersonaEntity;

import java.util.List;

public interface PersonaService {

    PersonaEntity addPerson(PersonaEntity persona);
    PersonaEntity findPersonById(Long id);
    PersonaEntity findPersonByDni(String dni);
    List<PersonaEntity> findPersonALL();
    PersonaEntity updatePerson(PersonaEntity persona, Long id);
    void deletePerson(Long id);
}
