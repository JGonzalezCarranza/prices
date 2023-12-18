package com.pruebaCapitol.prices.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebaCapitol.prices.entity.Prices;
import com.pruebaCapitol.prices.model.RequestedPrice;
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
	public RequestedPrice obtenerPrecio(String fechaAplicacion, String idProducto, String idCadena) {
		Prices price = null; 
		RequestedPrice finalPrice = null;
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
			price = lista.get(0);
			
			finalPrice = RequestedPrice.builder()
					.brandId(price.getBrandId())
					.endDate(price.getEndDate())
					.id(price.getId())
					.price(price.getPrice())
					.priceList(price.getPriceList())
					.startDate(price.getStartDate())
					.build();
			
		}
		catch(NumberFormatException ex) {
				throw new InvalidNumber();
		}
		catch(InvalidDateException ex) {
			throw new InvalidDateException();
		}
		return finalPrice;
	}
	
}