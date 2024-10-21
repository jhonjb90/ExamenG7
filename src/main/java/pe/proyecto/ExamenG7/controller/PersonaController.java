package pe.proyecto.ExamenG7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.proyecto.ExamenG7.entity.PersonaEntity;
import pe.proyecto.ExamenG7.service.PersonaService;

import java.util.List;

@RestController
@RequestMapping("/persona/v1")
public class PersonaController {

    //Aqui utilizamos inyeccion con la anotacion Autowired
    @Autowired
    private PersonaService personaService;

    @PostMapping("/crear")
    public ResponseEntity<PersonaEntity> crearPersona(@RequestBody PersonaEntity persona){
        PersonaEntity personaNueva = personaService.addPerson(persona);
        return new ResponseEntity<>(personaNueva, HttpStatus.CREATED);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<PersonaEntity> listarPorId(@PathVariable Long id){
        PersonaEntity personaObtenida = personaService.findPersonById(id);
        return new ResponseEntity<>(personaObtenida, HttpStatus.OK);
    }

    @GetMapping("/listardni/{dni}")
    public ResponseEntity<PersonaEntity> listarPorDni(@PathVariable String dni){
        PersonaEntity personaObtenida = personaService.findPersonByDni(dni);
        return new ResponseEntity<>(personaObtenida, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public List<PersonaEntity> listarPersonas(){
        return personaService.findPersonALL();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<PersonaEntity> actualizar(@RequestBody PersonaEntity persona, @PathVariable Long id){
        PersonaEntity personaActualiza = personaService.updatePerson(persona, id);
        return new ResponseEntity<>(personaActualiza, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id){
        personaService.deletePerson(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
