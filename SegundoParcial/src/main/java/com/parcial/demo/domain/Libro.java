package com.parcial.demo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table (schema="public", name="cat_libro")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_estudiante")
	private Integer id_libro;
	
	@Size(message ="El campo no debe contener mas de 500 caracteres", max =500)
	@NotEmpty(message ="Este campo no puede estar vacio")
	@Column(name="s_titulo")
	private String titulo;
	
	@Size(message ="El campo no debe contener mas de 150 caracteres", max =150)
	@NotEmpty(message ="Este campo no puede estar vacio")
	@Column(name="s_autor")
	private String autor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="c_categoria")
	private Categoria categoria;
	
	@Column(name="b_estado")
	private Boolean estado;
	
	@Size(message ="El campo no debe contener mas de 10 caracteres", max =10)
	@NotEmpty(message ="Este campo no puede estar vacio")
	@Column(name="s_isbn")
	private String isbn;
	
	//CONSTRUCTOR
	public Libro() {
		
	}
	
	
	//FUNCION
		public String getEstadoDelegate() {
			if(this.estado==null)return "";
			else {
				return estado == true? "Activo":"Inactivo";
			}
		}

		public Integer getId_libro() {
			return id_libro;
		}

		public void setId_libro(Integer id_libro) {
			this.id_libro = id_libro;
		}

		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}

		public String getAutor() {
			return autor;
		}

		public void setAutor(String autor) {
			this.autor = autor;
		}

		public Categoria getCategoria() {
			return categoria;
		}


		public void setCategoria(Categoria categoria) {
			this.categoria = categoria;
		}


		public Boolean getEstado() {
			return estado;
		}

		public void setEstado(Boolean estado) {
			this.estado = estado;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

	
}
