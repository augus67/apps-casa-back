package com.example.appsCasaBackend.lista.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.appsCasaBackend.lista.dto.TiendaDTO;
import com.example.appsCasaBackend.lista.model.TGenTienda;


@Repository
public interface TiendaRepository extends JpaRepository<TGenTienda, Long>{

	@Query("select t from TGenTienda t left join fetch t.TGenProductos p where t.idTienda = :idTienda")
	TGenTienda findOneTiendaById(@Param("idTienda") Long idTienda);
	
	@Query("select tienda from TGenTienda tienda left join fetch tienda.TGenProductos order by tienda.idTienda")
	List<TGenTienda> findAllTiendas();
	
	@Query("select new com.example.appsCasaBackend.lista.dto.TiendaDTO(t.desTienda, t.direccion, t.telefono) from TGenTienda t")
	List<TiendaDTO> findAllTiendasDTO();
		

}
