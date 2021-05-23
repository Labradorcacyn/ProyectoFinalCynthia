package com.cynthia.dam.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

	@Id
	@GeneratedValue
	private long idProducto;

	@ManyToOne
	private Categoria categoria;

	private String nombre;
	private String color;
	private double precio;
	private String img;
	private LocalDateTime registro;
	@Lob
	private String descripcion;

	private double diametro;

	public Producto(Categoria cat, String nombre, String color, double precio, String img, LocalDateTime registro,
			String descripcion, double diametro) {
		super();
		this.categoria = cat;
		this.nombre = nombre;
		this.color = color;
		this.precio = precio;
		this.img = img;
		this.registro = registro;
		this.descripcion = descripcion;
		this.diametro = diametro;
	}

}
