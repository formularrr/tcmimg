package Util;

import java.util.HashMap;
import java.util.Map;

public class ImageConst {
	
	public static String pathRoot = "/tcm/search/plant/";
	public static Map<String, String> picTypeMap;
	public static Map<String, String> picPartMap;
	
	static{
		picTypeMap = new HashMap<String, String>();
		picTypeMap.put("plant", "1");
		picTypeMap.put("sample", "2");
		
		picPartMap = new HashMap<String, String>();
		picPartMap.put("all", "1");
		picPartMap.put("flower", "2");
		picPartMap.put("fruit", "3");
		picPartMap.put("leaf", "4");
		picPartMap.put("root", "5");
		picPartMap.put("stem", "6");
	}
}
