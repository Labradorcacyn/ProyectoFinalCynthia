package com.cynthia.dam.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.cynthia.dam.model.Producto;
import com.cynthia.dam.service.CategoriaService;
import com.cynthia.dam.service.ProductoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MainController {

	private final ProductoService pS;

	private final CategoriaService cS;

	private static final int NUM_PRODUCTOS_ALEATORIOS = 5;

	@GetMapping("/")
	public String index(@RequestParam(name="idCategoria", required=false) Long idCategoria, Model model, @RequestParam(name = "nombre", required = false)String nombre) {		
		
		model.addAttribute("categorias", cS.findAll());
		
		List<Producto> productos = pS.findAll();
		
		List<Producto> aleatorios;
		
		aleatorios = pS.obtenerProductosAleatorios(NUM_PRODUCTOS_ALEATORIOS);
		
		if (idCategoria != null) {
			productos = pS.findAllByCategoria(idCategoria);

		} else if(nombre != null){
			productos = pS.obtenerProductosPorNombre(nombre);
		}
		
		model.addAttribute("productos", productos);
		model.addAttribute("aleatorios", aleatorios);
		
		return "index";
	
	}

	@GetMapping("/product/{id}")
	public String showDetails(@PathVariable("id") Long id, Model model) {

		Producto p = pS.findById(id).orElse(null);

		if (p != null) {
			model.addAttribute("producto", p);
			return "detail";
		}

		return "redirect:/";

	}
}
