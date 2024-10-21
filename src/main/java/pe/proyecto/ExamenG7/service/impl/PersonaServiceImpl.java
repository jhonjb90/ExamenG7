package pe.proyecto.ExamenG7.service.impl;

import org.springframework.stereotype.Service;
import pe.proyecto.ExamenG7.entity.PersonaEntity;
import pe.proyecto.ExamenG7.repository.PersonaRepository;
import pe.proyecto.ExamenG7.service.PersonaService;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonaServiceImpl implements PersonaService {

    //utilizaremos inyeccion por constructor
    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    //creamos una nueva persona
    @Override
    public PersonaEntity addPerson(PersonaEntity persona) {
        persona.setEstado("ACTIVO");
        return personaRepository.save(persona);
    }

    //vamos a buscar por el Id
    @Override
    public PersonaEntity findPersonById(Long id) {
        return personaRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("Persona No encontrada"));
    }

    //vamos a buscar por el dni
    @Override
    public PersonaEntity findPersonByDni(String dni) {
        return personaRepository.findByDni(dni)
                .orElseThrow(()-> new NoSuchElementException("Persona No encontrada por Dni"));
    }

    //vamos a buscar a todo los que tengan el estado ACTIVO
    @Override
    public List<PersonaEntity> findPersonALL() {
        //return personaRepository.findAll();
        return personaRepository.findAllByEstado("ACTIVO");
    }

    //Hacemos una actualizacion
    @Override
    public PersonaEntity updatePerson(PersonaEntity persona, Long id) {
        PersonaEntity personaEncontrada = findPersonById(id);
        personaEncontrada.setDni(persona.getDni());
        personaEncontrada.setNombre(persona.getNombre());
        personaEncontrada.setApellido(persona.getApellido());
        personaEncontrada.setDireccionEntity(persona.getDireccionEntity());
        return personaRepository.save(personaEncontrada);
    }

    //y aqui ponemos a estado inactivo
    @Override
    public void deletePerson(Long id) {
        PersonaEntity personaBuscada = findPersonById(id);
        personaBuscada.setEstado("INACTIVO");
        personaRepository.save(personaBuscada);
       // personaRepository.delete(personaBuscada);
    }
}
