package com.googongmarket.domain;

import lombok.Data;

@Data
public class ProductVO {

	private int bno;
	private String title;
	private String content;
	private String seller;
	private String category;
	private int amount;
	private String price;
	private String thumbnail;
}
