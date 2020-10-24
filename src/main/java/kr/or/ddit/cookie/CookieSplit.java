package kr.or.ddit.cookie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieSplit {
	private static final Logger logger = LoggerFactory.getLogger(CookieSplit.class);
	
	private String cookieString = "USERNM=brown; REMEMBERME=Y; TEST=T; ";
	public static void main(String[] args) {
		CookieSplit cookieSplit = new CookieSplit();
		logger.debug(cookieSplit.getCookeValue("USERNM"));
		logger.debug(cookieSplit.getCookeValue("REMEMBERME"));
		logger.debug(cookieSplit.getCookeValue("TEST"));
	}
	
	
	// 메서드 인자로 넘어온 cookieName에 해당하는 쿠기가 있으면 해당 쿠키의 값을 반환한다
	private String getCookeValue(String cookieName) {
		String result ="";
		String[] cookies = cookieString.split("; ");
			for(int i = 0; i<cookies.length; i++) {
				String[] cookiesArr =cookies[i].split("=");
				if(cookiesArr[0].equals(cookieName)) {
					result = cookiesArr[1];
				}
			}
		
		return null;
	}
	
}
