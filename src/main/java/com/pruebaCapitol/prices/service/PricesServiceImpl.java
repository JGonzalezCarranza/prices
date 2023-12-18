package com.pruebaCapitol.prices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaCapitol.prices.entity.Prices;
import com.pruebaCapitol.prices.repository.PricesRepository;


@Service
public class PricesServiceImpl implements PricesService{
	
	@Autowired
	PricesRepository repositorio;

	//@Override
	public Optional<Prices> obtenerPrecio(String fechaAplicacion, String idProducto, String idCadena) {
		return repositorio.findById(1);
		
	}
	
}