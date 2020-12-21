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
	private int idLista;

	@Column(insertable=false, updatable=false)
	private short idProducto;

	
	public TGenListaProductoPK() {
	}
	public int getIdLista() {
		return this.idLista;
	}
	public void setIdLista(int idLista) {
		this.idLista = idLista;
	}
	public short getIdProducto() {
		return this.idProducto;
	}
	public void setIdProducto(short idProducto) {
		this.idProducto = idProducto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TGenListaProductoPK)) {
			return false;
		}
		TGenListaProductoPK castOther = (TGenListaProductoPK)other;
		return 
			(this.idLista == castOther.idLista)
			&& (this.idProducto == castOther.idProducto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idLista;
		hash = hash * prime + ((int) this.idProducto);
		
		return hash;
	}
}