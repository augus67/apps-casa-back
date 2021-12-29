package com.example.appsCasaBackend.lista.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="T_MAE_CATEGORIA_PROD")
@NamedQuery(name="TMaeCategoriaProd.findAll", query="SELECT t FROM TMaeCategoriaProd t")
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
	private List<TGenProducto> TGenProductos = new ArrayList<TGenProducto>();

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

	@JsonIgnore
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

	

	@Override
	public String toString() {
		return "TMaeCategoriaProd [idcategoria=" + idcategoria + ", codCategoria=" + codCategoria + ", desCategoria="
				+ desCategoria + ", fechaAlta=" + fechaAlta + ", fechaUltMod=" + fechaUltMod + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codCategoria == null) ? 0 : codCategoria.hashCode());
		result = prime * result + ((desCategoria == null) ? 0 : desCategoria.hashCode());
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaUltMod == null) ? 0 : fechaUltMod.hashCode());
		result = prime * result + ((idcategoria == null) ? 0 : idcategoria.hashCode());
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
		TMaeCategoriaProd other = (TMaeCategoriaProd) obj;
		if (codCategoria == null) {
			if (other.codCategoria != null)
				return false;
		} else if (!codCategoria.equals(other.codCategoria))
			return false;
		if (desCategoria == null) {
			if (other.desCategoria != null)
				return false;
		} else if (!desCategoria.equals(other.desCategoria))
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
		if (idcategoria == null) {
			if (other.idcategoria != null)
				return false;
		} else if (!idcategoria.equals(other.idcategoria))
			return false;
		return true;
	}

}