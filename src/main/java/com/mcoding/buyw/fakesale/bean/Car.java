package com.mcoding.buyw.fakesale.bean;

import java.util.HashMap;
import java.util.Map;

import com.mcoding.buyw.fakesale.utils.Constant;

import net.sf.json.JSONObject;

public class Car {
	
	private String brand;
	private String series;
	private String version;
	private String outsideColor;
	private String insideColor;
	private Integer realPrice;
	private Integer num;
	private String address;
	private String province;
	private String city;
	private Boolean isOnRoad;
	private Integer delayDay;
	private Integer officialPrice;
	private Integer discountRate;
	private String sessionToken;
	private String installationId;
	
	public String getInstallationId() {
		return installationId;
	}
	public void setInstallationId(String installationId) {
		this.installationId = installationId;
	}
	public String getSessionToken() {
		return sessionToken;
	}
	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
	}
	public Integer getDiscountRate() {
		return discountRate;
	}
	public void setDiscountRate(Integer discountRate) {
		this.discountRate = discountRate;
	}
	public Integer getOfficialPrice() {
		return officialPrice;
	}
	public void setOfficialPrice(Integer officialPrice) {
		this.officialPrice = officialPrice;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSeries() {
		return series;
	}
	public void setSeries(String series) {
		this.series = series;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getOutsideColor() {
		return outsideColor;
	}
	public void setOutsideColor(String outsideColor) {
		this.outsideColor = outsideColor;
	}
	public String getInsideColor() {
		return insideColor;
	}
	public void setInsideColor(String insideColor) {
		this.insideColor = insideColor;
	}
	public Integer getRealPrice() {
		return realPrice;
	}
	public void setRealPrice(Integer realPrice) {
		this.realPrice = realPrice;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Boolean getIsOnRoad() {
		return isOnRoad;
	}
	public void setIsOnRoad(Boolean isOnRoad) {
		this.isOnRoad = isOnRoad;
	}
	public Integer getDelayDay() {
		return delayDay;
	}
	public void setDelayDay(Integer delayDay) {
		this.delayDay = delayDay;
	}
	
	public String toJson(){
//		String jsonStr = "{" + "\"brand\": {" + "\"__type\": \"Pointer\"," + "\"className\": \"Brand\","
//		+ "\"objectId\": \""+car.getBrand()+"\"" + "}," + "\"series\": {" + "\"__type\": \"Pointer\","
//		+ "\"className\": \"Series\"," + "\"objectId\": \""+car.getSeries()+"\"" + "}," + "\"version\": {"
//		+ "\"__type\": \"Pointer\"," + "\"className\": \"Version\","
//		+ "\"objectId\": \""+car.getVersion()+"\"" + "}," + "\"outsideColor\": \""+car.getOutsideColor()+"\","
//		+ "\"insideColor\": \""+car.getInsideColor()+"\"," + "\"officialPrice\": "+car.getOfficialPrice()+"," + "\"realPrice\": "+car.getRealPrice()+","
//		+ "\"num\": "+car.getNum()+"," + "\"address\": \""+member.getAddress()+"\"," + "\"province\": \""+member.getProvince()+"\","
//		+ "\"city\": \""+member.getCity()+"\"," + "\"isOnRoad\": "+car.getIsOnRoad()+"," + "\"delayDay\": "+car.getDelayDay()+"," + "\"discountRate\": 9,"
//		+ "\"invalid\": false," + "\"_ApplicationId\": \""+Constant.APPLICATION_ID+"\","
//		+ "\"_ApplicationKey\": \""+Constant.APPLICATION_KEY+"\","
//		+ "\"_SessionToken\": \""+member.getSessionToken()+"\","
//		+ "\"_InstallationId\": \""+Constant.INSTALLLATION_ID+"\"" + "}";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("brand", getBrand(this.getBrand()));
		jsonObject.put("series", getSeries(this.getSeries()));
		jsonObject.put("version", getVersion(this.getVersion()));
		jsonObject.put("outsideColor", this.getOutsideColor());
		jsonObject.put("insideColor", this.getInsideColor());
		jsonObject.put("officialPrice", this.getOfficialPrice());
		jsonObject.put("realPrice", this.getRealPrice());
		jsonObject.put("num", this.getNum());
		jsonObject.put("address", this.getAddress());
		jsonObject.put("province", this.getProvince());
		jsonObject.put("city", this.getCity());
		jsonObject.put("isOnRoad", this.getIsOnRoad());
		jsonObject.put("delayDay", this.getDelayDay());
		jsonObject.put("discountRate", this.getDiscountRate());
		jsonObject.put("invalid", false);
		jsonObject.put("_ApplicationId", Constant.APPLICATION_ID);
		jsonObject.put("_ApplicationKey", Constant.APPLICATION_KEY);
		jsonObject.put("_InstallationId", this.getInstallationId());
		jsonObject.put("_SessionToken", this.getSessionToken());
		return jsonObject.toString();
	}
	
    private Map<String, String> getVersion(String version){
		
		Map<String, String> map = new HashMap<>();
		map.put("__type", "Pointer");
		map.put("className", "Version");
		map.put("objectId", version);
		return map;
	}
	
	private Map<String, String> getBrand(String objectId){
		
		Map<String, String> map = new HashMap<>();
		map.put("__type", "Pointer");
		map.put("className", "Brand");
		map.put("objectId", objectId);
		return map;
	}
	
    private Map<String, String> getSeries(String series){
		
		Map<String, String> map = new HashMap<>();
		map.put("__type", "Pointer");
		map.put("className", "Series");
		map.put("objectId", series);
		return map;
	}
}
