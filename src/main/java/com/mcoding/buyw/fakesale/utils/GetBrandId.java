package com.mcoding.buyw.fakesale.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;

import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import net.sf.json.JSONArray;

public class GetBrandId {
	
	public static void main(String[] args) throws IOException, RowsExceededException, WriteException {

		List<Map<String, Object>> brandLis = new ArrayList<>();
		
		String content = FileUtils.readFileToString(new File("C:\\Users\\hzy\\Desktop\\买车旺\\ids.txt"));
		JSONArray charList = JSONArray.fromObject(content);
		for (int i = 0; i < charList.size(); i++) {
			JSONArray array = charList.getJSONArray(i);
			JSONArray brandList = array.getJSONArray(1);

			for (int j = 0; j < brandList.size(); j++) {
				JSONArray brand = brandList.getJSONArray(j);
				String brandId = brand.getString(0);
				String nameZ = brand.getString(1);
				String nameE = brand.getString(2);
				JSONArray firmList = brand.getJSONArray(3);
				
				Map<String, Object> brandMap = new HashMap<>();
				brandMap.put("id", brandId);
				brandMap.put("nameCh", nameZ);
				brandMap.put("nameZn", nameE);
				
				List<Map<String, Object>> seriesMapList = new ArrayList<>();
				brandMap.put("seriesList", seriesMapList);

				for (int k = 0; k < firmList.size(); k++) {
					JSONArray firm = firmList.getJSONArray(k);
					String firmName = firm.getString(0);
					JSONArray seriesList = firm.getJSONArray(1);
					
					for (int l = 0; l < seriesList.size(); l++) {
						String seriesId = seriesList.getJSONArray(l).getString(0);
						String seriesName = seriesList.getJSONArray(l).getString(1);
						// System.out.println("name:" +seriesName +", id" +
						// seriesId);
						Map<String, Object> series = new HashMap<>();
						series.put("id", seriesId);
						series.put("name", seriesName);
						series.put("firmName", firmName);
						seriesMapList.add(series);
					}
				}
				
				brandLis.add(brandMap);
			}
		}
		
//		JSONObject jsonObject = JSONObject.fromObject(brandLis)?
		JSONArray brandListJsonArray = JSONArray.fromObject(brandLis);
		String json = brandListJsonArray.toString();
		System.out.println(json);
	}

	public static void exportToExcel() throws IOException, RowsExceededException, WriteException {
		List<Map<String, Object>> seriesMapList = new ArrayList<>();

		String content = FileUtils.readFileToString(new File("C:\\Users\\hzy\\Desktop\\买车旺\\ids.txt"));
		JSONArray charList = JSONArray.fromObject(content);
		for (int i = 0; i < charList.size(); i++) {
			JSONArray array = charList.getJSONArray(i);

			String charStr = array.getString(0);
			JSONArray brandList = array.getJSONArray(1);

			for (int j = 0; j < brandList.size(); j++) {
				JSONArray brand = brandList.getJSONArray(j);
				String brandId = brand.getString(0);
				String nameZ = brand.getString(1);
				String nameE = brand.getString(2);
				JSONArray firmList = brand.getJSONArray(3);

				for (int k = 0; k < firmList.size(); k++) {
					JSONArray firm = firmList.getJSONArray(k);
					String firmName = firm.getString(0);
					System.out.println("厂家:" + firmName);
					JSONArray seriesList = firm.getJSONArray(1);
					for (int l = 0; l < seriesList.size(); l++) {
						String seriesId = seriesList.getJSONArray(l).getString(0);
						String seriesName = seriesList.getJSONArray(l).getString(1);
						// System.out.println("name:" +seriesName +", id" +
						// seriesId);
						Map<String, Object> series = new HashMap<>();
						series.put("seriesId", seriesId);
						series.put("seriesName", seriesName);
						series.put("firmName", firmName);
						series.put("brandName", nameZ);
						series.put("brandId", brandId);
						seriesMapList.add(series);
					}
				}

			}
			System.out.println(charStr);
		}

		FileOutputStream os = new FileOutputStream(new File("C:\\Users\\hzy\\Desktop\\买车旺\\series.xlsx"));
		WritableWorkbook excel = ExportExcel.exportDataToExcel(os, new String[][] { { "品牌名", "brandName" },
				{ "品牌id", "brandId" }, { "厂商名", "firmName" }, { "系列名", "seriesName" }, { "系列id", "seriesId" } },
				seriesMapList, "series", 0);
		excel.write();
		os.flush();
		excel.close();
		os.close();
	}
}
