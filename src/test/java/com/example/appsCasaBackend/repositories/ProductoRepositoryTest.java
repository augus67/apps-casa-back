package com.example.appsCasaBackend.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.example.appsCasaBackend.lista.repositories.ProductoRepository;

//Sólo se ocupa de levantar la parte que afecta a BD como el Repositorio, DAO, ¿lo anotado con @Repository?
//@DataJpaTest
//Indica que se evite la configuración por defecto y se utilice la configurada en el properties
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//Indica que las sentencias se ejecuten contra la BD y queden guardadas
//@Rollback(false)
@SpringBootTest
public class ProductoRepositoryTest {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	@Test
	public void countProd() {
		
		Long id = new Long(4L);
		
		long total = productoRepository.countProductosByIdTienda(id);
		
		System.out.println("\n");
		System.out.println("\t Total registros " + total);
		System.out.println("\n");
		
	}

}
