package com.pruebaCapitol.prices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaCapitol.prices.entity.Prices;
import com.pruebaCapitol.prices.repository.PricesRepository;
import com.pruebaCapitol.prices.utils.PricesUtils;
import com.pruebaCapitol.prices.utils.exceptions.InvalidDateException;
import com.pruebaCapitol.prices.utils.exceptions.InvalidNumber;


@Service
public class PricesServiceImpl implements PricesService{
	
	@Autowired
	PricesRepository repositorio;
	
	@Override
	public Optional<Prices> obtenerPrecio(String fechaAplicacion, String idProducto, String idCadena) {
		Optional<Prices> precio = null; 
		try {
			boolean formatoCorrecto = PricesUtils.checkFormatoFechaCorrecto(fechaAplicacion);
			int idProductoCorrecto = PricesUtils.checkEsNumero(idProducto);
			int idCadenaCorrecto = PricesUtils.checkEsNumero(idCadena);
			
			precio = repositorio.findById(1);
		}
		catch(NumberFormatException ex) {
				throw new InvalidNumber();
		}
		catch(InvalidDateException ex) {
			throw new InvalidDateException();
		}
		return precio;
	}
	
}