package com.example.appsCasaBackend.lista.services.impl;

import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appsCasaBackend.lista.model.TMaeCategoriaProd;
import com.example.appsCasaBackend.lista.repositories.CategoriaProductRepository;
import com.example.appsCasaBackend.lista.services.CategoriaProductService;

@Service
@Transactional
public class CategoriaProductServiceImpl implements CategoriaProductService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CategoriaProductRepository categoriaProdRepo;

	
	@Override
	public TMaeCategoriaProd saveCategoriaProd(TMaeCategoriaProd categoriaProd) {
		
		if(categoriaProd != null) {
			logger.info("Se ha guardado la categoría: " + categoriaProd.getDesCategoria());
			return categoriaProdRepo.save(categoriaProd);
		} else {
			logger.error("No se puede guardar el objeto TMaeCategoriaProd porque es null.");
			return null;
		}
		
	}

	
	@Override
	public boolean deleteCategoriaProdById(Long idCategoriaProd) {
		
		if(idCategoriaProd != null && categoriaProdRepo.existsById(idCategoriaProd)) {
			categoriaProdRepo.deleteById(idCategoriaProd);
			logger.info("Se ha borrado la categoría con ID: " + idCategoriaProd);
			return true;
		} else {
			logger.error("El id de la categoria de producto es null o no existe, no se puede borrar.");
			return false;
		}
		
	}
	

	@Override
	public TMaeCategoriaProd findById(Long idCategoriaProd) {

		try {
			TMaeCategoriaProd catProducto = null;
			Optional<TMaeCategoriaProd> optCatprod = categoriaProdRepo.findById(idCategoriaProd);
			
			if(optCatprod.isPresent()) {
				catProducto = optCatprod.get();
			}
			
			return catProducto;
			
		} catch (IllegalArgumentException e) {
			logger.error("El id de la categoria de producto es null, no se recupera ninguna categoría.");
			return null;
		}
		
	}

	
	
	public CategoriaProductRepository getCategoriaProdRepo() {
		return categoriaProdRepo;
	}

	public void setCategoriaProdRepo(CategoriaProductRepository categoriaProdRepo) {
		this.categoriaProdRepo = categoriaProdRepo;
	}
		

}
