package es.santander.ascender.ejerc008.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.santander.ascender.ejerc008.model.Persona;
import es.santander.ascender.ejerc008.model.Usuario;
import es.santander.ascender.ejerc008.repository.UsuarioRepository;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PersonaService personaService;
 
    // Create
    public Usuario createUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Read (all)
    @Transactional(readOnly = true)
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Read (by ID)
    @Transactional(readOnly = true)
    public Usuario getUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    // Update
    public Usuario updateUsuario(Long id, Usuario usuarioDetails) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
                    usuario.setUsuario(usuarioDetails.getUsuario());
                    usuario.setEmail(usuarioDetails.getEmail());
                    usuario.setPersona_id(usuarioDetails.getPersona_id());
                    return usuarioRepository.save(usuario);
        }
        return null;
    }

    // Delete
    public boolean deleteUsuario(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            Persona persona = usuario.getPersona_id();
            if (persona != null) {
                persona.setUsuario(null); 
                personaService.updatePersona(persona.getId(), persona); 
            }
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
