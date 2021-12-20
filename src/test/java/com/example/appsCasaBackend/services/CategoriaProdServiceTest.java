package com.example.appsCasaBackend.services;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.appsCasaBackend.lista.model.TMaeCategoriaProd;
import com.example.appsCasaBackend.lista.services.CategoriaProductService;

@SpringBootTest
public class CategoriaProdServiceTest {
	
	@Autowired
	private CategoriaProductService catProdService;
	
	
	@Test
	public void guardaCategoria() {
		
		TMaeCategoriaProd catProd = new TMaeCategoriaProd();
		
		catProd.setCodCategoria("LACTEO");
		catProd.setDesCategoria("Productos hechos o derivados de la leche");
		catProd.setFechaAlta(new Date());
		catProd.setFechaUltMod(new Date());
		catProd.setIdCategoria(1L);
		
		catProdService.saveCategoriaProd(catProd);
	}
	
}
