package com.example.appsCasaBackend.lista.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.appsCasaBackend.lista.model.TMaeCategoriaProd;

@Repository
public interface CategoriaProductRepository extends JpaRepository<TMaeCategoriaProd, Long> {
	
	@Query("select cat from TMaeCategoriaProd cat left join fetch cat.TGenProductos order by cat.codCategoria")
	public List<TMaeCategoriaProd> findAllOrderByCodCategoria();

	public List<TMaeCategoriaProd> findByCodCategoria(String codCategoria);
	
	public List<TMaeCategoriaProd> findByCodCategoriaLikeIgnoreCase(String codCategoria);
}
