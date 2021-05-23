package com.cynthia.dam.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cynthia.dam.model.Categoria;
import com.cynthia.dam.model.Producto;

public interface IProductoRepo extends JpaRepository<Producto, Long>{
	public List<Producto> findByCategoria(Categoria categoria);
	
	@Query("select p.id from Producto p")
	public List<Long> obtenerIds();
	
	@Query("select p from Producto p where p.categoria.id = ?1")
	public List<Producto> findByCategoriaId(Long categoriaId);

	@Query("select count(p) from Producto p where p.categoria = ?1")
	public int findNumProductosByCategoria(Categoria categoria);
	
	//Consulta para el buscador
	
	@Query("select p from Producto p where p.nombre like %:buscar%")
	public List<Producto> buscarPorNombre(@Param("buscar")String buscar);

}


	
