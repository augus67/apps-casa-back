package com.example.appsCasaBackend.lista.controllers;

import java.util.Date;
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
import com.example.appsCasaBackend.lista.model.TGenTienda;
import com.example.appsCasaBackend.lista.services.ProductoService;
import com.example.appsCasaBackend.lista.services.TiendaService;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/tiendas")
public class TiendaController {
	
	@Autowired
	private TiendaService tiendaService;
	
	@Autowired
	private ProductoService productoService;
	
	
	@GetMapping
	public Iterable<TGenTienda> list(){
		return tiendaService.findAllTiendas();		
	}
	
	
	
//	@GetMapping
//	public Iterable<TiendaDTO> list(){
//		return tiendaService.findAllTiendasDTO();
//	}
	
	
	
	@GetMapping("/{idTienda}")
	public TGenTienda findTiendaById(@PathVariable Long idTienda){

		TGenTienda tienda = tiendaService.findOneById(idTienda);
		
		if(tienda != null) {
			return tienda;
		} else {
			throw new ResourceNotFoundException("No se ha encontrado la tienda con id: " + idTienda);
		}		
	}
	

	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	public TGenTienda createTienda(@RequestBody TGenTienda tienda) {
		
		tienda.setFechaAlta(new Date());
		tienda.setFechaUltMod(new Date());
		
		return tiendaService.saveTienda(tienda);
	}
	
	
	
	@PutMapping("/{idTienda}")
	public TGenTienda updateTienda(@PathVariable Long idTienda, @RequestBody TGenTienda tienda) throws ResourceNotFoundException{
		
		boolean isUpdated = tiendaService.updateTienda(idTienda, tienda);
		
		if(isUpdated) {			 	
			return tiendaService.findOneById(idTienda);
		}else {
			throw new ResourceNotFoundException("No se ha encontrado la tienda con id: " + idTienda);
		}		
	}
	
	
	
	@DeleteMapping("/{idTienda}")
	public ResponseEntity<String> deleteTienda(@PathVariable Long idTienda) {
		
		boolean isDeleted = false;
		long totalProductos = 0;
		
		// Comprobamos que no existen productos con la tienda que se desea borrar
		totalProductos = productoService.countProductsByIdTienda(idTienda);
		
		if(totalProductos == 0) {
			isDeleted = tiendaService.deleteTienda(idTienda);
			
			if(isDeleted) {
				return new ResponseEntity<String>(idTienda.toString(), HttpStatus.OK);
			} else {
				return new ResponseEntity<String>(idTienda.toString(), HttpStatus.NOT_FOUND);
			}	
		} else {
			return new ResponseEntity<String>("Hay productos asociados a la tienda con ID: " + idTienda.toString() + ", se deben borrar primero todos esos productos y luego la tienda.", 
					HttpStatus.NOT_FOUND);
		}	
			
	}



	public ProductoService getProductoService() {
		return productoService;
	}

	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	public TiendaService getTiendaService() {
		return tiendaService;
	}

	public void setTiendaService(TiendaService tiendaService) {
		this.tiendaService = tiendaService;
	}


	
}
