package com.mcoding.buyw.fakesale.service.impl;

import org.apache.commons.logging.impl.Log4JLogger;

import com.mcoding.buyw.fakesale.bean.Member;
import com.mcoding.buyw.fakesale.service.Command;
import com.mcoding.buyw.fakesale.utils.Constant;
import com.mcoding.buyw.fakesale.utils.HttpGetClient;

public class GoIndexCommand implements Command{
	
	public static Log4JLogger logger = new Log4JLogger(GoIndexCommand.class.toString());

	@Override
	public Object excute(Member member) throws Exception {
		String url = "http://buyw.com.cn/v2/#newsDetails?id=579811251532bc0060ea1931";
		HttpGetClient.send(url, null, Constant.getHeaders(member.getIp()), String.class);
//		System.out.println("会员["+member.getUsername()+"]打开新闻页面成功");
		logger.info("会员["+member.getUsername()+"]打开新闻页面成功");
		return null;
	}

}
