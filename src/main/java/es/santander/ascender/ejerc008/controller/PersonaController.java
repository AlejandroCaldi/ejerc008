package es.santander.ascender.ejerc008.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejerc008.model.Persona;
import es.santander.ascender.ejerc008.service.PersonaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/persona")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    // Create
    @PostMapping
    public ResponseEntity<Persona> createPersona(@RequestBody @Valid Persona persona) {
        if (persona.getId() == null) {
            Persona createdPersona = personaService.createPersona(persona);
            if (createdPersona != null) {
                return new ResponseEntity<>(createdPersona, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.CONFLICT);

    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<Persona>> getAllPersonas() {
        List<Persona> personas = personaService.getAllPersonas();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) {
        Optional<Persona> persona = Optional.ofNullable(personaService.getPersonaById(id));
        if (persona.isPresent()) {
            return new ResponseEntity<>(persona.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Read (by ID)
    @GetMapping("/{dni}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable String dni) {
        Optional<Persona> persona = Optional.ofNullable(personaService.getPersonaByDNI(dni));
        if (persona.isPresent()) {
            return new ResponseEntity<>(persona.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Persona> updatePersona(@PathVariable Long id, @RequestBody Persona personaDetails) throws Exception {
        Persona updatedPersona = personaService.updatePersona(id, personaDetails);

        if (updatedPersona != null) {
            return new ResponseEntity<>(updatedPersona, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
        boolean deleted = personaService.deletePersona(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}