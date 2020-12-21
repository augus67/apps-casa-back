package com.example.appsCasaBackend.lista.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.appsCasaBackend.lista.dto.TiendaDTO;
import com.example.appsCasaBackend.lista.model.TGenTienda;
import com.example.appsCasaBackend.lista.repositories.TiendaRepository;
import com.example.appsCasaBackend.lista.services.TiendaService;


@Service
@Transactional
public class TiendaServiceImpl implements TiendaService{
	
	@Autowired
	private TiendaRepository tiendaRepository;
	

	
	public boolean updateTienda(Long idTienda, TGenTienda tienda) {
		
		Optional<TGenTienda> optTienda = tiendaRepository.findById(idTienda);
		
		if(optTienda.isPresent()) {
			TGenTienda updtTienda = optTienda.get();

			updtTienda.setFechaUltMod(new Date());
			
			if(tienda.getDesTienda() != null) updtTienda.setDesTienda(tienda.getDesTienda());
			if(tienda.getDireccion() != null) updtTienda.setDireccion(tienda.getDireccion());
			if(tienda.getTelefono() != null) updtTienda.setTelefono(tienda.getTelefono());
			
			tienda = tiendaRepository.save(updtTienda);
			if(tienda != null) {
				return true;
			} else {
				return false;
			}
			
		}else {
			return false;
		}
		
	}
	
	
	
	public TGenTienda findOneById(Long idTienda) {
		
		return tiendaRepository.findOneTiendaById(idTienda);
		
	}
	
	
	
	public TGenTienda findById(Long idTienda) {
		TGenTienda ti;
		Optional<TGenTienda> optTienda = tiendaRepository.findById(idTienda);
		
		if(optTienda.isPresent()) {
			 ti = optTienda.get();
		} else {
			ti = null;
		}
		
		return ti;
		
	}
	
	

	public List<TGenTienda> findAllTiendas() {

		List<TGenTienda> tGenTiendas = new ArrayList<TGenTienda>();

		tGenTiendas = (List<TGenTienda>) tiendaRepository.findAllTiendas();
		
		if(tGenTiendas != null && !tGenTiendas.isEmpty()) {
			return tGenTiendas;
		}
		
		return null;
	}
	
	
	
	public List<TiendaDTO> findAllTiendasDTO(){
		List<TiendaDTO> tiendasDto = new ArrayList<TiendaDTO>();
		
		tiendasDto = (List<TiendaDTO>) tiendaRepository.findAllTiendasDTO();
		
		return tiendasDto;
	}

	
	
	public TGenTienda saveTienda(TGenTienda tienda) {
		
		if(tienda != null) {
			return tiendaRepository.save(tienda);
		}
		
		return null;

	}
	
	
	
	public boolean deleteTienda(Long idTienda) {
		
		if(tiendaRepository.existsById(idTienda)) {
			tiendaRepository.deleteById(idTienda);
			return true;
		} else {
			return false;
		}	
		
	}
	


	public TiendaRepository getTiendaRepository() {
		return tiendaRepository;
	}

	public void setTiendaRepository(TiendaRepository tiendaRepository) {
		this.tiendaRepository = tiendaRepository;
	}

}
