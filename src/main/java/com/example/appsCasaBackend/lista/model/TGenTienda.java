package com.example.appsCasaBackend.lista.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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


@Entity
@Table(name="T_GEN_TIENDA")
public class TGenTienda implements Serializable {

	private static final long serialVersionUID = 3613216488670652658L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tienda_generator")
	@SequenceGenerator(name = "tienda_generator", sequenceName = "seq_id_tienda", allocationSize = 1)
	@Column(name="idtienda")
	private Long idTienda;

	private String desTienda;

	private String direccion;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaAlta;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaUltMod;

	private String telefono;

	//bi-directional many-to-one association to TGenProducto
	@OneToMany(mappedBy="TGenTienda")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desTienda == null) ? 0 : desTienda.hashCode());
		result = prime * result + ((direccion == null) ? 0 : direccion.hashCode());
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaUltMod == null) ? 0 : fechaUltMod.hashCode());
		result = prime * result + ((idTienda == null) ? 0 : idTienda.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
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
		TGenTienda other = (TGenTienda) obj;
		if (desTienda == null) {
			if (other.desTienda != null)
				return false;
		} else if (!desTienda.equals(other.desTienda))
			return false;
		if (direccion == null) {
			if (other.direccion != null)
				return false;
		} else if (!direccion.equals(other.direccion))
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
		if (idTienda == null) {
			if (other.idTienda != null)
				return false;
		} else if (!idTienda.equals(other.idTienda))
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		return true;
	}

}
