package com.mcoding.buyw.fakesale;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.impl.Log4JLogger;

import com.mcoding.buyw.fakesale.bean.Member;
import com.mcoding.buyw.fakesale.service.impl.GoIndexCommand;
import com.mcoding.buyw.fakesale.service.impl.LoginCommand;
import com.mcoding.buyw.fakesale.service.impl.ReadNewsCommand;
import com.mcoding.buyw.fakesale.utils.ExportExcel;

import jxl.read.biff.BiffException;

/**
 * Hello world!
 *
 */
public class App {
	
	public static Log4JLogger logger = new Log4JLogger(App.class.toString());
	
	public static void main(String[] args) {
//		File file = new File(pathname)
		
		String pathname = args[1];
		File file = new File(pathname);
		try {
			List<Map<String, Object>> memberdata = ExportExcel.importExcelDataToMap(new FileInputStream(file), 0, 1, 0, new String[][]{{"用户名", "username"}, {"密码", "password"}});
			for(int i=0; i<memberdata.size(); i++){
				final Member member = new Member(memberdata.get(i).get("username").toString(), memberdata.get(i).get("password").toString());
				Thread thread = new Thread(new Runnable() {
					
					@Override
					public void run() {
						try {
							long time = (long) (Math.random() * 10000);
							Thread.currentThread().sleep(time);
							member.dosometh(new LoginCommand());
						} catch (Exception e) {
							logger.info("登录失败。用户名:" + member.getUsername() + "，　密码："+ member.getPassword() + "，详细问题如下:/n" + e.getMessage());
							return;
						}
						
						try {
							member.dosometh(new GoIndexCommand());
							member.dosometh(new ReadNewsCommand());
						} catch (Exception e) {
							logger.info("浏览新闻页面和查询新闻失败。用户名:" + member.getUsername() + "，　密码："+ member.getPassword() + "，详细问题如下:/n" + e.getMessage());
						}
					}
				});
				
				thread.start();
				
				
				if (i>0 && i % 100 == 0) {
					logger.info("已经启动100个用户，暂停 4分钟。");
					Thread.currentThread().sleep(4* 60 * 1000l);
				}
			}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

	

	
}
