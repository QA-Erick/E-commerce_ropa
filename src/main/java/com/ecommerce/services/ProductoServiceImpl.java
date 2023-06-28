package com.ecommerce.services;

import java.util.List;

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

}
