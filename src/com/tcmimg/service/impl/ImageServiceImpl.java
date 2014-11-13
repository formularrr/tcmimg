package com.tcmimg.service.impl;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import libsvm.svm_predict;
import libsvm.svm_train;
import net.semanticmetadata.lire.DocumentBuilder;
import net.semanticmetadata.lire.ImageSearchHits;
import net.semanticmetadata.lire.ImageSearcher;
import net.semanticmetadata.lire.ImageSearcherFactory;
import net.semanticmetadata.lire.imageanalysis.JCD;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.RAMDirectory;
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
	
	@Override
	public String uploadImage(List fileList){
		/*删除所有上传图片*/
		deleteAllUploadImages();
		
	   File directory = new File("");
	   String savePath = ImageConst.directory;
       File f1 = new File(savePath);
       if (!f1.exists()) {
           f1.mkdirs();
       }

       Iterator<FileItem> it = fileList.iterator();
       String name = "";
       String extName = "";
       while (it.hasNext()) {
           FileItem item = it.next();
           if (!item.isFormField()) {
               name = item.getName();
               long size = item.getSize();
               String type = item.getContentType();
               if (name == null || name.trim().equals("")) {
                   continue;
               }
                  
               if (name.lastIndexOf(".") >= 0) {
                   extName = name.substring(name.lastIndexOf("."));
               }
               File file = null;
               do {
                   name = UUID.randomUUID().toString();
                   file = new File(savePath + name + extName);
               } while (file.exists());
               File saveFile = new File(savePath + name + extName);
               try {
                   item.write(saveFile);
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       }
       
      return name + extName;
	}
	
	public String getType(String name){
		double[] features = null;
		System.out.println(name);
		try {
			features = createFeature(new File(name));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			writeFeatures(features);
		} catch (IOException e) {
			e.printStackTrace();
		}
		File directory = new File("");
		String[] parg = {ImageConst.directory + "2.txt","D:/Workspaces/lire/svm/model_r.txt",
				ImageConst.directory + "out_r.txt"};

		try {
			svm_predict.main(parg);
			return readTypeFromTXT(ImageConst.directory + "out_r.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//预测或分类
		
		return "1.0";
	}
	
	public String readTypeFromTXT(String path) throws IOException{
		 File filename = new File(path); // 要读取以上路径的input。txt文件  
         InputStreamReader reader = new InputStreamReader(  
                 new FileInputStream(filename)); // 建立一个输入流对象reader  
         BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言  
         String line = "";  
         line = br.readLine();  
         System.out.println(line);

         return line;
	}
	
	public  double[] createFeature(File f) throws IOException{
        BufferedImage img = ImageIO.read(f);
        
        JCD jcd = new JCD();
        jcd.extract(img);
        
        return jcd.getDoubleHistogram();
	}
	
	public void writeFeatures(double[] features) throws IOException{
		int index = 1;
		File directory = new File("");
		String fileName = directory.getAbsolutePath() + "/WebRoot/resources/uploads/2.txt";
		FileWriter writer = new FileWriter(fileName, true);   
        writer.write(String.valueOf(index));   
        
        for(int i = 0; i < features.length; i++){
        	if(Math.abs(features[i] - 0) < 0.0000000001)
        		continue;
        	writer.write(" " + i + ":" + features[i]);
        }
        
        writer.write("\n");
        
        writer.close();   
	}
	
	public void deleteAllUploadImages(){
	   File directory = new File("");
	   String path = ImageConst.directory;
       
       File file = new File(path);
       
       if (!file.exists()) {
         return ;
       }
       if (!file.isDirectory()) {
         return ;
       }
       String[] tempList = file.list();
       File temp = null;
       for (int i = 0; i < tempList.length; i++) {

          temp = new File(path + tempList[i]);
          if (temp.isFile()) {
             temp.delete();
          }
       }
     
	}

	@Override
	public List searchImage(String name) {
		List<List<String>> rs = new ArrayList<List<String>>();
		File directory = new File("");;
		String path = ImageConst.directory;
		File f = new File(path + name);
        BufferedImage img = null;
		try {
			img = ImageIO.read(f);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//            System.exit(1);
//        }
 
        IndexReader ir = null;
		try {
			ir = IndexReader.open(new RAMDirectory(FSDirectory.open(new File("index")), null));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        ImageSearcher searcher = ImageSearcherFactory.createJCDImageSearcher(10);
 
        ImageSearchHits hits = null;
		try {
			hits = searcher.search(img, ir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        for (int i = 0 ; i < hits.length() ; i++) {
            String fileName = hits.doc(i).getValues(DocumentBuilder.FIELD_NAME_IDENTIFIER)[0];
            int beginIndex = fileName.indexOf("ImageRetrivalImages");
            String tmpName = "\\" + fileName.substring(beginIndex);
            
//            if(tmpName.contains("plantPhotoCn")){
//            	int index = tmpName.indexOf("plantPhotoCn") + 13;
//            	String plantName = tmpName.substring(index, tmpName.indexOf("\\", index));
///*            	try {
//            		String gb = URLEncoder.encode(plantName, "gb2312");
//            		System.out.println(gb);
//					tmpName.replace(plantName, gb);
//				} catch (UnsupportedEncodingException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}*/
//            	System.out.println(hits.score(i)  + ": " + tmpName + " , "+ plantName);
//            	
//            	rs.add(tmpName + " + " + plantName);
//            }
            
//            else{
	            System.out.println(hits.score(i)  + ": " + tmpName + " , "+ dao.getImgPlant(tmpName));
	            List<String> tmp = new ArrayList<String>();
	            tmp.add(tmpName);
	            tmp.add(dao.getImgPlant(tmpName));
	            rs.add(tmp);
//            }
        }
    
		return rs;
	}

}


