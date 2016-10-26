package com.mcoding.buyw.fakesale.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.io.FileUtils;

import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class GetVersionsId {

	public static void main(String[] args) throws IOException{
		String json = FileUtils.readFileToString(new File("C:\\Users\\hzy\\Desktop\\买车旺\\brandlist.json"));
		
		JSONArray brandArray = JSONArray.fromObject(json);
		for (int i = 0; i < brandArray.size(); i++) {
			JSONObject brand = brandArray.getJSONObject(i);
			JSONArray seriesArray = brand.getJSONArray("seriesList");
			
			for (int j = 0; j < seriesArray.size(); j++) {
				JSONObject series = seriesArray.getJSONObject(j);
				JSONArray versionArray = getVersionArrayBySeries(series);
				series.put("versionList", versionArray);
			}
		}
	}

	private static JSONArray getVersionArrayBySeries(JSONObject series) throws NullPointerException, HttpException, IOException {
//		Map<String, Object> params = new HashMap<>();
//		params.put("include", "series");
//		params.put("keys", "y,name,src,price,incolorList,outcolorList,series.incolorList,series.outcolorList");
//		params.put("limit", 500);
//		params.put("order", "-y");
//		params.put("_method", "GET");
//		params.put("_ApplicationId", "6mt2dEyLCgY6KXw4o1f9ADPe");
//		params.put("_ApplicationKey", "dJLFNKcAjgHShBniTg05Ub6I");
//		params.put("_SessionToken", "aa9b8aalocq3ly4ps3ueo3wn9");
//		params.put("_InstallationId", "08078745-bb82-3c26-8d9e-372dfc9af226");
//		params.put("_ApplicationKey", "dJLFNKcAjgHShBniTg05Ub6I");
//		params.put("order", "-y");
		
		String json = "{"+
				"	\"where\": {"+
				"		\"series\": {"+
				"			\"$in\": [{"+
				"				\"__type\": \"Pointer\","+
				"				\"className\": \"Series\","+
				"				\"objectId\": \""+series.getString("id")+"\""+
				"			}]"+
				"		}"+
				"	},"+
				"	\"include\": \"series\","+
				"	\"keys\": \"y,name,src,price,incolorList,outcolorList,series.incolorList,series.outcolorList\","+
				"	\"limit\": 500,"+
				"	\"order\": \"-y\","+
				"	\"_method\": \"GET\","+
				"	\"_ApplicationId\": \"6mt2dEyLCgY6KXw4o1f9ADPe\","+
				"	\"_ApplicationKey\": \"dJLFNKcAjgHShBniTg05Ub6I\","+
				"	\"_SessionToken\": \"aa9b8aalocq3ly4ps3ueo3wn9\","+
				"	\"_InstallationId\": \"08078745-bb82-3c26-8d9e-372dfc9af226\""+
				"}";
		
		
		RequestEntity params = new ByteArrayRequestEntity(json.getBytes());
		String result = HttpPostClient.send(
				"https://api.leancloud.cn/1.1/classes/Version", null, Constant.getHeaders("192.168.1.12"), new RequestEntity[] { params }, String.class);
		
		return null;
	}

		

}
