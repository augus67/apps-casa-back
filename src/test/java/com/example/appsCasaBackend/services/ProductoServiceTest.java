package com.example.appsCasaBackend.services;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.appsCasaBackend.lista.model.TGenProducto;
import com.example.appsCasaBackend.lista.model.TGenTienda;
import com.example.appsCasaBackend.lista.model.TMaeCategoriaProd;
import com.example.appsCasaBackend.lista.services.CategoriaProductService;
import com.example.appsCasaBackend.lista.services.ProductoService;
import com.example.appsCasaBackend.lista.services.TiendaService;

@SpringBootTest
public class ProductoServiceTest {
	
	@Autowired
	private ProductoService prodService;
	
	@Autowired
	private TiendaService tiendaService;
	
	@Autowired
	private CategoriaProductService catProdService;
	
	
	//@Test
	public void saveProduct() {
		
		TGenProducto producto1 = new TGenProducto();
		TGenTienda tienda = tiendaService.findById(4L);
		TMaeCategoriaProd catProd = catProdService.findById(1L);
		
		producto1.setCapacidad("6 Litros");
		producto1.setDesProducto("Leche entera");
		producto1.setEmbalaje("Pack 6 unidades");
		producto1.setFechaAlta(new Date());
		producto1.setFechaUltMod(new Date());
		//producto1.setIdProducto(null);
		producto1.setPeso(null);
		producto1.setPrecio(new BigDecimal(3.45));
		producto1.setTGenTienda(tienda);
		producto1.setTMaeCategoriaProd(catProd);

		prodService.save(producto1);
		
	}
	
	@Test
	public void countProd() {
		Long idtienda = 101L;
		
		long total = prodService.countProductsByIdTienda(idtienda);
		
		System.out.println("\n");
		System.out.println("\t Total registros " + total);
		System.out.println("\n");
	}
	
	

}
