package com.cynthia.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cynthia.dam.model.Producto;
import com.cynthia.dam.service.CategoriaService;
import com.cynthia.dam.service.ProductoService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

@RequestMapping("/productos")
public class ProductoController {

private final ProductoService pS;

private final CategoriaService cS;
	
	@GetMapping("")
	public String todosLosProductos(Model model) {
		model.addAttribute("productos", pS.findAll());		
		return "index";
	}
	
	@GetMapping("/{id}")
	public String unProducto(@PathVariable("id") Long productoId, Model model) {
		Producto p = pS.findById(productoId).orElse(null);
		if (p != null) {
			model.addAttribute("producto", p);
			return "detail";
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/nuevo")
	public String nuevaProducto(Model model) {
		
		model.addAttribute("producto", new Producto());
		
		model.addAttribute("categorias", cS.findAll());
		return "productoForm";
	}

	@PostMapping("/nuevo/submit")
	public String submitNuevoProducto(Producto producto, Model model) {

		pS.save(producto);
		return "redirect:/";

	}
	
	@GetMapping("/editar/{id}")
	public String editarProducto(@PathVariable("id") Long id, Model model) {

		Producto producto = pS.findById(id).orElse(null);

		if (producto != null) {
			model.addAttribute("producto", producto);
			model.addAttribute("categorias", cS.findAll());
			return "productoForm";
		} else {
			return "redirect:/";
		}

	}
	
	@PostMapping("/editar/{id}/submit")
	public String submitEditar(@ModelAttribute("producto") Producto p, @PathVariable("id") Long id, Model model) {
		if(p.getIdProducto() == id) {
		pS.edit(p);
		}
		return "redirect:/productos";
	}
		
	@GetMapping("/borrar/{id}")
	public String borrarProducto(@PathVariable("id") Long id, Model model) {

		Producto producto = pS.findById(id).orElse(null);

		if (producto != null) {
			pS.delete(producto);
		}

		return "redirect:/";
	}

}
