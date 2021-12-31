package com.example.appsCasaBackend.lista.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.appsCasaBackend.lista.model.TMaeCategoriaProd;
import com.example.appsCasaBackend.lista.repositories.CategoriaProductRepository;
import com.example.appsCasaBackend.lista.services.CategoriaProductService;
import com.example.appsCasaBackend.lista.utils.Utils;

@Service
@Transactional
public class CategoriaProductServiceImpl implements CategoriaProductService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CategoriaProductRepository categoriaProdRepo;

	
	
	@Override
	public TMaeCategoriaProd save(TMaeCategoriaProd categoriaProd) {
		
		if(categoriaProd != null) {
			logger.info("Se ha guardado la categoría: " + categoriaProd.getDesCategoria());
			return categoriaProdRepo.save(categoriaProd);
		} else {
			logger.error("No se puede guardar el objeto TMaeCategoriaProd porque es null.");
			return null;
		}
		
	}

	
	
	@Override
	public boolean deleteById(Long idCategoriaProd) {
		
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
	public boolean updateCategoria(Long idCategoriaProd, TMaeCategoriaProd categoriaProd) {
		boolean isUpdated = false;
		Optional<TMaeCategoriaProd> optCategoria = categoriaProdRepo.findById(idCategoriaProd);
		
		if(optCategoria.isPresent()) {
			TMaeCategoriaProd updtCategoria = optCategoria.get();			
			
			if(categoriaProd.getCodCategoria() != null && !categoriaProd.getCodCategoria().equalsIgnoreCase(updtCategoria.getCodCategoria())) {
				updtCategoria.setCodCategoria(categoriaProd.getCodCategoria().toUpperCase());				
				isUpdated = true;
			}
			
			if(categoriaProd.getDesCategoria() != null && !categoriaProd.getDesCategoria().equalsIgnoreCase(updtCategoria.getDesCategoria())) {
				updtCategoria.setDesCategoria(categoriaProd.getDesCategoria().toUpperCase());
				isUpdated = true;
			}
			
			if(isUpdated) {
				updtCategoria.setFechaUltMod(new Date());
				categoriaProdRepo.save(categoriaProd);
			}
		}	
		
		return isUpdated;
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
	
	
	
	@Override
	public List<TMaeCategoriaProd> findAllOrderByCodCategoria() {
		
		List<TMaeCategoriaProd> listCategoriasProd = null;
		
		// El orden ascendente es el natural de String
		//listCategoriasProd = categoriaProdRepo.findAll(Sort.by("codCategoria"));
		logger.debug("Recuperando categorias de producto");
		listCategoriasProd = categoriaProdRepo.findAllOrderByCodCategoria();
		logger.debug("Se han obtenido un total de " + listCategoriasProd.size() + " categorias");
		
		return listCategoriasProd;
	}



	@Override
	public List<TMaeCategoriaProd> findByCodCategoria(String codCategoria) {
		
		List<TMaeCategoriaProd> listCategoriasProd = null;
		
		if(codCategoria != null && !StringUtils.isBlank(codCategoria)) {
			
			listCategoriasProd = categoriaProdRepo.findByCodCategoria(codCategoria);
			
			if(!Utils.isEmpty(listCategoriasProd)) {
				return listCategoriasProd;
			}			 
		}
		
		return null;
	}

	
	
	@Override
	public List<TMaeCategoriaProd> findByCodCategoriaLikeIgnoreCase(String codCategoria) {
		
		List<TMaeCategoriaProd> listCategoriasProd = null;
		
		if(codCategoria != null && !StringUtils.isBlank(codCategoria)) {
			
			listCategoriasProd = categoriaProdRepo.findByCodCategoriaLikeIgnoreCase(codCategoria);
			
			if(!Utils.isEmpty(listCategoriasProd)) {
				return listCategoriasProd;
			}			 
		}		
		
		return null;
	}



	public CategoriaProductRepository getCategoriaProdRepo() {
		return categoriaProdRepo;
	}

	public void setCategoriaProdRepo(CategoriaProductRepository categoriaProdRepo) {
		this.categoriaProdRepo = categoriaProdRepo;
	}
		

}
