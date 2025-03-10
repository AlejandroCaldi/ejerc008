package es.santander.ascender.ejerc008.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.santander.ascender.ejerc008.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    
}