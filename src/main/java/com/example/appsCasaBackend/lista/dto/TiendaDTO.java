package com.example.appsCasaBackend.lista.dto;

public class TiendaDTO {

	private String desTienda;
	private String direccion;
	private String telefono;
	
	
	public TiendaDTO(String desTienda, String direccion, String telefono) {
		this.desTienda = desTienda;
		this.direccion = direccion;
		this.telefono = telefono;
	}


	public String getDesTienda() {
		return desTienda;
	}


	public void setDesTienda(String desTienda) {
		this.desTienda = desTienda;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desTienda == null) ? 0 : desTienda.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TiendaDTO other = (TiendaDTO) obj;
		if (desTienda == null) {
			if (other.desTienda != null)
				return false;
		} else if (!desTienda.equals(other.desTienda))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	
	
	
}
