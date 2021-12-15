package com.example.appsCasaBackend.services;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.appsCasaBackend.lista.dto.TiendaDTO;
import com.example.appsCasaBackend.lista.model.TGenTienda;
import com.example.appsCasaBackend.lista.services.TiendaService;

//@SpringBootTest: Se utiliza por si es necesario levantar toda la configuración de la aplicación
@SpringBootTest
public class TiendaServiceTest {

	@Autowired
	private TiendaService tiendaService;
	
	//@Test
	public void updateTiendaTest() {
		
		TGenTienda tienda = tiendaService.findById(1L);
		
		if(tienda != null) {
			TGenTienda t = tienda;
			t.setTelefono("660324578");
			tiendaService.updateTienda(1L, t);
		}
		
	}
	
	
	//@Test
	public void findAllTiendasDTOTest() {
		
		List<TiendaDTO> listaDto = tiendaService.findAllTiendasDTO();
		
		listaDto.forEach(tienda -> {
			System.out.println(tienda.getDesTienda() + " " + tienda.getDireccion() + " " + tienda.getTelefono());
			
		});
		
	}
	
}
