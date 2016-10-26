package com.mcoding.buyw.fakesale.utils;

import org.apache.commons.httpclient.Header;

public class Constant {
	
	public static final String APPLICATION_ID = "6mt2dEyLCgY6KXw4o1f9ADPe";
	public static final String APPLICATION_KEY = "dJLFNKcAjgHShBniTg05Ub6I";
//	public static final String INSTALLLATION_ID = "76cbb32c-5221-5cca-09a6-5d647df68230";
	
	public static Header[] getHeaders(String ip) {
		Header header = new Header("Host", "api.leancloud.cn");
		Header header1 = new Header("Connection", "keep-alive");
		// Header header2 = new Header("Content-Length", "210");
		Header header2 = new Header("HTTP_X_FORWARDED_FOR", ip);
		Header header3 = new Header("Pragma", "no-cache");
		Header header4 = new Header("Cache-Control", "no-cache");
		Header header5 = new Header("Origin", "http://buyw.com.cn");
		Header header6 = new Header("User-Agent",
				"Mozilla/5.0 (iPhone; CPU iPhone OS 9_1 like Mac OS X); AppleWebKit/601.1.46 (KHTML, like Gecko); Version/9.0 Mobile/13B143 Safari/601.1");
		Header header7 = new Header("Content-Type", "text/plain");
		Header header8 = new Header("Accept", "*/*");
		Header header9 = new Header("Referer", "http://buyw.com.cn/v2/");
		Header header10 = new Header("Accept-Encoding", "gzip, deflate, br");
		Header header11 = new Header("Accept-Language", "zh-CN,zh;q=0.8,en;q=0.6,ja;q=0.4,zh-TW;q=0.2,en-US;q=0.2");
		Header header12 = new Header("Cookie", "gr_user_id=6990bc22-892e-4e1c-a084-79305f936eae; _ga=GA1.2.486526747.1473229212; gr_session_id_a268202b003f2516=cbcdf534-c502-4ef2-876c-c9481ba35c42");

//		Hea
		
		Header[] array = new Header[] { header, header1, header2, header3, header4, header5, header6, header7, header8, header9,
				header10, header11, header12 };

		return array;
	}

}
