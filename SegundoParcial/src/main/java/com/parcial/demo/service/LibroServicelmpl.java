package com.parcial.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.parcial.demo.dao.LibroDAO;
import com.parcial.demo.domain.Categoria;
import com.parcial.demo.domain.Libro;

@Service
public class LibroServicelmpl implements LibroService{

	@Autowired
	LibroDAO libroDAO;

	@Override
	public List<Libro> findBook() throws DataAccessException {
		return libroDAO.findBook();
	}

	@Override
	public void saveBook(Libro libro) throws DataAccessException {
		libroDAO.saveBook(libro);
	}

	@Override
	public void saveCategory(Categoria categoria) throws DataAccessException {
		libroDAO.saveCategory(categoria);
	}
	
	
}
