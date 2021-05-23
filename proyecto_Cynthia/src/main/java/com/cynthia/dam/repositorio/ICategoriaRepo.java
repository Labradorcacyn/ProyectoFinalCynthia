package com.cynthia.dam.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cynthia.dam.model.Categoria;

public interface ICategoriaRepo extends JpaRepository<Categoria, Long> {

}
