package com.example.appsCasaBackend.lista.services;

import java.util.List;

import com.example.appsCasaBackend.lista.dto.TiendaDTO;
import com.example.appsCasaBackend.lista.model.TGenTienda;

public interface TiendaService {
	
	public TGenTienda findOneById(Long idTienda);
	
	public TGenTienda findById(Long idTienda);
	
	public boolean updateTienda(Long idTienda, TGenTienda tienda);
	
	public List<TGenTienda> findAllTiendas();
	
	public TGenTienda saveTienda(TGenTienda tienda);
	
	public List<TiendaDTO> findAllTiendasDTO();
	
	public boolean deleteTienda(Long idTienda);

}
