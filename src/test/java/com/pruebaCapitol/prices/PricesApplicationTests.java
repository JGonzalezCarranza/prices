package com.pruebaCapitol.prices;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.RoundingMode;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.text.NumberFormat;
import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pruebaCapitol.prices.entity.Prices;
import com.pruebaCapitol.prices.utils.exceptions.ErrorResponse;

@SpringBootTest
class PricesApplicationTests {


	
	public NumberFormat formato() {
		NumberFormat formatter = NumberFormat.getInstance(Locale.US);
		formatter.setMaximumFractionDigits(2);
		formatter.setMinimumFractionDigits(2);
		formatter.setRoundingMode(RoundingMode.HALF_UP); 
		return formatter;
	}
	
	@Test
	void salidaCorrectaPeticion1() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
		
	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/precios?fecha_aplicacion=2020-06-14-10.00.00&id_producto=35455&id_cadena=1")).build();
	    
	    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	    String salidaJson = response.body();
	    Gson gson = new GsonBuilder().create();
	    Prices price = gson.fromJson(salidaJson, Prices.class);
	    //precio de salida de la peticion es igual al esperado
	    assert(Math.abs(35.50-price.getPrice())< 0.0001f );
	}
	
	@Test
	void salidaCorrectaPeticion2() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
		
	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/precios?fecha_aplicacion=2020-06-14-16.00.00&id_producto=35455&id_cadena=1")).build();
	    
	    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	    String salidaJson = response.body();
	    Gson gson = new GsonBuilder().create();
	    Prices price = gson.fromJson(salidaJson, Prices.class);
	  //precio de salida de la peticion es igual al esperado
	    assert(Math.abs(25.45-price.getPrice())< 0.0001f);
	}
	
	@Test
	void salidaCorrectaPeticion3() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
		
	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/precios?fecha_aplicacion=2020-06-14-21.00.00&id_producto=35455&id_cadena=1")).build();
	    
	    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	    String salidaJson = response.body();
	    Gson gson = new GsonBuilder().create();
	    Prices price = gson.fromJson(salidaJson, Prices.class);
	  //precio de salida de la peticion es igual al esperado
	    assert(Math.abs(35.50-price.getPrice())< 0.0001f);
	}
	
	@Test
	void salidaCorrectaPeticion4() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
		
	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/precios?fecha_aplicacion=2020-06-15-10.00.00&id_producto=35455&id_cadena=1")).build();
	    
	    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	    String salidaJson = response.body();
	    Gson gson = new GsonBuilder().create();
	    Prices price = gson.fromJson(salidaJson, Prices.class);
	  //precio de salida de la peticion es igual al esperado
	    assert(Math.abs(30.5-price.getPrice())< 0.0001f );
	}
	
	@Test
	void salidaCorrectaPeticion5() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
		
	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/precios?fecha_aplicacion=2020-06-16-21.00.00&id_producto=35455&id_cadena=1")).build();
	    
	    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	    String salidaJson = response.body();
	    Gson gson = new GsonBuilder().create();
	    Prices price = gson.fromJson(salidaJson, Prices.class);
	  //precio de salida de la peticion es igual al esperado
	    assert(Math.abs(38.95-price.getPrice()) < 0.0001f);
	}
	
	@Test
	void errorFormatoFechaMesIncorrecto() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
		
	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/precios?fecha_aplicacion=2020-13-16-21.00.00&id_producto=35455&id_cadena=1")).build();
	    
	    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	    String salidaJson = response.body();
	    Gson gson = new GsonBuilder().create();
	    ErrorResponse error = gson.fromJson(salidaJson, ErrorResponse.class);
	    assertEquals(error.getMessage(), "Formato de fecha no valido. Formato correcto -> yyyy-MM-dd-hh.mm.ss");
	}
	
	@Test
	void errorFormatoFechaIncorrecto() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
		
	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/precios?fecha_aplicacion=2020-a-16-21.00.00&id_producto=35455&id_cadena=1")).build();
	    
	    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	    String salidaJson = response.body();
	    Gson gson = new GsonBuilder().create();
	    ErrorResponse error = gson.fromJson(salidaJson, ErrorResponse.class);
	    assertEquals(error.getMessage(), "Formato de fecha no valido. Formato correcto -> yyyy-MM-dd-hh.mm.ss");
	}
	
	@Test
	void errorFormatoNumero() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
		
	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/precios?fecha_aplicacion=2020-06-16-21.00.00&id_producto=35455&id_cadena=a")).build();
	    
	    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	    String salidaJson = response.body();
	    Gson gson = new GsonBuilder().create();
	    ErrorResponse error = gson.fromJson(salidaJson, ErrorResponse.class);
	    assertEquals(error.getMessage(), "Formato de numero incorrecto.");
	}
	
	@Test
	void precioNoExistente() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
		
	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/precios?fecha_aplicacion=2020-06-16-21.00.00&id_producto=35455&id_cadena=99")).build();
	    
	    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	    String salidaJson = response.body();
	    Gson gson = new GsonBuilder().create();
	    ErrorResponse error = gson.fromJson(salidaJson, ErrorResponse.class);
	    assertEquals(error.getMessage(), "No se encontro precio adecuado para los parametros de entrada.");
	}
	
	


}
