package com.mcoding.buyw.fakesale.service.impl;

import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.logging.impl.Log4JLogger;

import com.mcoding.buyw.fakesale.bean.Car;
import com.mcoding.buyw.fakesale.bean.Member;
import com.mcoding.buyw.fakesale.service.Command;
import com.mcoding.buyw.fakesale.utils.Constant;
import com.mcoding.buyw.fakesale.utils.HttpPostClient;

public class PublishCommand implements Command{
	
	public static Log4JLogger logger = new Log4JLogger(PublishCommand.class.toString());
	
	private Car car;

	public PublishCommand(Car car) {
		super();
		this.car = car;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	@Override
	public Object excute(Member member) throws Exception {
		member.dosometh(new LoginCommand());
		
		car.setSessionToken(member.getSessionToken());
		car.setAddress(member.getAddress());
		car.setCity(member.getCity());
		car.setProvince(member.getProvince());
		car.setInstallationId(member.getInstallationId());
		
		String url = "https://api.leancloud.cn/1.1/classes/Car";
		RequestEntity json = new ByteArrayRequestEntity(car.toJson().getBytes());
		String result = HttpPostClient.send(url, null, Constant.getHeaders(member.getIp()), new RequestEntity[] { json }, String.class);
//		System.err.println("会员["+member.getUsername()+"]发布新车源成功");
		logger.info("会员["+member.getUsername()+"]发布新车源成功");
		return result;
	}

}
