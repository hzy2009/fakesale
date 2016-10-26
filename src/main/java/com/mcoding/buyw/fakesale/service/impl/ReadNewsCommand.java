package com.mcoding.buyw.fakesale.service.impl;

import java.io.IOException;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.ByteArrayRequestEntity;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.logging.impl.Log4JLogger;

import com.mcoding.buyw.fakesale.bean.Member;
import com.mcoding.buyw.fakesale.service.Command;
import com.mcoding.buyw.fakesale.utils.Constant;
import com.mcoding.buyw.fakesale.utils.HttpPostClient;

public class ReadNewsCommand implements Command {
	
	public static Log4JLogger logger = new Log4JLogger(ReadNewsCommand.class.toString());

	@Override
	public Object excute(Member member) throws Exception {
		int readtimes = 4;
//		System.out.println("会员["+member.getUsername()+"]将发送查询请求["+readtimes+"]次");
		logger.info("会员["+member.getUsername()+"]将发送查询请求["+readtimes+"]次");
		int i=0;
		while (i < readtimes) {
			
			long time = (long) (Math.random() * 60000 + 60000);
			readNews(member);
//			System.out.println("会员["+member.getUsername()+"]完成第["+(i+1)+"]次请求，现在停下来，等待["+time+"ms]后再操作");
			logger.info("会员["+member.getUsername()+"]完成第["+(i+1)+"]次请求，现在停下来，等待["+time+"ms]后再操作");
			Thread.currentThread().sleep(time);;
			i++;
		}
		
		return null;
	}
	
	public void read(){
		System.out.println("reading");
	}
	
	public void readNews(Member member) throws InterruptedException, NullPointerException, HttpException, IOException{
		String url = "https://api.leancloud.cn/1.1/classes/News";
		String jsonStr = "{\"where\":{\"invalid\":{\"$ne\":true}},\"keys\":\"pubDate,title,avatar\",\"limit\":100,\"order\":\"-createdAt\",\"_method\":\"GET\",\"_ApplicationId\":\""+Constant.APPLICATION_ID+"\",\"_ApplicationKey\":\""+Constant.APPLICATION_KEY+"\",\"_SessionToken\":\""+member.getSessionToken()+"\",\"_InstallationId\":\""+member.getInstallationId()+"\"}";
		RequestEntity json = new ByteArrayRequestEntity(jsonStr.getBytes());
		String result = HttpPostClient.send(url, null, Constant.getHeaders(member.getIp()), new RequestEntity[] { json }, String.class);
		System.out.println("会员["+member.getUsername()+"] 发送查询新闻的请求成功");
	}
	
	public static void main(String[] args) throws InterruptedException {
//		ReadNews readNews = new ReadNews();
//		readNews.readNews();
	}

}
