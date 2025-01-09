package org.lapaloma.aadd.api.cine.controller;

import java.util.List;

import org.lapaloma.aadd.api.cine.service.DirectorService;
import org.lapaloma.aadd.inm.cine.vo.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectorController {
	 @Autowired
	 private DirectorService directorService;

    @GetMapping(value = "/directores")
    public List<Director> obtenerListaDirectores() {
    	List<Director> listaDirectores = null;
    	
    	listaDirectores = directorService.obtenerListaDirectores();

        return listaDirectores;
    }

    @GetMapping("/director/{id}")
    public Director retrieveStudent(@PathVariable int id) {
    	Director director =  directorService.obtenerDirector(id);
    	return director;
    }
    
    
    @DeleteMapping("/director/{id}")
    public void borrarDirector(@PathVariable int id) {
    	Director director = new Director();
    	director.setIdentificador(id);
    	//)
    	directorService.borrarEntidad(director);
    }
    
    @PostMapping("/students")
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
    	Student savedStudent = studentRepository.save(student);

    	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
    			.buildAndExpand(savedStudent.getId()).toUri();

    	return ResponseEntity.created(location).build();

    }
    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {

    	Optional<Student> studentOptional = studentRepository.findById(id);

    	if (studentOptional.isEmpty())
    		return ResponseEntity.notFound().build();

    	student.setId(id);
    	
    	studentRepository.save(student);

    	return ResponseEntity.noContent().build();
    }
}
