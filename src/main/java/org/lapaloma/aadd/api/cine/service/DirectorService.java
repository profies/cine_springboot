package org.lapaloma.aadd.api.cine.service;

import java.util.List;

import org.lapaloma.aadd.inm.cine.dao.IOperacionesBasicasEntidad;
import org.lapaloma.aadd.inm.cine.hibernate.DirectorDaoHibernate;
import org.lapaloma.aadd.inm.cine.vo.Director;
import org.springframework.stereotype.Service;
/*
 * DirectorService: Clase que gestiona las operaciones relacionadas con el director.
 */
@Service
public class DirectorService {
    private IOperacionesBasicasEntidad<Director, Integer> directorDao = new DirectorDaoHibernate();
    
    public Director obtenerDirector(int codigo) {
    	Director director = null;
    	
    	director = directorDao.obtenerEntidadPorID(codigo);
    	
    	return director;
    }
    
    public List<Director> obtenerListaDirectores() {
    	List<Director> listaDirectores = null;

    	listaDirectores = directorDao.obtenerListaEntidades();
    	
    	return listaDirectores;
    }
    
	public Director crearEntidad(Director director) {
    	director= directorDao.crearEntidad(director);
    	return director;
	}
    
	public Director actualizarEntidad(Director director) {
    	
    	director= directorDao.actualizarEntidad(director);
    	return director;
    }
	
	public void borrarEntidad(Director entidad) {
    	directorDao.borrarEntidad(entidad);
	}
}
