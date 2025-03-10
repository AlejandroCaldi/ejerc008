# ejerc008
Relaciòn en JPA entre Provincia y persona

entidad llamada persona
entidad llamada provincia
4 campos para persona, pero uno es la provincia. 
en provincia, precisamos la operaciones de crud, salvo la de borrado, sin borrado lógico. 
3:00:01
Persona que tenga todas las operaciones de crud. 
Una persona tiene una provincia. Vacía? por ahora, no. 
Relación de provincia a persona una a muchas. 

Cuando actualizo la persona npuedo cambiar la provincia. que la actualizaciòn sea de la persona, en JPA, pero no de la provincia. Qiue no borre la provincia ni que agergue ni cambie. 
no quiero que cuando cree la persona y le pongo por error una provincia que no existe que me la cree (no debe crear provincia). Entonces vamos a tener que actualizar perso,s ni crear ni modificar provincia. 

Si borro la persona, que no borre, obviamente, la provincia. 
Sin enums.

Version 0.2.0 -- levanta el servidor sin problemas. Resta chequeo delog de Hibernate y testear los endpoints con swagger. 

Versión 0.3.0 --  Funcionan todos los endpoints en swagger, y se agega búsqueda por DNI para persona. 

Versión 0.3.2 --  Agreagado de ComamndLineRunner en main. 

Versiòn 0.4.0 -- problemas en Update cuando quieres hacer un update de provincia. 

Versión 0.5.3 -- Agregada toda la funcionalidad para usuario. 