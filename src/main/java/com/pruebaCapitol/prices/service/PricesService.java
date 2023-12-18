package com.pruebaCapitol.prices.service;


import com.pruebaCapitol.prices.model.RequestedPrice;


public interface PricesService {

	RequestedPrice obtenerPrecio(String fechaAplicacion, String idProducto, String idCaden);
}