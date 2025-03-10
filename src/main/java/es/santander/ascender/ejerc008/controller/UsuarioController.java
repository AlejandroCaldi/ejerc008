package es.santander.ascender.ejerc008.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.santander.ascender.ejerc008.model.Usuario;
import es.santander.ascender.ejerc008.service.UsuarioService;
import jakarta.validation.Valid;

@PreAuthorize("hasRole('USER')")
@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    // Create
    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody @Valid Usuario usuario) {
        if (usuario.getId() == null) {
            Usuario createdUsuario = usuarioService.createUsuario(usuario);
            if (createdUsuario != null) {
                return new ResponseEntity<>(createdUsuario, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(HttpStatus.CONFLICT);
            }
        }
        return new ResponseEntity<>(HttpStatus.CONFLICT);

    }

    // Read (all)
    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

    // Read (by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        Optional<Usuario> usuario = Optional.ofNullable(usuarioService.getUsuarioById(id));
        if (usuario.isPresent()) {
            return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody @Valid Usuario usuarioDetails) throws Exception {
        Usuario updatedUsuario = usuarioService.updateUsuario(id, usuarioDetails);

        if (updatedUsuario != null) {
            return new ResponseEntity<>(updatedUsuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long id) {
        boolean deleted = usuarioService.deleteUsuario(id);
        if (!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}