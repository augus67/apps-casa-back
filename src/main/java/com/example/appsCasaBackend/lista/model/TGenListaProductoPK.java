package com.example.appsCasaBackend.lista.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The primary key class for the T_GEN_LISTA_PRODUCTO database table.
 * 
 */
@Embeddable
public class TGenListaProductoPK implements Serializable {

	private static final long serialVersionUID = 4897198551864082606L;

	@Column(insertable=false, updatable=false)
	private int idlista;

	@Column(insertable=false, updatable=false)
	private Long idproducto;

	
	public TGenListaProductoPK() {
	}


	public int getIdlista() {
		return idlista;
	}


	public void setIdlista(int idlista) {
		this.idlista = idlista;
	}


	public Long getIdproducto() {
		return idproducto;
	}


	public void setIdproducto(Long idproducto) {
		this.idproducto = idproducto;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idlista;
		result = prime * result + ((idproducto == null) ? 0 : idproducto.hashCode());
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
		TGenListaProductoPK other = (TGenListaProductoPK) obj;
		if (idlista != other.idlista)
			return false;
		if (idproducto == null) {
			if (other.idproducto != null)
				return false;
		} else if (!idproducto.equals(other.idproducto))
			return false;
		return true;
	}
	
	
}