package org.lapaloma.aadd.api.cine.service;

import java.util.List;

import org.lapaloma.aadd.inm.cine.dao.IOperacionesBasicasEntidad;
import org.lapaloma.aadd.inm.cine.hibernate.DirectorDaoHibernate;
import org.lapaloma.aadd.inm.cine.vo.Director;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorService {
    private IOperacionesBasicasEntidad<Director, Integer> directorDao = null;
    
    public Director obtenerDirector(int codigo) {
    	Director director = null;
    	
    	directorDao= new DirectorDaoHibernate();
    	director = directorDao.obtenerEntidadPorID(codigo);
    	
    	return director;
    }
    
    public List<Director> obtenerListaDirectores() {
    	List<Director> listaDirectores = null;

    	directorDao= new DirectorDaoHibernate();
    	listaDirectores = directorDao.obtenerListaEntidades();
    	
    	return listaDirectores;
    }

}
