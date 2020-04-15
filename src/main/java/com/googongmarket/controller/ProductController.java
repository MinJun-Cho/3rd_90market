package com.googongmarket.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.googongmarket.domain.ProductVO;
import com.googongmarket.service.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	private ProductService service;
	
	@GetMapping("create")
	public String create() {
		
		return "product/create";
	}

	@PostMapping("/create")
	public String register(MultipartFile[] file, ProductVO product, RedirectAttributes rttr, Model model, HttpServletRequest request) {
		
		rttr.addFlashAttribute("result", product.getBno());		
		service.create(product);
		int tmp = product.getBno();

		for(MultipartFile multipartFile : file) {
			
			System.out.println("file.separator : "+File.separator);
			
			String root_path = request.getSession().getServletContext().getRealPath("/");
			System.out.println("root_path : "+root_path);
			String attach_path = "resources"+"/"+"img";
			System.out.println("attach_path : "+attach_path);
			String fileName = multipartFile.getOriginalFilename() ;			
			File f = new File(root_path+attach_path+"/"+fileName);
			
			String fil = product.getFilepath();
			System.out.println("요기요 : "+fil);
			
			try {
				
				multipartFile.transferTo(f);
				System.out.println("f : "+f);
				product.setBno(tmp);
				product.setFilepath("/resources/img/"+fileName);				
				
				//service.insertFile(product);								
				
				model.addAttribute("image", multipartFile.getOriginalFilename());							
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} finally {

			}
		}
				
		return "redirect:/product/read?";
	}
	
	@PostMapping("/modify")
	public String modify(HttpServletRequest req, HttpSession session, HttpServletResponse res, @RequestParam HashMap<String, String> map,
			ProductVO product, RedirectAttributes rttr) throws Exception {
		
		
		if (service.modify(product)) {
			
			rttr.addFlashAttribute("result", "success");
		}		
		
		String realFile = "c:/tmp/";		// 파일 경로
		String fileNm = "11";				// 파일 이름
		String ext = "png";					// 파일 확장자
		BufferedOutputStream out = null;
		InputStream in = null;

		try {
			
			res.setContentType("image/" + ext);
			res.setHeader("Content-Disposition", "inline;filename=" + fileNm);
			File file = new File(realFile);
			
			if(file.exists()){
				
				in = new FileInputStream(file);
				out = new BufferedOutputStream(res.getOutputStream());
				int len;
				byte[] buf = new byte[1024];
				
				while ((len = in.read(buf)) > 0) {
					
					out.write(buf, 0, len);
					
				}
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			if(out != null){ out.flush(); }
			if(out != null){ out.close(); }
			if(in != null){ in.close(); }
			
		}
		
		return "redirect:/product/read?";
	}

	@GetMapping({ "/get", "/modify" })
	public void get(@RequestParam("bno") int bno, Model model) {
		
		//log.info("get");
		model.addAttribute("product", service.get(bno));
		
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("bno") int bno, RedirectAttributes rttr) {
		
		//log.info("remove : " + bno);
		
		if (service.delete(bno)) {
			
			rttr.addFlashAttribute("result", "success");
			
		}
		
		return "redirect:/category/";
	}
}
