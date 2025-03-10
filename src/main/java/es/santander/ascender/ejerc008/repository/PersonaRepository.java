package es.santander.ascender.ejerc008.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc008.model.Persona;


public interface PersonaRepository extends JpaRepository<Persona, Long> {
    
    @Modifying
    @Transactional
    @Query("UPDATE Persona p SET p.provincia_id = NULL WHERE p.provincia_id.id = :provincia_Id")
    int limpiaProvincia(@Param("provincia_Id") Long provinciaId);

    Optional<Persona> findByDNI(String dni);
}