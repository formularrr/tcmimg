package com.tcmimg.mapper;
import java.util.*;

import org.mybatis.spring.annotation.Mapper;

import com.tcmimg.po.Image;

@Mapper("imageMapper") 
public interface ImageMapper extends SqlMapper {
	
	public List<Image> getAllImages(); 
	public Image getFirstUnlabeledImage();   
	public Image getImageById(long id); 
	public void labelImage(Image image);  
}
