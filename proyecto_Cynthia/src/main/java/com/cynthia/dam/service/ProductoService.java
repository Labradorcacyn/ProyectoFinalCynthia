package com.cynthia.dam.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.cynthia.dam.model.Categoria;
import com.cynthia.dam.model.Producto;
import com.cynthia.dam.repositorio.IProductoRepo;
import com.cynthia.dam.service.base.BaseService;

@Service
public class ProductoService extends BaseService<Producto, Long, IProductoRepo>{
	
	public List<Producto> findAllByCategoria(Categoria categoria) {
		return repository.findByCategoria(categoria);
	}	
	
	public List<Producto> findAllByCategoria(Long categoriaId) {
		return repository.findByCategoriaId(categoriaId);
	}
	
	public int numeroProductosCategoria(Categoria categoria) {
		return repository.findNumProductosByCategoria(categoria);
	}

	public List<Producto> obtenerProductosAleatorios(int numero) {
		
		List<Long> listaIds = repository.obtenerIds();
		
		Collections.shuffle(listaIds);
		
		listaIds = listaIds.stream().limit(numero).collect(Collectors.toList());
		
		return repository.findAllById(listaIds);

	}
	
	public Producto save(Producto producto) {
		return repository.save(producto);
	}
	
	public void delete(Producto producto) {
		Producto result = findById(producto.getIdProducto()).orElse(null);
		if(result!=null) {
		repository.delete(result);
		}
	}
	
	//Método para el buscador
	public List<Producto> obtenerProductosPorNombre(String buscar){
		return repository.buscarPorNombre(buscar.toUpperCase()); 
	}
}
