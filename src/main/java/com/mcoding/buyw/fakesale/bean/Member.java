package com.mcoding.buyw.fakesale.bean;

import org.apache.commons.logging.impl.Log4JLogger;

import com.mcoding.buyw.fakesale.service.Command;

public class Member {
	
	public static Log4JLogger logger = new Log4JLogger(Member.class.toString());
	
	private String username;
	private String password;
	private String sessionToken;
	private String address="";
	private String province="";
	private String city="";
	private String installationId;
	private String ip;
	
	public Member(String username, String password) {
		this.username = username;
		this.password = password;
		int length = username.length();
		if(length < 11){
			int size = 11 -length;
			for(int i=0; i<size; i++){
				username = username.concat("0");
			}
		}
		this.ip = randomIp();
		this.installationId = username.substring(0, 8) + "-" + username.substring(8, username.length()-1) + "1-5cca-09a6-5d647df68230";
		logger.info("创建会员["+this.username+"],创建唯一设备 号["+this.installationId+"]，创建随机ip["+this.ip+"]");
	}
	
	public Object dosometh(Command command) throws Exception{
		return command.excute(this);
	}
	
	private String randomIp(){
		String[] ips = new String[4];
		for(int i=0; i<4; i++){
			Double random = Math.random() * 255;
			ips[i] = String.valueOf(random.intValue());
		}
		return ips[0] + "." + ips[1] + "." + ips[2]+ "." + ips[3];  
	}
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getInstallationId() {
		return installationId;
	}

	public void setInstallationId(String installationId) {
		this.installationId = installationId;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSessionToken() {
		return sessionToken;
	}
	public void setSessionToken(String sessionToken) {
		this.sessionToken = sessionToken;
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
	
	public static void main(String[] args) {
//		Math.floor((1+Math.random())*0x10000).toString(16).substring(1);
		
//		Double num = Math.floor((Math.random() +1) * 65536);
//		
//		System.out.println("num:" + num + ",hax:" + Double.toHexString(num));
		Member member = new Member("134", "sd");
//		System.out.println(member.randomIp());
	}

}
