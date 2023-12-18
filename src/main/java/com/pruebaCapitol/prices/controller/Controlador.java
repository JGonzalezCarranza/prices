package com.pruebaCapitol.prices.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pruebaCapitol.prices.entity.Prices;
import com.pruebaCapitol.prices.service.PricesService;


@RestController
public class Controlador {

	@Autowired
	private PricesService service;
	
	@GetMapping("precios")
	public Optional<Prices> getPrecio(
			@RequestParam("fecha_aplicacion") String fecha,
			@RequestParam("id_producto") String idProducto,
			@RequestParam("id_cadena") String idCadena) {
		
		return service.obtenerPrecio(fecha, idProducto, idCadena);
	}
	
	
}