package com.example.appsCasaBackend.lista.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the T_GEN_LISTA database table.
 * 
 */
@Entity
@Table(name="T_GEN_LISTA")
@NamedQuery(name="TGenLista.findAll", query="SELECT t FROM TGenLista t")
public class TGenLista implements Serializable {

	private static final long serialVersionUID = -4386830203492541323L;

	@Id
	private int idlista;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAlta;

	@Temporal(TemporalType.DATE)
	private Date fechaLista;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaUltMod;

	private BigDecimal importeTotal;

	//bi-directional many-to-one association to TGenListaProducto
	@OneToMany(mappedBy="TGenLista")
	private List<TGenListaProducto> TGenListaProductos = new ArrayList<TGenListaProducto>();

	
	public TGenLista() {
	}

	public int getIdLista() {
		return this.idlista;
	}

	public void setIdLista(int idlista) {
		this.idlista = idlista;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaLista() {
		return this.fechaLista;
	}

	public void setFechaLista(Date fechaLista) {
		this.fechaLista = fechaLista;
	}

	public Date getFechaUltMod() {
		return this.fechaUltMod;
	}

	public void setFechaUltMod(Date fechaUltMod) {
		this.fechaUltMod = fechaUltMod;
	}

	public BigDecimal getImporteTotal() {
		return this.importeTotal;
	}

	public void setImporteTotal(BigDecimal importeTotal) {
		this.importeTotal = importeTotal;
	}

	@JsonIgnore
	public List<TGenListaProducto> getTGenListaProductos() {
		return this.TGenListaProductos;
	}

	public void setTGenListaProductos(List<TGenListaProducto> TGenListaProductos) {
		this.TGenListaProductos = TGenListaProductos;
	}

	public TGenListaProducto addTGenListaProducto(TGenListaProducto TGenListaProducto) {
		getTGenListaProductos().add(TGenListaProducto);
		TGenListaProducto.setTGenLista(this);

		return TGenListaProducto;
	}

	public TGenListaProducto removeTGenListaProducto(TGenListaProducto TGenListaProducto) {
		getTGenListaProductos().remove(TGenListaProducto);
		TGenListaProducto.setTGenLista(null);

		return TGenListaProducto;
	}

	@Override
	public String toString() {
		return "TGenLista [idlista=" + idlista + ", fechaAlta=" + fechaAlta + ", fechaLista=" + fechaLista
				+ ", fechaUltMod=" + fechaUltMod + ", importeTotal=" + importeTotal + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaLista == null) ? 0 : fechaLista.hashCode());
		result = prime * result + ((fechaUltMod == null) ? 0 : fechaUltMod.hashCode());
		result = prime * result + idlista;
		result = prime * result + ((importeTotal == null) ? 0 : importeTotal.hashCode());
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
		TGenLista other = (TGenLista) obj;
		if (fechaAlta == null) {
			if (other.fechaAlta != null)
				return false;
		} else if (!fechaAlta.equals(other.fechaAlta))
			return false;
		if (fechaLista == null) {
			if (other.fechaLista != null)
				return false;
		} else if (!fechaLista.equals(other.fechaLista))
			return false;
		if (fechaUltMod == null) {
			if (other.fechaUltMod != null)
				return false;
		} else if (!fechaUltMod.equals(other.fechaUltMod))
			return false;
		if (idlista != other.idlista)
			return false;
		if (importeTotal == null) {
			if (other.importeTotal != null)
				return false;
		} else if (!importeTotal.equals(other.importeTotal))
			return false;
		return true;
	}

}