package com.tcmimg.controller;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
      
   @RequestMapping("/getfirstimage")
   public String getFirstUmlabeledImage(Model model)
   {
	  // System.out.println("###ID:"+id)
	   
	   model.addAttribute(service.getFirstUnlabeledImage());
	   
	   Image i = service.getFirstUnlabeledImage();
	   
	   System.out.println(i.getPicPath());
	   
	   System.out.println("################ model after" + model);
	   
	   return "/show.jsp";
   }
   
   
   @RequestMapping("/image")
   public String image(Model model,@RequestParam String id)
   {
	   long plantLabelID = Long.parseLong(id) + 1;
	   model.addAttribute(service.getImageById(plantLabelID));
	   model.addAttribute("pathRoot", pathRoot);
	   return "/image.jsp";
   }
   
   @RequestMapping("/default")
   public String defaultPage(Model model)
   {
	   model.addAttribute(service.getFirstUnlabeledImage());
	   model.addAttribute("pathRoot", pathRoot);
	   return "/image.jsp";
   }
   
   @RequestMapping("/submitlabel")
   public String submitLabel(Model model, @RequestParam String labelID, @RequestParam String plantID, @RequestParam String picPath, @RequestParam String picName, 
		   @RequestParam String picType, @RequestParam String picPart, @RequestParam String picDescription) throws NumberFormatException, IOException
   {  
	   System.out.println("!!!!!!!!!!  " + picPath);
	   service.labelImage(Long.parseLong(labelID), Long.parseLong(plantID), picPath, picName, picType, picPart, picDescription);
	   
	   model.addAttribute(service.getFirstUnlabeledImage());
	   model.addAttribute("pathRoot", pathRoot);
	   return "/image.jsp";
   }

   
/*   @ExceptionHandler(Exception.class)
   public String exception(Exception e,HttpServletRequest request)
   {
	   request.setAttribute("exception", e);
	   return "/error.jsp";
   }*/
}
