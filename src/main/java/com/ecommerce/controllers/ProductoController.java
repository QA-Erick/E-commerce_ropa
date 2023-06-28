package com.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecommerce.models.Producto;
import com.ecommerce.services.ProductoServiceImpl;

@Controller
public class ProductoController {
	@Autowired
	private ProductoServiceImpl productoService;
	
	@Value("${producto.urlBase}")
	private String urlBase;
	
	@ModelAttribute("productos")
	public List<Producto> listarProductos() {
		return productoService.getAllProductos();
	}
	
	@GetMapping("/index")
	public String index(Model model) {
		model.addAttribute("urlBase",urlBase);
		model.addAttribute("searchProducto",new Producto());
		return "index";
	}
	
	@PostMapping("/buscar")
	public String buscarProductos(@RequestParam("cadena") String prdNom, Model model) {
		model.addAttribute("urlBase",urlBase);
		model.addAttribute("productos",productoService.getAllProductosByNom(prdNom));
		return "index";
	}
	
	@GetMapping("/comingsoon")
	public String proximamente() {
		return "proximamente";
	}
}
