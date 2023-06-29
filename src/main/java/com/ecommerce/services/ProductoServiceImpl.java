package com.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.models.Producto;
import com.ecommerce.repositories.ProductoDao;

@Service
public class ProductoServiceImpl implements ProductoService {
	@Autowired
	private ProductoDao productoRepository;
	
	@Override
	public List<Producto> getAllProductos() {
		return productoRepository.findAll();
	}

	@Override
	public List<Producto> getAllProductosByNom(String nombre) {
		return productoRepository.findAllByPrdNomContainingIgnoreCase(nombre);
	}

	//NUEVOS MÉTODOS RAE
	//NUEVO
	@Override
	public Producto nuevoProducto(Producto producto) {
		return productoRepository.save(producto);
	}
	//ACTUALIZA
	@Override
	public Producto actualizaProducto(Producto prodAct) {
		if (!productoRepository.existsById(prodAct.getPrdId())) {
			throw new RuntimeException("El producto no existe en la base de datos.");
		}
		return productoRepository.save(prodAct);
	}
	//OBTIENE-EN FUNCION AL CAMPO DELETED FALSE/TRUE
	@Override
	public Producto getOneProducto(int id) {
		Optional<Producto> productoResult = productoRepository.findById(id);
		return productoResult.isPresent()? productoResult.get():null;
	}
	//ELIMINA - EN FUNCION AL CAMPO DELETED FALSE/TRUE
	@Override
	public void eliminaProducto(int id) {
		productoRepository.deleteByprdId(id);
	}

}
