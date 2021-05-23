package com.cynthia.dam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.cynthia.dam.model.Categoria;
import com.cynthia.dam.service.CategoriaService;
import com.cynthia.dam.service.ProductoService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor

@RequestMapping("/categorias")
public class CategoriaController {
	private final CategoriaService servicio;
	
	private final ProductoService productoService;
	
	@GetMapping("")
	public String todosLosProductos(Model model) {
		model.addAttribute("categorias", servicio.findAll());		
		return "listaCategorias";
	}
	
	@GetMapping("/nueva")
	public String nuevaCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "categoriaForm";
	}
	
	@PostMapping("/nueva/submit")
	public String submitNuevaCategoria(@ModelAttribute("categoria") Categoria categoria, Model model) {
		
		servicio.save(categoria);
		
		return "redirect:/categorias";
	}
	
	@GetMapping("/editar/{id}")
	public String editarCategoria(@PathVariable("id") Long id, Model model) {
		
		Categoria categoria = servicio.findById(id).orElse(null);
		
		if (categoria != null) {
			model.addAttribute("categoria", categoria);
			return "categoriaForm";
		} else {
			return "redirect:/categorias";
		}
		
	}
	
	@PostMapping("/editar/{id}/submit")
	public String submitEditar(@ModelAttribute("producto") Categoria c, @PathVariable("id") Long id, Model model) {
		if(c.getIdCategoria() == id) {
		servicio.edit(c);
		}
		return "redirect:/categorias";
	}
	
	
	@GetMapping("/borrar/{id}")
	public String borrarCategoria(@PathVariable("id") Long id, Model model) {
		
		Categoria categoria = servicio.findById(id).orElse(null);
		
		if (categoria != null) {
			
			if (productoService.numeroProductosCategoria(categoria) == 0) {
				servicio.delete(categoria);				
			} else {
					
				return "redirect:/categorias?error=true";
			}
			
		} 

		return "redirect:/categorias";
		
	}
}
