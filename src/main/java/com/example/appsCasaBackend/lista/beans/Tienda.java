package com.example.appsCasaBackend.lista.beans;

import java.io.Serializable;
import java.util.Date;

public class Tienda implements Serializable{
	
	private static final long serialVersionUID = -3198993094924837098L;
	
	private Short id;
	private String desTienda;
	private String direccion;
	private String telefono;
	private Date fecAlta;
	private Date fecUltMod;	
	
	
	public Short getId() {
		return id;
	}
	public void setId(Short id) {
		this.id = id;
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
	public Date getFecAlta() {
		return fecAlta;
	}
	public void setFecAlta(Date fecAlta) {
		this.fecAlta = fecAlta;
	}
	public Date getFecUltMod() {
		return fecUltMod;
	}
	public void setFecUltMod(Date fecUltMod) {
		this.fecUltMod = fecUltMod;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desTienda == null) ? 0 : desTienda.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((fecAlta == null) ? 0 : fecAlta.hashCode());
		result = prime * result + ((fecUltMod == null) ? 0 : fecUltMod.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Tienda other = (Tienda) obj;
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
		if (fecAlta == null) {
			if (other.fecAlta != null)
				return false;
		} else if (!fecAlta.equals(other.fecAlta))
			return false;
		if (fecUltMod == null) {
			if (other.fecUltMod != null)
				return false;
		} else if (!fecUltMod.equals(other.fecUltMod))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Tienda [id=" + id + ", desTienda=" + desTienda + ", direccion=" + direccion + ", telefono=" + telefono
				+ ", fecAlta=" + fecAlta + ", fecUltMod=" + fecUltMod + "]";
	}
	
	

}
