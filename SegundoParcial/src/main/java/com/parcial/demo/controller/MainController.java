package com.parcial.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
	


}
