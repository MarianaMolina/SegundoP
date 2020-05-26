package com.parcial.demo.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.parcial.demo.domain.Categoria;
import com.parcial.demo.domain.Libro;


public interface LibroDAO {
	
	public List<Libro> findBook() throws DataAccessException;
	
	public void saveBook(Libro libro) throws DataAccessException;
	
	public void saveCategory(Categoria categoria) throws DataAccessException;
	
}
