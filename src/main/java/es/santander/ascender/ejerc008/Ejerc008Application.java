package es.santander.ascender.ejerc008;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import es.santander.ascender.ejerc008.model.Persona;
import es.santander.ascender.ejerc008.model.Provincia;
import es.santander.ascender.ejerc008.model.Usuario;
import es.santander.ascender.ejerc008.service.PersonaService;
import es.santander.ascender.ejerc008.service.ProvinciaService;
import es.santander.ascender.ejerc008.service.UsuarioService;


@SpringBootApplication
public class Ejerc008Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejerc008Application.class, args);
	}
    @Bean
    public CommandLineRunner dataLoader(ProvinciaService provinciaService, PersonaService personaService, UsuarioService usuarioService) {
        return args -> {
            // Crea algunas provincias
            Provincia burgos = new Provincia();
            burgos.setNombre("Burgos");
            burgos.setPoblacion(300000l);
            burgos.setSuperficie(14300);
            provinciaService.createProvincia(burgos);

            Provincia madrid = new Provincia();
            madrid.setNombre("Madrid");
            madrid.setPoblacion(6000000l);
            madrid.setSuperficie(8028);
            provinciaService.createProvincia(madrid);

            Provincia barcelona = new Provincia();
            barcelona.setNombre("Barcelona");
            barcelona.setPoblacion(5000000l);
            barcelona.setSuperficie(7728);
            provinciaService.createProvincia(barcelona);

            // Crea algunas personas
            Persona persona1 = new Persona();
            persona1.setNombre("Alice");
            persona1.setApellidos("Smith");
            persona1.setDNI("Z1245678A");
            persona1.setProvincia(burgos);
            persona1 = personaService.createPersona(persona1); 

            Persona persona2 = new Persona();
            persona2.setNombre("Bob");
            persona2.setApellidos("Johnson");
            persona2.setDNI("98765432B");
            persona2.setProvincia(madrid);
            persona2 = personaService.createPersona(persona2); 

            Persona persona3 = new Persona();
            persona3.setNombre("Charlie");
            persona3.setApellidos("Williams");
            persona3.setDNI("56789012C");
            persona3.setProvincia(barcelona);
            persona3 = personaService.createPersona(persona3); 
        
            Persona persona4 = new Persona();
            persona4.setNombre("Alejandro");
            persona4.setApellidos("Caldi");
            persona4.setDNI("Z0841445H");
            persona4.setProvincia(burgos);
            persona4 = personaService.createPersona(persona4); 
            

             // Crea algunos usuarios vinculados a personas
            Usuario usuario1 = new Usuario();
            usuario1.setUsuario("alice.smith");
            usuario1.setEmail("alice.smith@example.com");
            usuario1.setPersona_id(persona1);
            usuarioService.createUsuario(usuario1);

            Usuario usuario2 = new Usuario();
            usuario2.setUsuario("bob.johnson");
            usuario2.setEmail("bob.johnson@example.com");
            usuario2.setPersona_id(persona2);
            usuarioService.createUsuario(usuario2);

            Usuario usuario3 = new Usuario();
            usuario3.setUsuario("charlie.williams");
            usuario3.setEmail("charlie.williams@example.com");
            usuario3.setPersona_id(persona3);
            usuarioService.createUsuario(usuario3);
            
            Usuario usuario4 = new Usuario();
            usuario4.setUsuario("alejandro.caldi");
            usuario4.setEmail("ale.caldi@example.com");
            usuario4.setPersona_id(persona4);
            usuarioService.createUsuario(usuario4);
        };
    }
}