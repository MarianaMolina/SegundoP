package com.parcial.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.parcial.demo.domain.Categoria;
import com.parcial.demo.domain.Libro;
import com.parcial.demo.service.LibroService;


@Controller
public class MainController {
	
	@Autowired
	private LibroService libroService;
	
	//inicio
	@RequestMapping ("/index")
	public ModelAndView Main() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main");
		return mav;
	}
	
	//pagina L
	@RequestMapping ("/ingresarL")
	public ModelAndView formL() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ingresarLibro");
		return mav;
	}
	
	//pagina C
	@RequestMapping ("/ingresarC")
	public ModelAndView formC() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("ingresarCategoria");
		return mav;
	}
	
	//ingresar libro
	@RequestMapping ("/saveBook")
	public ModelAndView guardarB(@Valid @ModelAttribute Libro libro, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()) {
			mav.setViewName("ingresarLibro");
		}
		else {
			libroService.saveBook(libro);
			mav.addObject("libro", libro);
			mav.setViewName("exitoL");
		}
		
		return mav;
	}
	
	//ingresar libro
		@RequestMapping ("/saveCategory")
		public ModelAndView guardarC(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
			ModelAndView mav = new ModelAndView();
			
			if(result.hasErrors()) {
				mav.setViewName("ingresarCategoria");
			}
			else {
				libroService.saveCategory(categoria);
				mav.addObject("categoria", categoria);
				mav.setViewName("exitoC");
			}
			
			return mav;
		}
		
		@RequestMapping ("/mostrarL")
		public ModelAndView mostrarL() {
			ModelAndView mav = new ModelAndView();
			List<Libro> libros = null;
			try {
				libros= libroService.findBook();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			mav.addObject("libros", libros);
			mav.setViewName("listadoLibro");
			
			return mav;
		}
		
	


}
