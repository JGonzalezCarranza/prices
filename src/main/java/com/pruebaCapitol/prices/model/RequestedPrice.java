package com.pruebaCapitol.prices.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RequestedPrice {
	private int id;
	private int brandId;
	private float priceList;
	private String startDate;
	private String endDate;
	private float price;
}
