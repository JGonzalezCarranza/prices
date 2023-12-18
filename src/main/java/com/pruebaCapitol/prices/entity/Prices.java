package com.pruebaCapitol.prices.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "PRICES")
@Data
public class Prices {


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(name="BRAND_ID")
	private int brandId;
	@Column(name="START_DATE")
	private String startDate;
	@Column(name="END_DATE")
	private String endDate;
	@Column(name="PRICE_LIST")
	private float priceList;
	@Column(name="PRODUCT_ID")
	private int productId;
	@Column(name="PRIORITY")
	private int priority;
	@Column(name="PRICE")
	private float price;
	@Column(name="CURR")
	private String curr;
	

}
