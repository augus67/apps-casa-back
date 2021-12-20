package com.example.appsCasaBackend.lista.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="T_MAE_CATEGORIA_PROD")
//@NamedQuery(name="TMaeCategoriaProd.findAll", query="SELECT t FROM TMaeCategoriaProd t")
public class TMaeCategoriaProd implements Serializable {

	private static final long serialVersionUID = 5288272371298158664L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catprod_generator")
	@SequenceGenerator(name = "catprod_generator", sequenceName = "SEQ_ID_CATPROD", allocationSize = 1)
	private Long idcategoria;

	private String codCategoria;

	private String desCategoria;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAlta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaUltMod;

	//bi-directional many-to-one association to TGenProducto
	@OneToMany(mappedBy="TMaeCategoriaProd")
	private List<TGenProducto> TGenProductos;

	public TMaeCategoriaProd() {
	}

	public Long getIdCategoria() {
		return this.idcategoria;
	}

	public void setIdCategoria(Long idcategoria) {
		this.idcategoria = idcategoria;
	}

	public String getCodCategoria() {
		return this.codCategoria;
	}

	public void setCodCategoria(String codCategoria) {
		this.codCategoria = codCategoria;
	}

	public String getDesCategoria() {
		return this.desCategoria;
	}

	public void setDesCategoria(String desCategoria) {
		this.desCategoria = desCategoria;
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

	public List<TGenProducto> getTGenProductos() {
		return this.TGenProductos;
	}

	public void setTGenProductos(List<TGenProducto> TGenProductos) {
		this.TGenProductos = TGenProductos;
	}

	public TGenProducto addTGenProducto(TGenProducto TGenProducto) {
		getTGenProductos().add(TGenProducto);
		TGenProducto.setTMaeCategoriaProd(this);

		return TGenProducto;
	}

	public TGenProducto removeTGenProducto(TGenProducto TGenProducto) {
		getTGenProductos().remove(TGenProducto);
		TGenProducto.setTMaeCategoriaProd(null);

		return TGenProducto;
	}

}