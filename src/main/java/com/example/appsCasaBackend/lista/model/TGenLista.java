package com.example.appsCasaBackend.lista.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
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
	private int idLista;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Temporal(TemporalType.DATE)
	@Column(name="fecha_lista")
	private Date fechaLista;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_ult_mod")
	private Date fechaUltMod;

	@Column(name="importe_total")
	private BigDecimal importeTotal;

	//bi-directional many-to-one association to TGenListaProducto
	@OneToMany(mappedBy="TGenLista")
	private List<TGenListaProducto> TGenListaProductos;

	
	public TGenLista() {
	}

	public int getIdLista() {
		return this.idLista;
	}

	public void setIdLista(int idLista) {
		this.idLista = idLista;
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

}