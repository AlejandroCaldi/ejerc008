package es.santander.ascender.ejerc008.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc008.model.Persona;
import es.santander.ascender.ejerc008.repository.PersonaRepository;

@Service
@Transactional
public class PersonaService {
    @Autowired
    private PersonaRepository personaRepository;

    // Create
    public Persona createPersona(Persona persona) {
        Optional<Persona> personaOptional = personaRepository.findByDNI(persona.getDNI());
        if (!personaOptional.isPresent()) {
            return personaRepository.save(persona);
        }
        return personaOptional.get();
    }

    // Read (all)
    @Transactional(readOnly = true)
    public List<Persona> getAllPersonas() {
        return personaRepository.findAll();
    }

    // Read (by ID)
    @Transactional(readOnly = true)
    public Persona getPersonaById(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    // Read (by DNI)
    @Transactional(readOnly = true)
    public Persona getPersonaByDNI(String dni) {
        return personaRepository.findByDNI(dni).orElse(null);
    }

    // Update
    public Persona updatePersona(Long id, Persona personaDetails) {
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if (personaOptional.isPresent()) {
            Persona persona = personaOptional.get();
                    persona.setDNI(personaDetails.getDNI());
                    persona.setProvincia(personaDetails.getProvincia());
                    persona.setNombre(personaDetails.getNombre());
                    persona.setApellidos(personaDetails.getApellidos());
                    persona.setUsuario(personaDetails.getUsuario());
                    return personaRepository.save(persona);
        }
        return null;
    }

    // Delete
    public boolean deletePersona(Long id) {
        Optional<Persona> personaOptional = personaRepository.findById(id);
        if (personaOptional.isPresent()) {
            personaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
