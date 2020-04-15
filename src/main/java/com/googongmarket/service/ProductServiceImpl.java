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
		
		//log.info("getList function called");
		return mapper.getList();
	}
	
	@Override
	public void create(ProductVO product) {		
		
		//log.info("register"+board);
		mapper.create(product);
	}
	
	@Override
	public void createFile(ImageVO image) {
		
		mapper.createFile(image);
	}

	@Override
	public ProductVO get(int bno) {
		
		//log.info("get ...."+bno);
		return mapper.read(bno);
	}
	
	@Override
	public List<String> getFile(int bno) {
		
		return mapper.getFile(bno);
	}

	@Override
	public boolean modify(ProductVO product) {
		
		//log.info("modify.... : "+board);
		return mapper.modify(product) == 1;
	}

	@Override
	public boolean delete(int bno) {
		
		//log.info("remove .... : "+bno);
		return mapper.delete(bno) == 1;
	}
}
