package com.example.appsCasaBackend.lista.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appsCasaBackend.lista.model.TGenProducto;
import com.example.appsCasaBackend.lista.repositories.ProductoRepository;
import com.example.appsCasaBackend.lista.services.ProductoService;

@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	
	public TGenProducto save(TGenProducto producto) {
		
		if(producto != null) {
			return productoRepository.save(producto);
		}
		
		return null;
	}

	
	public boolean deleteProductoById(Long idProducto) {
		
		if(idProducto != null && productoRepository.existsById(idProducto)) {
			productoRepository.deleteById(idProducto);
			return true;
		} else {
			logger.error("El id de producto es null, no se puede borrar ningún producto.");
			return false;
		}
	}
	
	
	public TGenProducto findById(Long idProducto) {
		
		TGenProducto producto = null;
		
		try {			
			Optional<TGenProducto> optProducto = productoRepository.findById(idProducto);
			
			if(optProducto.isPresent()) {
				producto = optProducto.get();
			}
			
			return producto;
			
		} catch (IllegalArgumentException e) {
			logger.error("El id de producto es null, no se recupera ningún producto.");
			return null;
		}			
		
	}
	
	
	public ProductoRepository getProductoRepository() {
		return productoRepository;
	}

	public void setProductoRepository(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	

}
