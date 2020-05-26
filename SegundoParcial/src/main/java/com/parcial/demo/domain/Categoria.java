package com.parcial.demo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

public class Categoria {
	
	@Id
	@Column(name="c_categoria")
	private Integer id_categoria;
	
	@Size(message ="El campo no debe contener mas de 30 caracteres", max=50)
	@Column(name="s_categoria")
	private String categoria;
	
	@OneToMany(mappedBy="cat_categoria", fetch=FetchType.EAGER)
	private List <Libro> libros;
	
	//Constructor
	public Categoria() {
		
	}

	//getters y setters
	public Integer getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(Integer id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	
	
}
