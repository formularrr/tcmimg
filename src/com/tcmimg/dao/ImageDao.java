package com.tcmimg.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.tcmimg.po.Image;

public interface ImageDao {
	
	public List<Image> getAllImages() throws DataAccessException;
	public Image getFirstUnlabeledImage() throws DataAccessException;
	public Image getImageById(long id) throws DataAccessException;
	public boolean labelImage(Image image) throws DataAccessException;
	public String getImgPlant(String imgPath);
}
