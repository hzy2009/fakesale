package com.mcoding.buyw.fakesale.service.impl;

import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.logging.impl.Log4JLogger;

import com.mcoding.buyw.fakesale.bean.Member;
import com.mcoding.buyw.fakesale.service.Command;
import com.mcoding.buyw.fakesale.utils.Constant;
import com.mcoding.buyw.fakesale.utils.HttpPostClient;

import net.sf.json.JSONObject;

public class LoginCommand implements Command{
	
	public static Log4JLogger logger = new Log4JLogger(LoginCommand.class.toString());

	@Override
	public Object excute(Member member) throws Exception{

		String url = "https://api.leancloud.cn/1.1/login";

		String jsonStr = "{\"username\":\""+member.getUsername()+"\",\"password\":\""+member.getPassword()+"\",\"_method\":\"GET\",\"_ApplicationId\":\""+Constant.APPLICATION_ID+"\",\"_ApplicationKey\":\""+Constant.APPLICATION_KEY+"\",\"_InstallationId\":\""+member.getInstallationId()+"\"}";
		RequestEntity json = new ByteArrayRequestEntity(jsonStr.getBytes());

		String result = HttpPostClient.send(url, null, Constant.getHeaders(member.getIp()), new RequestEntity[] { json }, String.class);
		JSONObject jsonObject = JSONObject.fromObject(result);

		member.setSessionToken(jsonObject.getString("sessionToken"));
		if (jsonObject.has("address")) {
			member.setAddress(jsonObject.getString("address"));
		}
		if (jsonObject.has("province")) {
			member.setProvince(jsonObject.getString("province"));
		}
        if (jsonObject.has("city")) {
        	member.setCity(jsonObject.getString("city"));
		}
//		System.out.println("会员["+member.getUsername()+"]登陆成功，返回sessionToken:" + member.getSessionToken());
        logger.info("会员["+member.getUsername()+"]登陆成功，返回sessionToken:" + member.getSessionToken());
		return jsonObject;
	}

}
