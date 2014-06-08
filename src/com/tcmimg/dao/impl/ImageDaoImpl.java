package com.tcmimg.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.tcmimg.dao.ImageDao;
import com.tcmimg.mapper.ImageMapper;
import com.tcmimg.po.Image;


@SuppressWarnings("unchecked")
@Repository("imageDaoImpl")
public class ImageDaoImpl implements ImageDao{

	@Autowired(required=false)
	@Qualifier("imageMapper")
	private ImageMapper mapper;
	
	@Override
	public List<Image> getAllImages() throws DataAccessException {
		return 	(List<Image> )mapper.getAllImages();
	}

	@Override
	public Image getFirstUnlabeledImage() throws DataAccessException {
		return mapper.getFirstUnlabeledImage();
	}

	@Override
	public Image getImageById(long id) throws DataAccessException {
		return mapper.getImageById(id);
	}

	@Override
	public boolean labelImage(Image image) throws DataAccessException {
		 boolean flag = false;
		 
		 try{
			 mapper.labelImage(image);
			 flag = true;
		 }
		 catch(DataAccessException e)
		 {
			 flag = false;
			 throw e;
		 }
		 return flag;
	}

}
