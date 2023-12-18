package com.pruebaCapitol.prices.service;

import java.util.Optional;

import com.pruebaCapitol.prices.entity.Prices;


public interface PricesService {

	Optional<Prices> obtenerPrecio(String fechaAplicacion, String idProducto, String idCaden);
}