package com.example.appsCasaBackend.lista.controllers;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.appsCasaBackend.lista.exceptions.ResourceNotFoundException;
import com.example.appsCasaBackend.lista.model.TMaeCategoriaProd;
import com.example.appsCasaBackend.lista.services.CategoriaProductService;
import com.example.appsCasaBackend.lista.utils.Utils;

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
	
	
	
	@GetMapping("/{codCategoria}")
	public Iterable<TMaeCategoriaProd> listCategoriasByCode(@PathVariable String codCategoria) throws ResourceNotFoundException {
		List<TMaeCategoriaProd> listaCategorias = null;
		
		logger.info("Recuperando listado de categorias por código");		
		listaCategorias = categoriaProductService.findByCodCategoria(codCategoria);
		
		if(Utils.isEmpty(listaCategorias)) {
			throw new ResourceNotFoundException("No se ha encontrado la categoría con código: " + codCategoria);
		} else {
			return listaCategorias;
		}
		
	}
	
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public TMaeCategoriaProd createCategoria(@RequestBody TMaeCategoriaProd categoria) {	
		Date ahora = new Date();
		
		categoria.setFechaAlta(ahora);
		categoria.setFechaUltMod(ahora);
		
		logger.info("Creando categoria " + categoria.getCodCategoria());
		return categoriaProductService.save(categoria); 
	
	}
	
	
	
	@DeleteMapping("/{idCategoria}")
	public ResponseEntity<Long> deleteCategoria(@PathVariable Long idCategoria){		
		boolean isDeleted = false;
		
		logger.info("Borrando categoría con ID: " + idCategoria);
		isDeleted = categoriaProductService.deleteById(idCategoria);
		
		if(isDeleted) {
			logger.debug("Categoria " + idCategoria + " borrada");
			return new ResponseEntity<Long>(idCategoria, HttpStatus.OK);
		} else {
			logger.debug("No se ha podido borrar la categoria " + idCategoria);
			return new ResponseEntity<Long>(idCategoria, HttpStatus.NOT_FOUND);
		}
		
	}
	
	
	
	@PutMapping("/{idCategoria}")
	public TMaeCategoriaProd updateCategoria(@PathVariable Long idCategoria, @RequestBody TMaeCategoriaProd categoria) 
			throws ResourceNotFoundException{
		
		boolean isUpdated = categoriaProductService.updateCategoria(idCategoria, categoria);
		
		if(isUpdated) {
			return categoriaProductService.findById(idCategoria);
		} else {
			throw new ResourceNotFoundException("No se ha encontrado la tienda con id: " + idCategoria);
		}
		
	}
	
	
		
	public CategoriaProductService getCategoriaProductService() {
		return categoriaProductService;
	}

	public void setCategoriaProductService(CategoriaProductService categoriaProductService) {
		this.categoriaProductService = categoriaProductService;
	}
	

}
