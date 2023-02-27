package com.example.appsCasaBackend.lista.services.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.appsCasaBackend.lista.model.TGenProducto;
import com.example.appsCasaBackend.lista.repositories.ProductoRepository;
import com.example.appsCasaBackend.lista.services.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	@Transactional(rollbackFor = Exception.class)
	public TGenProducto save(TGenProducto producto) {
		
		if(producto != null) {
			return productoRepository.save(producto);
		}
		
		return null;
	}

	
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteProductoById(Long idProducto) {
		
		if(idProducto != null && productoRepository.existsById(idProducto)) {
			productoRepository.deleteById(idProducto);
			return true;
		} else {
			logger.error("El id de producto es null, no se puede borrar ningún producto.");
			return false;
		}
	}
	
	
	@Transactional(readOnly = true)
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
	
		
	@Override
	@Transactional(readOnly = true)
	public long countProductsByIdTienda(Long idTienda) {
		
		long countProducts = productoRepository.countProductosByIdTienda(idTienda);
		
		if(countProducts > 0) {
			return countProducts;
		} else {
			return 0;
		}
		
		
	}


	public ProductoRepository getProductoRepository() {
		return productoRepository;
	}

	public void setProductoRepository(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}
	

}
