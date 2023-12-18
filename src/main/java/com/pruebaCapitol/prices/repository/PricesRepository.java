package com.pruebaCapitol.prices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pruebaCapitol.prices.entity.Prices;

public interface PricesRepository extends JpaRepository<Prices, Integer> {
	
	@Query(value = "SELECT ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY,"
			+ " PRICE, CURR FROM PRICES WHERE START_DATE <= PARSEDATETIME(:fecha, 'yyyy-MM-dd-HH.mm.ss') "
			+ "AND  END_DATE >= PARSEDATETIME(:fecha, 'yyyy-MM-dd-HH.mm.ss') AND PRODUCT_ID = :idProducto "
			+ "AND BRAND_ID = :idCadena ORDER BY PRIORITY DESC" ,
			nativeQuery = true)
	List<Prices> obtenerProductoPorFechaEidProductoYCadena(
			@Param("fecha") String fecha,
			@Param("idProducto") int idProducto,
			@Param("idCadena") int idCadena);
	
}

