package com.tcmimg.controller;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tcmimg.po.Image;
import com.tcmimg.service.ImageService;

@Controller("imageController")
public class ImageController {
	
   @Autowired
   @Qualifier("imageServiceImpl")
   private ImageService service;
   
   private final String pathRoot = "http://www.ckcest.zju.edu.cn/imgtcm/search/plant/";
   @RequestMapping("/index")
   public String homePage(Model model)
   {
	   return "/index.jsp";
   }
     
   
   @RequestMapping("/uploadimage")
   public void uploadImage(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException
   {
       DiskFileItemFactory fac = new DiskFileItemFactory();
       ServletFileUpload upload = new ServletFileUpload(fac);
       upload.setHeaderEncoding("utf-8");
       List fileList = null;
       try {
           fileList = upload.parseRequest(request);
       } catch (FileUploadException ex) {
           return;
       }
	   String name = service.uploadImage(fileList);

       response.getWriter().print(name);
   }
	   

  @SuppressWarnings("unchecked")
@RequestMapping(value="/searchimage",method=RequestMethod.POST)

   public void searchImage(HttpServletRequest request, HttpServletResponse response, Model model, @RequestBody String name) throws IOException
   {
	   System.out.println("searchimage :" + name);
	   response.setContentType("text/plain; charset=GB2312");
	  // Map<String, List<String>> rs = new HashMap<String, List<String>>();
	   //rs.put("rs", service.searchImage(name));
	   response.getWriter().print(service.searchImage(name));
	   //model.addAttribute("rs", rs);
	   //return rs;
   }
   
   @RequestMapping("/image")
   public String image(Model model)
   {
	   return "/image.jsp";
   }
   
/*   
   @RequestMapping("/submitlabel")
   public String submitLabel(Model model, @RequestParam String labelID, @RequestParam String plantID, @RequestParam String picPath, @RequestParam String picName, 
		   @RequestParam String picType, @RequestParam String picPart, @RequestParam String picDescription) throws NumberFormatException, IOException
   {  
	   System.out.println("!!!!!!!!!!  " + picPath);
	   service.labelImage(Long.parseLong(labelID), Long.parseLong(plantID), picPath, picName, picType, picPart, picDescription);
	   
	   model.addAttribute(service.getFirstUnlabeledImage());
	   model.addAttribute("pathRoot", pathRoot);
	   return "/image.jsp";
   }*/

   
/*   @ExceptionHandler(Exception.class)
   public String exception(Exception e,HttpServletRequest request)
   {
	   request.setAttribute("exception", e);
	   return "/error.jsp";
   }*/
}
