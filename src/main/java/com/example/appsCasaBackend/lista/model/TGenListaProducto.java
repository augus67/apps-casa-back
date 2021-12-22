package com.example.appsCasaBackend.lista.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the T_GEN_LISTA_PRODUCTO database table.
 * 
 */
@Entity
@Table(name="T_GEN_LISTA_PRODUCTO")
@NamedQuery(name="TGenListaProducto.findAll", query="SELECT t FROM TGenListaProducto t")
public class TGenListaProducto implements Serializable {

	private static final long serialVersionUID = -5776220519725877168L;

	@EmbeddedId
	private TGenListaProductoPK id;

	private int cantidad;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAlta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaUltMod;

	private BigDecimal importeProd;

	//bi-directional many-to-one association to TGenLista
	@ManyToOne
	@JoinColumn(name="idlista", insertable=false, updatable=false)
	private TGenLista TGenLista;

	//bi-directional many-to-one association to TGenProducto
	@ManyToOne
	@JoinColumn(name="idproducto", insertable=false, updatable=false)
	private TGenProducto TGenProducto;

	
	public TGenListaProducto() {
	}

	public TGenListaProductoPK getId() {
		return this.id;
	}

	public void setId(TGenListaProductoPK id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaUltMod() {
		return this.fechaUltMod;
	}

	public void setFechaUltMod(Date fechaUltMod) {
		this.fechaUltMod = fechaUltMod;
	}

	public BigDecimal getImporteProd() {
		return this.importeProd;
	}

	public void setImporteProd(BigDecimal importeProd) {
		this.importeProd = importeProd;
	}

	public TGenLista getTGenLista() {
		return this.TGenLista;
	}

	public void setTGenLista(TGenLista TGenLista) {
		this.TGenLista = TGenLista;
	}

	public TGenProducto getTGenProducto() {
		return this.TGenProducto;
	}

	public void setTGenProducto(TGenProducto TGenProducto) {
		this.TGenProducto = TGenProducto;
	}

	@Override
	public String toString() {
		return "TGenListaProducto [id=" + id + ", cantidad=" + cantidad + ", fechaAlta=" + fechaAlta + ", fechaUltMod="
				+ fechaUltMod + ", importeProd=" + importeProd + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cantidad;
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaUltMod == null) ? 0 : fechaUltMod.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((importeProd == null) ? 0 : importeProd.hashCode());
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
		TGenListaProducto other = (TGenListaProducto) obj;
		if (cantidad != other.cantidad)
			return false;
		if (fechaAlta == null) {
			if (other.fechaAlta != null)
				return false;
		} else if (!fechaAlta.equals(other.fechaAlta))
			return false;
		if (fechaUltMod == null) {
			if (other.fechaUltMod != null)
				return false;
		} else if (!fechaUltMod.equals(other.fechaUltMod))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (importeProd == null) {
			if (other.importeProd != null)
				return false;
		} else if (!importeProd.equals(other.importeProd))
			return false;
		return true;
	}

}