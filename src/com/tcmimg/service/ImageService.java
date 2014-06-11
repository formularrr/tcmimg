package com.tcmimg.service;

import java.io.IOException;
import java.util.List;

import com.tcmimg.po.Image;

public interface ImageService {
	public List<Image> getAllImages(); 
	
	public Image getFirstUnlabeledImage();
	
	public Image getImageById(long id); 

	public boolean labelImage(Long labelID, Long plantID, String picPath,
			String picName, String picType, String picPart,
			String picDescription) throws IOException;
	
	public String uploadImage(List fileList);
	
	public List searchImage(String name);
}
