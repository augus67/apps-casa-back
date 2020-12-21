package com.example.appsCasaBackend.lista.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the T_GEN_TIENDA database table.
 * 
 */
@Entity
@Table(name="T_GEN_TIENDA")
public class TGenTienda implements Serializable {

	private static final long serialVersionUID = 3613216488670652658L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tienda_generator")
	@SequenceGenerator(name = "tienda_generator", sequenceName = "seq_id_tienda", allocationSize = 1)
	private Long idTienda;

	@Column(name="des_tienda")
	private String desTienda;

	@Column(name="direccion")
	private String direccion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_ult_mod")
	private Date fechaUltMod;

	@Column(name="telefono")
	private String telefono;

	//bi-directional many-to-one association to TGenProducto
	@OneToMany(mappedBy="TGenTienda", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TGenProducto> TGenProductos = new ArrayList<TGenProducto>();

	
	public TGenTienda() {
		
	}

	public Long getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(Long idTienda) {
		this.idTienda = idTienda;
	}

	public String getDesTienda() {
		return this.desTienda;
	}

	public void setDesTienda(String desTienda) {
		this.desTienda = desTienda;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
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

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<TGenProducto> getTGenProductos() {
		return this.TGenProductos;
	}

	public void setTGenProductos(List<TGenProducto> TGenProductos) {
		this.TGenProductos.addAll(TGenProductos);
	}

	public TGenProducto addTGenProducto(TGenProducto TGenProducto) {
		getTGenProductos().add(TGenProducto);
		TGenProducto.setTGenTienda(this);

		return TGenProducto;
	}

	public TGenProducto removeTGenProducto(TGenProducto TGenProducto) {
		getTGenProductos().remove(TGenProducto);
		TGenProducto.setTGenTienda(null);

		return TGenProducto;
	}
	
	public void removeTGenProductos() {
		Iterator<TGenProducto> itTGenProductos = this.TGenProductos.iterator();
		
		while(itTGenProductos.hasNext()){
			TGenProducto producto = itTGenProductos.next();			
			producto.setTGenTienda(null);
			itTGenProductos.remove();			
		}
	}

	@Override
	public String toString() {
		return "TGenTienda [idTienda=" + idTienda + ", desTienda=" + desTienda + ", direccion=" + direccion
				+ ", fechaAlta=" + fechaAlta + ", fechaUltMod=" + fechaUltMod + ", telefono=" + telefono + "]";
	}

}
