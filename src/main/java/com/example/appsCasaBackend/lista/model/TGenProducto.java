package com.example.appsCasaBackend.lista.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="T_GEN_PRODUCTO")
//@NamedQuery(name="TGenProducto.findAll", query="SELECT t FROM TGenProducto t")
public class TGenProducto implements Serializable {

	private static final long serialVersionUID = -4269876874068448427L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "producto_generator")
	@SequenceGenerator(name = "producto_generator", sequenceName = "SEQ_ID_PRODUCTO", allocationSize = 1)
	private Long idproducto;
	
	
	//private Long idtienda;

	private String capacidad;

	private String desProducto;

	private String embalaje;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAlta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaUltMod;

	private String peso;

	private BigDecimal precio;

	//bi-directional many-to-one association to TGenTienda
	@ManyToOne
	@JoinColumn(name="idtienda")
	private TGenTienda TGenTienda;

	//bi-directional many-to-one association to TMaeCategoriaProd
	@ManyToOne
	@JoinColumn(name="idcategoria")
	private TMaeCategoriaProd TMaeCategoriaProd;

	//bi-directional many-to-one association to TGenListaProducto
	@OneToMany(mappedBy="TGenProducto")
	private List<TGenListaProducto> TGenListaProductos = new ArrayList<TGenListaProducto>();

	
	public TGenProducto() {
	}

	public Long getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(Long idproducto) {
		this.idproducto = idproducto;
	}

//	public Long getIdtienda() {
//		return idtienda;
//	}
//
//	public void setIdtienda(Long idtienda) {
//		this.idtienda = idtienda;
//	}

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

	@JsonIgnore
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

	@Override
	public String toString() {
		return "TGenProducto [idproducto=" + idproducto + ", capacidad=" + capacidad + ", desProducto=" + desProducto
				+ ", embalaje=" + embalaje + ", fechaAlta=" + fechaAlta + ", fechaUltMod=" + fechaUltMod + ", peso="
				+ peso + ", precio=" + precio + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((capacidad == null) ? 0 : capacidad.hashCode());
		result = prime * result + ((desProducto == null) ? 0 : desProducto.hashCode());
		result = prime * result + ((embalaje == null) ? 0 : embalaje.hashCode());
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaUltMod == null) ? 0 : fechaUltMod.hashCode());
		result = prime * result + ((idproducto == null) ? 0 : idproducto.hashCode());
		result = prime * result + ((peso == null) ? 0 : peso.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
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
		TGenProducto other = (TGenProducto) obj;
		if (capacidad == null) {
			if (other.capacidad != null)
				return false;
		} else if (!capacidad.equals(other.capacidad))
			return false;
		if (desProducto == null) {
			if (other.desProducto != null)
				return false;
		} else if (!desProducto.equals(other.desProducto))
			return false;
		if (embalaje == null) {
			if (other.embalaje != null)
				return false;
		} else if (!embalaje.equals(other.embalaje))
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
		if (idproducto == null) {
			if (other.idproducto != null)
				return false;
		} else if (!idproducto.equals(other.idproducto))
			return false;
		if (peso == null) {
			if (other.peso != null)
				return false;
		} else if (!peso.equals(other.peso))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}

}