package com.googongmarket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.googongmarket.domain.ImageVO;
import com.googongmarket.domain.ProductVO;
import com.googongmarket.mapper.ProductMapper;

import lombok.Setter;

@Service
public class ProductServiceImpl implements ProductService {

	@Setter(onMethod_ = {@Autowired})
	private ProductMapper mapper;
	
	@Override
	public List<ProductVO> getList() {
		
		return mapper.getList();
	}
	
	@Override
	public void create(ProductVO product) {		
		
		mapper.create(product);
	}
	
	@Override
	public void createFile(ImageVO image) {
		
		mapper.createFile(image);
	}

	@Override
	public ProductVO read(int bno) {
		
		return mapper.read(bno);
	}
	
	@Override
	public ImageVO readFile(int bno) {
		
		return mapper.readFile(bno);
	}
	
	@Override
	public List<String> getFile(int bno) {
		
		return mapper.getFile(bno);
	}

	@Override
	public boolean modify(ProductVO product) {

		return mapper.modify(product) == 1;
	}

	@Override
	public boolean delete(int bno) {
		
		return mapper.delete(bno) == 1;
	}
	
	@Override
	public List<ProductVO> mainPage(ProductVO product) {
		
		return mapper.mainPage(product);
	}
	
	@Override
	public List<ProductVO> search(String title) {
		
		return mapper.search(title);
	}
}
