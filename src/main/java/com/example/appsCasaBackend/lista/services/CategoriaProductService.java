package com.example.appsCasaBackend.lista.services;

import java.util.List;

import com.example.appsCasaBackend.lista.model.TMaeCategoriaProd;

public interface CategoriaProductService {
	
	public TMaeCategoriaProd save(TMaeCategoriaProd categoriaProd);
	
	public boolean deleteById(Long idCategoriaProd);
	
	public boolean updateCategoria(Long idCategoriaProd, TMaeCategoriaProd categoriaProd);
	
	public TMaeCategoriaProd findById(Long idCategoriaProd);
	
	public List<TMaeCategoriaProd> findAllOrderByCodCategoria();
	
	public List<TMaeCategoriaProd> findByCodCategoria(String codCategoria);
	
	public List<TMaeCategoriaProd> findByCodCategoriaLikeIgnoreCase(String codCategoria);

}
