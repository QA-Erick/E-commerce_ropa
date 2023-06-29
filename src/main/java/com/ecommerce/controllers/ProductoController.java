package com.ecommerce.controllers;

import java.util.List;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
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
	
	protected final Log logger = LogFactory.getLog(this.getClass()); //AGREGO UN OBJ LOG PARA EXTRAER INFORMACION
	
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

	//UN GET MAPPING PARA LA PESTAÑA PRODUCTOS
	@GetMapping("/producto_gest")
	public String producto_gest(Model model) {
		model.addAttribute("productos",productoService.getAllProductos());
		return "producto_gest";
	}
	
	//MODEL ATRIBUTTE PARA OBTENER UN PRODUCTO
//	@ModelAttribute("one_Producto")
//	public Producto one_Producto(int id) {
//		Producto one_Producto =  productoService.getOneProducto(id);
//		return one_Producto;
//	}
	
	  @GetMapping("/delete/{prdId}")
	    public String deleteProducto(@PathVariable int prdId) {
	        productoService.eliminaProducto(prdId);
	        return "redirect:/index";
	    }
	  
	  @GetMapping("/editprd/{prdId}")
	    public String showEditForm(@PathVariable("prdId") int prdId, Model model) {
	        Producto producto = productoService.getOneProducto(prdId);
	        model.addAttribute("producto", producto);
	        return "editprd";
	    }

	    @PostMapping("/editprd/{prdId}")
	    public String updateProducto(@PathVariable("prdId") int prdId, @ModelAttribute Producto producto) {
	        producto.setPrdId(prdId);
	        productoService.nuevoProducto(producto);
	        return "producto_gest";
	    }
	    
	  @GetMapping("/addprd")
	    public String showAddForm(Model model) {
	        Producto producto = new Producto();
	        model.addAttribute("producto", producto);
	        return "addprd";
	    }

	    @PostMapping("/addprd")
	    public String addProducto(@ModelAttribute Producto producto) {
	        productoService.nuevoProducto(producto);
	        return "producto_gest";
	    }
	
}
