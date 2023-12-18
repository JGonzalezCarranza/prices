package com.pruebaCapitol.prices;

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
	void prueba1() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/precios?fecha_aplicacion=2020-06-14-10.00.00&id_producto=35455&id_cadena=1")).build();
	    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	    String salidaJson = response.body();
	    Gson gson = new GsonBuilder().create();
	    Prices price = gson.fromJson(salidaJson, Prices.class);
	    assert(Math.abs(35.50-price.getPrice())< 0.0001f );
	}
	
	@Test
	void prueba2() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/precios?fecha_aplicacion=2020-06-14-16.00.00&id_producto=35455&id_cadena=1")).build();
	    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	    String salidaJson = response.body();
	    Gson gson = new GsonBuilder().create();
	    Prices price = gson.fromJson(salidaJson, Prices.class);
	    assert(Math.abs(25.45-price.getPrice())< 0.0001f);
	}
	
	@Test
	void prueba3() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/precios?fecha_aplicacion=2020-06-14-21.00.00&id_producto=35455&id_cadena=1")).build();
	    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	    String salidaJson = response.body();
	    Gson gson = new GsonBuilder().create();
	    Prices price = gson.fromJson(salidaJson, Prices.class);
	    assert(Math.abs(35.50-price.getPrice())< 0.0001f);
	}
	
	@Test
	void prueba4() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/precios?fecha_aplicacion=2020-06-15-10.00.00&id_producto=35455&id_cadena=1")).build();
	    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	    String salidaJson = response.body();
	    Gson gson = new GsonBuilder().create();
	    Prices price = gson.fromJson(salidaJson, Prices.class);
	    assert(Math.abs(30.5-price.getPrice())< 0.0001f );
	}
	
	@Test
	void prueba5() throws Exception {
		HttpClient client = HttpClient.newBuilder().build();
	    HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/precios?fecha_aplicacion=2020-06-16-21.00.00&id_producto=35455&id_cadena=1")).build();
	    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
	    String salidaJson = response.body();
	    Gson gson = new GsonBuilder().create();
	    Prices price = gson.fromJson(salidaJson, Prices.class);
	    assert(Math.abs(38.95-price.getPrice()) < 0.0001f);
	}


}
