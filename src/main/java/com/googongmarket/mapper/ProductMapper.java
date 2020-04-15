package com.googongmarket.mapper;

import java.util.List;

import com.googongmarket.domain.ImageVO;
import com.googongmarket.domain.ProductVO;

public interface ProductMapper {

	public List<ProductVO> getList();
	
	public void create(ProductVO product);
	
	public void createFile(ImageVO image);
	
	public ProductVO read(int bno);
	
	public List<String> getFile(int bno);
	
	public int delete(int bno);
	
	public int modify(ProductVO product);
}
