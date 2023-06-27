package com.ecommerce.services;

import java.util.List;

import com.ecommerce.models.Producto;

public interface ProductoService {
	public List<Producto> getAllProductos();
	
	public List<Producto> getAllProductosByNom(String nombre);
}
