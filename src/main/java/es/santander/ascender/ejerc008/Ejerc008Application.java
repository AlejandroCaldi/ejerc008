package es.santander.ascender.ejerc008;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import es.santander.ascender.ejerc008.model.Persona;
import es.santander.ascender.ejerc008.model.Provincia;
import es.santander.ascender.ejerc008.service.PersonaService;
import es.santander.ascender.ejerc008.service.ProvinciaService;


@SpringBootApplication
public class Ejerc008Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejerc008Application.class, args);
	}
@Bean
    public CommandLineRunner dataLoader(ProvinciaService provinciaService, PersonaService personaService) {
        return args -> {
            // Create some provincias
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

            // Create some personas
            Persona persona1 = new Persona();
            persona1.setNombre("Alice");
            persona1.setApellidos("Smith");
            persona1.setDNI("Z1245678A");
            persona1.setProvincia(burgos);
            personaService.createPersona(persona1);

            Persona persona2 = new Persona();
            persona2.setNombre("Bob");
            persona2.setApellidos("Johnson");
            persona2.setDNI("98765432B");
            persona2.setProvincia(madrid);
            personaService.createPersona(persona2);

            Persona persona3 = new Persona();
            persona3.setNombre("Charlie");
            persona3.setApellidos("Williams");
            persona3.setDNI("56789012C");
            persona3.setProvincia(barcelona);
            personaService.createPersona(persona3);
            
             Persona persona4 = new Persona();
            persona4.setNombre("Alejandro");
            persona4.setApellidos("Caldi");
            persona4.setDNI("Z0841445H");
            persona4.setProvincia(burgos);
            personaService.createPersona(persona4);
        };
    }
}