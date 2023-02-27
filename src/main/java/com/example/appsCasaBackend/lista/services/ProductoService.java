package com.example.appsCasaBackend.lista.services;

import com.example.appsCasaBackend.lista.model.TGenProducto;

public interface ProductoService {
	
	public TGenProducto save(TGenProducto producto);
	
	public boolean deleteProductoById(Long idProducto);
	
	public TGenProducto findById(Long idProducto);
	
	public long countProductsByIdTienda(Long idTienda);

}
