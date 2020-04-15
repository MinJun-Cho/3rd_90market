package com.googongmarket.service;

import java.util.List;

import com.googongmarket.domain.ImageVO;
import com.googongmarket.domain.ProductVO;

public interface ProductService {
	
	public List<ProductVO> getList();

	public void create(ProductVO product);
	
	public void createFile(ImageVO image);
	
	public ProductVO get(int bno);
	
	public List<String> getFile(int bno);
	
	public boolean modify(ProductVO product);
	
	public boolean delete(int bno);
}
