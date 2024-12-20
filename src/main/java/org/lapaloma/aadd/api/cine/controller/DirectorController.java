package org.lapaloma.aadd.api.cine.controller;

import java.util.List;

import org.lapaloma.aadd.api.cine.service.DirectorService;
import org.lapaloma.aadd.inm.cine.vo.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DirectorController {
	 @Autowired
	 private DirectorService directorService;

    @GetMapping(value = "/directores")
    public ResponseEntity<Director> obtenerListaDirectores() {
    	List<Director> listaDirectores = null;
    	
    	listaDirectores = directorService.obtenerListaDirectores();

        return new ResponseEntity(listaDirectores, HttpStatus.OK);
    }

    @GetMapping(value = "/director")
    public ResponseEntity<Director> obtenerDirectorPorId(@RequestParam(value = "id") int id) {
    	Director director =  directorService.obtenerDirector(id);
        return new ResponseEntity(director, HttpStatus.OK);
    }
}
