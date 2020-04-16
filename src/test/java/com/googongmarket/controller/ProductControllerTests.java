package com.googongmarket.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.googongmarket.domain.ProductVO;
import com.googongmarket.service.ProductService;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ProductControllerTests {

	@Setter(onMethod_ = {@Autowired})
	private ProductService service;
	
	@Test
	public void testCreate() {
		
		ProductVO product = new ProductVO();
		product.setBno(1);
		product.setTitle("테스트제목입니다.");
		product.setContent("내용입니담");
		product.setSeller("지수");
		product.setCategory("전자제품");
		product.setPrice("1,000");
		product.setAmount(1);
		
		
		service.create(product);
		
		log.info("product : " + product);
	}
}
