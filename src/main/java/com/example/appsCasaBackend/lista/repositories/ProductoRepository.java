package com.example.appsCasaBackend.lista.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.appsCasaBackend.lista.model.TGenProducto;

@Repository
public interface ProductoRepository extends JpaRepository<TGenProducto, Long>{
	
	
	
}
