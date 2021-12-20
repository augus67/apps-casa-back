package com.example.appsCasaBackend.lista.services;

import com.example.appsCasaBackend.lista.model.TMaeCategoriaProd;

public interface CategoriaProductService {
	
	public TMaeCategoriaProd saveCategoriaProd(TMaeCategoriaProd categoriaProd);
	
	public boolean deleteCategoriaProdById(Long idCategoriaProd);
	
	public TMaeCategoriaProd findById(Long idCategoriaProd);

}
