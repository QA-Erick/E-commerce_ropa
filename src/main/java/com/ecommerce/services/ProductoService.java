package com.ecommerce.services;

import java.util.List;

import com.ecommerce.models.Producto;

public interface ProductoService {
	public List<Producto> getAllProductos();
	
	public List<Producto> getAllProductosByNom(String nombre);
	//NUEVOS MÉTODOS RAE
	//NUEVO
	Producto nuevoProducto(Producto producto);
	//ACTUALIZA
	Producto actualizaProducto(Producto prodAct);
	//OBTIENE
	Producto getOneProducto(int id);
	//ELIMINA
	void eliminaProducto(int id);
}
