package com.tcmimg.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import Util.FTPUtil;
import Util.ImageConst;

import com.tcmimg.dao.ImageDao;
import com.tcmimg.po.Image;
import com.tcmimg.service.ImageService;

@Service("imageServiceImpl")
public class ImageServiceImpl implements ImageService{

	@Autowired
	@Qualifier("imageDaoImpl")
	private ImageDao dao;

	
	@Override
	public List<Image> getAllImages() {
		return dao.getAllImages();
	}

	@Override
	public Image getFirstUnlabeledImage() {
		return dao.getFirstUnlabeledImage();
	}

	@Override
	public Image getImageById(long id) {
		return dao.getImageById(id);
	}

	@Override
	public boolean labelImage(Long labelID, Long plantID, String picPath, String picName, String picType, String picPart, String picDescription) throws IOException{
		String picTypeNo = ImageConst.picTypeMap.get(picType);
		String picPartNo = ImageConst.picPartMap.get(picPart);
		
		//根据种类及部位修改图片位置及名字
		String newPath = plantID + "/" + picType + "/" + picPart;		
		int picCounts = FTPUtil.getPicsCount(ImageConst.pathRoot + newPath);		
		String newPicName = plantID + "_" + picTypeNo + "_" + picPartNo + "_" + picCounts + ".jpg";
		
		String oldPicPath = ImageConst.pathRoot + picPath + "/" + picName;
		String newPicPath = ImageConst.pathRoot + newPath + "/" + newPicName;
		
		if(FTPUtil.movePic(oldPicPath, newPicPath)){
			Image image = new Image(labelID, plantID, newPicName, newPath, picType, picPart,picDescription, 1);
			return dao.labelImage(image);
		}
		
		return false;

	}

}
