package es.santander.ascender.ejerc008.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc008.model.Persona;


public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByDNI(String dni);
    
    @Modifying
    @Transactional
    @Query("update Persona p set p.provincia.id = null where p.provincia.id = ?1")
    public int limpiaProvincia(Long provinciaId);
}