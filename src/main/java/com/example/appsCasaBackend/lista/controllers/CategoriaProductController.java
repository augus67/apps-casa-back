package com.example.appsCasaBackend.lista.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.appsCasaBackend.lista.model.TMaeCategoriaProd;
import com.example.appsCasaBackend.lista.services.CategoriaProductService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/categoriasProducto")
public class CategoriaProductController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CategoriaProductService categoriaProductService;

	
	
	@GetMapping
	public Iterable<TMaeCategoriaProd> listCategorias(){
		logger.info("Recuperando listado de categorias de producto");
		return categoriaProductService.findAllOrderByCodCategoria();
	}
	
	
	
	
	
	
	
	
	public CategoriaProductService getCategoriaProductService() {
		return categoriaProductService;
	}

	public void setCategoriaProductService(CategoriaProductService categoriaProductService) {
		this.categoriaProductService = categoriaProductService;
	}
	

}
