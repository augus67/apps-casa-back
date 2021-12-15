package com.example.appsCasaBackend.repositories;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.example.appsCasaBackend.lista.model.TGenTienda;
import com.example.appsCasaBackend.lista.repositories.TiendaRepository;


// Sólo se ocupa de levantar la parte que afecta a BD como el Repositorio, DAO, ¿lo anotado con @Repository?
@DataJpaTest
// Indica que se evite la configuración por defecto y se utilice la configurada en el properties
@AutoConfigureTestDatabase(replace = Replace.NONE)
// Indica que las sentencias se ejecuten contra la BD y queden guardadas
@Rollback(false)
public class TiendaRepositoryTest {
	
	
	@Autowired
	private TiendaRepository repositorio;
	
	
	//@Test
	public void saveTiendaTest() {
		
		TGenTienda tienda = new TGenTienda();
		
		tienda.setDesTienda("Bonpreu");
		tienda.setDireccion("C/ Roselles, 21");
		tienda.setTelefono("933382312");
		tienda.setFechaAlta(new Date());
		tienda.setFechaUltMod(new Date());
		
		repositorio.save(tienda);
		
		TGenTienda tienda1 = new TGenTienda();
		
		tienda.setDesTienda("Caprabo S.A.");
		tienda.setDireccion("Calle Barcelona, 32");
		tienda.setTelefono("931234567");
		tienda.setFechaAlta(new Date());
		tienda.setFechaUltMod(new Date());
		
		repositorio.save(tienda1);

	}
	


}
