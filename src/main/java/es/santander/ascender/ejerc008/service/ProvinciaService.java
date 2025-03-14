package es.santander.ascender.ejerc008.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc008.enums.CRUDOperation;
import es.santander.ascender.ejerc008.exception.CrudSecurityException;
import es.santander.ascender.ejerc008.model.Provincia;
import es.santander.ascender.ejerc008.repository.PersonaRepository;
import es.santander.ascender.ejerc008.repository.ProvinciaRepository;


@Service
@Transactional
public class ProvinciaService {

    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    // Create
    public Provincia createProvincia(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    // Read (all)
    @Transactional(readOnly = true)
    public List<Provincia> getAllProvincias() {
        return provinciaRepository.findAll();
    }

    // Read (by ID)
    @Transactional(readOnly = true)
    public Optional<Provincia> getProvinciaById(Long id) {
        return provinciaRepository.findById(id);
    }

    // Update
    public Provincia update(Provincia provincia) {
        if (provincia.getId() == null) {
            throw new CrudSecurityException("Han tratado de crear un registro Provincia utilizando la modifición",
                                                 CRUDOperation.UPDATE, 
                                                 null);           
        }
        return provinciaRepository.save(provincia);
    }

    //Delete
    public void deleteProvincia(Long id) {
    
        personaRepository.limpiaProvincia(id);  // Deja en null el Id de todas las personas en esa provincia antes de borrar la provincia.  
        provinciaRepository.deleteById(id);
    }
}