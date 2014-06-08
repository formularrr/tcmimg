package com.tcmimg.po;


public class Image {
	private static final long serialVersionUID = -7970848646314840509L;  
	
	private long plantLabelID;
	private long plantID;
	private String plantName;
	private String picName;
	private String picPath;
	private String picType;
	private String picPart;
	private String picDescription;
	private int isLabeled;
	private int isCopiedToMed;
	
	public Image(long plantLabelID, long plantID, String plantName, String picName, String picPath, String picType, String picPart, String picDescription, int isLabeled, int isCopiedToMed){
		this.plantLabelID = plantLabelID;
		this.plantID = plantID;
		this.plantName = plantName;
		this.picName = picName;
		this.picPath = picPath;
		this.picType = picType;
		this.picPart = picPart;
		this.picDescription = picDescription;
		this.isLabeled = isLabeled;
		this.isCopiedToMed = isCopiedToMed;
	}
	
	public Image(long plantLabelID, long plantID, String picName, String picPath, String picType, String picPart, String picDescription,int isLabeled){
		this.plantLabelID = plantLabelID;
		this.plantID = plantID;
		this.picName = picName;
		this.picPath = picPath;
		this.picType = picType;
		this.picPart = picPart;
		this.picDescription = picDescription;
		this.isLabeled = isLabeled;
	}
	
	public Image(){}
	
	public long getPlantLabelID(){
		return this.plantLabelID;
	}
	
	public void setPlantLabelID(long plantLabelID){
		this.plantLabelID = plantLabelID;
	}
	
	public long getPlantID(){
		return this.plantID;
	}
	
	public void setPlantID(long plantID){
		this.plantID = plantID;
	}
	
	public String getPlantName(){
		return this.plantName;
	}
	
	public void setPlantName(String plantName){
		this.plantName = plantName;
	}
	
	public String getPicName(){
		return this.picName;
	}
	
	public void setPicName(String picName){
		this.picName = picName;
	}
	
	public String getPicPath(){
		return this.picPath;
	}
	
	public void setPicPath(String picPath){
		this.picPath = picPath;
	}
	
	public String getPicType(){
		return this.picType;
	}
	
	public void setPicType(String picType){
		this.picType = picType;
	}
	
	public String getPicPart(){
		return this.picPart;
	}
	
	public void setPicPart(String picPart){
		this.picPart = picPart;
	}
	
	public String getPicDescription(){
		return this.picDescription;
	}
	
	public void setPicDescription(String picDescription){
		this.picDescription = picDescription;
	}
	
	public int getIsLabeled(){
		return this.isLabeled;
	}
	
	public void setIsLabeled(int isLabeled){
		this.isLabeled = isLabeled;
	}
	
	public int getIsCopiedToMed(){
		return this.isCopiedToMed;
	}
	
	public void setIsCopiedToMed(int isCopiedToMed){
		this.isCopiedToMed = isCopiedToMed;
	}
}

