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

import es.santander.ascender.ejerc008.model.Provincia;
import es.santander.ascender.ejerc008.service.ProvinciaService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/provincia")
public class ProvinciaController {

    @Autowired
    private ProvinciaService provinciaService;

    // Create
    @PostMapping
    public ResponseEntity<Provincia> createProvincia(@RequestBody @Valid Provincia provincia) {
        Provincia createdProvincia = provinciaService.createProvincia(provincia);
        if (createdProvincia == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(createdProvincia, HttpStatus.CREATED);
    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<Provincia>> getTodasProvincias() {
        List<Provincia> expedientes = provinciaService.getAllProvincias();
        return new ResponseEntity<>(expedientes, HttpStatus.OK);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Provincia> getProvinciaById(@PathVariable Long id) {
        Optional<Provincia> provincia = provinciaService.getProvinciaById(id);
        if (provincia.isPresent()) {
            return new ResponseEntity<>(provincia.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    
    @PutMapping("/{id}")
    public ResponseEntity<Provincia> updateExpediente(@PathVariable Long id, @RequestBody @Valid Provincia provinciaDetails) {
               
        Provincia updatedProvincia = provinciaService.update(provinciaDetails);
        if (updatedProvincia != null) {
            return new ResponseEntity<>(updatedProvincia, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProvincia(@PathVariable Long id) {
        provinciaService.deleteProvincia(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}