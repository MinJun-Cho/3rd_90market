package com.googongmarket.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.googongmarket.domain.ImageVO;
import com.googongmarket.domain.ProductVO;
import com.googongmarket.service.ProductService;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@GetMapping("create")
	public String create() {
		
		return "product/create";
	}

	@PostMapping("/postCreate")
	public String postCreate(MultipartFile[] file, ProductVO product, ImageVO image, Model model, Model model1, HttpServletRequest request) throws UnsupportedEncodingException {
		
		product.setSeller("hello");
		//System.out.println(product.getCategory());
		product.setCategory("fashion");
		
		String title = product.getTitle();
		title = new String(title.getBytes("8859_1"), "UTF-8");
		product.setTitle(title);
		
		String content = product.getContent();
		content = new String(content.getBytes("8859_1"), "UTF-8");
		product.setContent(content);
		
//		String category = product.getCategory();
//		category = new String(category.getBytes("8859_1"), "UTF-8");
//		product.setCategory(category);
		
		service.create(product);
		model.addAttribute(product);
		
		int tmpBno = product.getBno();

		for(MultipartFile multipartFile : file) {
			
			UUID uuid = UUID.randomUUID();
			String rootPath = request.getSession().getServletContext().getRealPath("/");
			String attachPath = "resources/originimages/";
			String fileName = multipartFile.getOriginalFilename();
			
			int index = fileName.lastIndexOf(".");
			String fileExt = fileName.substring(index + 1);
			System.out.println(fileExt);
			fileName = uuid.toString().replaceAll("-", "") + fileExt;
			
			File originF = new File(rootPath + attachPath + fileName);
			
			try {
				
				multipartFile.transferTo(originF);
				
				boolean falg = makeThumbnail(originF.getAbsolutePath(), fileName, fileExt, request);
				
				if(falg) {
					
					falg = false;
				}
				
				image.setBno(tmpBno);
				image.setFilepath("/resources/originimages/"+ fileName);
				image.setThumbnail("/resources/thumbimages/" + fileName);
				
				System.out.println("image!!!!!!!!\n " + image);
				service.createFile(image);
				
				//model.addAttribute("image", multipartFile.getOriginalFilename());					
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			} finally {

				//service.readFile(tmpBno);
				//System.out.println(service.readFile(tmpBno));
			}
		}
				
		return "redirect:/product/read?bno=" + product.getBno();
	}
	
	private boolean makeThumbnail(String filePath, String fileName, String fileExt, HttpServletRequest request) throws Exception {
		
		BufferedImage image = ImageIO.read(new File(filePath));
	      
	    int width = 424;
	    int height = 424;
	      
	    int originWidth = image.getWidth();
	    int originHeight = image.getHeight();
	      
	    int ow = originWidth;
	    int oh = (originWidth * height) / width;
	      
	    if(oh > originHeight) {
	    	
	       ow = (originHeight * width) / height;
	       oh = originHeight;
	    }
	    
	    BufferedImage cropImg = Scalr.crop(image, (originWidth - ow) / 2, (originHeight - oh) / 2, ow, oh);
	    BufferedImage destImg = Scalr.resize(cropImg, width, height);
	    
	    String rootPath = request.getSession().getServletContext().getRealPath("/") + "resources/thumbimages/";
	    String thumbName = rootPath + fileName;
	    File thumbFile = new File(thumbName);
	    boolean falg = ImageIO.write(destImg, fileExt.toUpperCase(), thumbFile);
	    
	    return falg;
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
		
		return "redirect:/product/read";
	}

	@GetMapping("/read")
	public void read(@RequestParam("bno") int bno, Model model, Model model1, HttpServletRequest request) {      
	      
		model.addAttribute("product", service.get(bno));	
		System.out.println("product : " + service.get(bno));
	
		List<String> images = service.getFile(bno);
		model1.addAttribute("images", images);
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("bno") int bno, RedirectAttributes rttr) {
		
		if (service.delete(bno)) {
			
			rttr.addFlashAttribute("result", "success");
			
		}
		
		return "redirect:/category/";
	}
}
