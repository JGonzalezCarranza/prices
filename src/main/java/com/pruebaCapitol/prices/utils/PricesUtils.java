package com.pruebaCapitol.prices.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.pruebaCapitol.prices.utils.exceptions.InvalidDateException;

public class PricesUtils {
	
	private static String formatoFecha = "yyyy-MM-dd-HH.mm.ss";
	
	public static boolean checkFormatoFechaCorrecto(String fechaAplicacion) {
		Date date = null;
	        try {
	            SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
	            date = sdf.parse(fechaAplicacion);
	            if (!fechaAplicacion.equals(sdf.format(date))) {
	            	 throw new InvalidDateException();
	            }
	        } catch (ParseException ex) {
	            throw new InvalidDateException();
	            
	        }
	        return true;
	}

	public static int checkEsNumero(String numero) throws NumberFormatException {
		    return Integer.parseInt(numero);
	}
}
