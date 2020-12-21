package com.example.appsCasaBackend.lista.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the T_GEN_PRODUCTO database table.
 * 
 */
@Entity
@Table(name="T_GEN_PRODUCTO")
@NamedQuery(name="TGenProducto.findAll", query="SELECT t FROM TGenProducto t")
public class TGenProducto implements Serializable {

	private static final long serialVersionUID = -4269876874068448427L;

	@Id
	private short idProducto;

	@Column(name="capacidad")
	private String capacidad;

	@Column(name="des_producto")
	private String desProducto;

	@Column(name="embalaje")
	private String embalaje;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_ult_mod")
	private Date fechaUltMod;

	@Column(name="peso")
	private String peso;

	@Column(name="precio")
	private BigDecimal precio;

	//bi-directional many-to-one association to TGenTienda
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idTienda")
	private TGenTienda TGenTienda;

	//bi-directional many-to-one association to TMaeCategoriaProd
	@ManyToOne
	@JoinColumn(name="idCategoria")
	private TMaeCategoriaProd TMaeCategoriaProd;

	//bi-directional many-to-one association to TGenListaProducto
	@OneToMany(mappedBy="TGenProducto")
	private List<TGenListaProducto> TGenListaProductos;

	
	public TGenProducto() {
	}

	public short getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(short idProducto) {
		this.idProducto = idProducto;
	}

	public String getCapacidad() {
		return this.capacidad;
	}

	public void setCapacidad(String capacidad) {
		this.capacidad = capacidad;
	}

	public String getDesProducto() {
		return this.desProducto;
	}

	public void setDesProducto(String desProducto) {
		this.desProducto = desProducto;
	}

	public String getEmbalaje() {
		return this.embalaje;
	}

	public void setEmbalaje(String embalaje) {
		this.embalaje = embalaje;
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

	public String getPeso() {
		return this.peso;
	}

	public void setPeso(String peso) {
		this.peso = peso;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public TGenTienda getTGenTienda() {
		return this.TGenTienda;
	}

	public void setTGenTienda(TGenTienda TGenTienda) {
		this.TGenTienda = TGenTienda;
	}

	public TMaeCategoriaProd getTMaeCategoriaProd() {
		return this.TMaeCategoriaProd;
	}

	public void setTMaeCategoriaProd(TMaeCategoriaProd TMaeCategoriaProd) {
		this.TMaeCategoriaProd = TMaeCategoriaProd;
	}

	public List<TGenListaProducto> getTGenListaProductos() {
		return this.TGenListaProductos;
	}

	public void setTGenListaProductos(List<TGenListaProducto> TGenListaProductos) {
		this.TGenListaProductos = TGenListaProductos;
	}

	public TGenListaProducto addTGenListaProducto(TGenListaProducto TGenListaProducto) {
		getTGenListaProductos().add(TGenListaProducto);
		TGenListaProducto.setTGenProducto(this);

		return TGenListaProducto;
	}

	public TGenListaProducto removeTGenListaProducto(TGenListaProducto TGenListaProducto) {
		getTGenListaProductos().remove(TGenListaProducto);
		TGenListaProducto.setTGenProducto(null);

		return TGenListaProducto;
	}

}