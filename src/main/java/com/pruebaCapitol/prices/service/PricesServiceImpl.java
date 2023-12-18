package com.pruebaCapitol.prices.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaCapitol.prices.entity.Prices;
import com.pruebaCapitol.prices.repository.PricesRepository;
import com.pruebaCapitol.prices.utils.PricesUtils;
import com.pruebaCapitol.prices.utils.exceptions.InvalidDateException;
import com.pruebaCapitol.prices.utils.exceptions.InvalidNumber;
import com.pruebaCapitol.prices.utils.exceptions.PriceNotFound;


@Service
public class PricesServiceImpl implements PricesService{
	
	@Autowired
	PricesRepository repositorio;
	
	@Override
	public Prices obtenerPrecio(String fechaAplicacion, String idProducto, String idCadena) {
		Prices precio = null; 
		try {
			boolean formatoCorrecto = PricesUtils.checkFormatoFechaCorrecto(fechaAplicacion);
			int idProductoCorrecto = PricesUtils.checkEsNumero(idProducto);
			int idCadenaCorrecto = PricesUtils.checkEsNumero(idCadena);
			
			List<Prices> lista = new ArrayList<>();
			lista = repositorio.obtenerProductoPorFechaEidProductoYCadena(fechaAplicacion, idProductoCorrecto, idCadenaCorrecto);
				
			if(lista.isEmpty()) {
				throw new PriceNotFound();
			}
			//Lista ordenada por prioridad descendente
			//El elemento 0 es el de mayor prioridad
			precio = lista.get(0);
			
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