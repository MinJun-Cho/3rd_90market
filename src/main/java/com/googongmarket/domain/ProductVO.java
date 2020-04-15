package com.googongmarket.domain;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class ProductVO {

	private int bno;
	private String title;
	private String content;
	private String writer;
	private String category;
	private int amount;
	private int price;
	private String filepath;
	private LocalDateTime regTime;
	private LocalDateTime updateTime;
}
