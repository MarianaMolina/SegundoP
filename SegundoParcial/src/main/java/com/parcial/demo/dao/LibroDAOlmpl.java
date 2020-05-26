package com.parcial.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.parcial.demo.domain.Categoria;
import com.parcial.demo.domain.Libro;

@Repository
public class LibroDAOlmpl implements LibroDAO{
	
	@PersistenceContext(unitName="demo")
	private EntityManager entityManager;

	@Override
	public List<Libro> findBook() throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.cat_libro");
		
		Query query = entityManager.createNativeQuery(sb.toString(),Libro.class);
		List<Libro> result = query.getResultList();
		return result;
	}

	@Override
	public void saveBook(Libro libro) throws DataAccessException {
		try {
			if(libro.getId_libro() == null) {
				entityManager.persist(libro);
			}
			else {
				entityManager.merge(libro);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void saveCategory(Categoria categoria) throws DataAccessException {
		try {
			if(categoria.getId_categoria() == null) {
				entityManager.persist(categoria);
			}
			else {
				entityManager.merge(categoria);
				entityManager.flush();
			}
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
