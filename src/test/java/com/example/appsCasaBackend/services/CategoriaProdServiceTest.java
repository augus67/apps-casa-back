package com.example.appsCasaBackend.services;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.appsCasaBackend.lista.model.TMaeCategoriaProd;
import com.example.appsCasaBackend.lista.services.CategoriaProductService;

@SpringBootTest
public class CategoriaProdServiceTest {
	
	@Autowired
	private CategoriaProductService catProdService;
	
	
	//@Test
	public void guardaCategoria() {
		
		TMaeCategoriaProd catProd = new TMaeCategoriaProd();
		
		catProd.setCodCategoria("FRUTAS");
		catProd.setDesCategoria("Productos de frutería");
		catProd.setFechaAlta(new Date());
		catProd.setFechaUltMod(new Date());
		
		catProdService.save(catProd);
	}
	
	
	
	@Test
	public void getCategoriasOrdenadas() {
		
		List<TMaeCategoriaProd> lista = catProdService.findAllOrderByCodCategoria();
		
		for(TMaeCategoriaProd cat : lista) {
			System.out.println(">>>getCategoriasOrdenadas()>>> \t" + cat.getCodCategoria() + " \t" + cat.getDesCategoria() + "\t" + cat.getFechaAlta() + "\t" + cat.getFechaUltMod());
		}
		
	}
	
	//@Test
	public void getCategoriasByCodigo() {
		
		List<TMaeCategoriaProd> lista = catProdService.findByCodCategoria("LACTEOS");
		
		for(TMaeCategoriaProd cat : lista) {
			System.out.println(">>>getCategoriasByCodigo()>>> " + cat.getCodCategoria() + " " + cat.getDesCategoria() + " " + cat.getFechaAlta() + " " + cat.getFechaUltMod());
		}
		
	}
	
	
	//@Test
	public void getCategoriasLike() {
		
		List<TMaeCategoriaProd> lista = catProdService.findByCodCategoriaLikeIgnoreCase("%e%");
		
		for(TMaeCategoriaProd cat : lista) {
			System.out.println(">>>getCategoriasLike()>>> " + cat.getCodCategoria() + " " + cat.getDesCategoria() + " " + cat.getFechaAlta() + " " + cat.getFechaUltMod());
		}
		
	}
	
}
