package ec.edu.ups.ppw64.demo64.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Universidad {

	@Id
	@GeneratedValue
	private int codigo;
	private String nombre;
	private String descripcion;
	private String ubicacion;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codifo) {
		this.codigo = codifo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}  
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String precio) {
		this.ubicacion = precio;
	}
	
	@Override
	public String toString() {
		return "Productos [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ ubicacion + "]";
	}
}
