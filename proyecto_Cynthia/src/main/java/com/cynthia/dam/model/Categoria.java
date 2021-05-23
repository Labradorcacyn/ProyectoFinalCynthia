package com.cynthia.dam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Categoria {
	@Id
	@GeneratedValue
	private long idCategoria;
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy="categoria", fetch = FetchType.EAGER)
	private List<Producto> productos = new ArrayList<>();
	
	private String nombre;

	public Categoria(String nombre) {
		super();
		this.nombre = nombre;
	}
	
}
