package kr.or.ddit.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.vo.UsersVO;

public class SessionAttributeListener implements HttpSessionAttributeListener{
	private static final Logger logger = LoggerFactory.getLogger(SessionAttributeListener.class);
	
//				userid	UsersVO
	private Map<String, UsersVO> userMap = new HashMap<String, UsersVO>();

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		if("S_MEMBER".equals(event.getName())) {
			
//			HttpSession session = event.getSession();
//			MemberVO memberVO = (MemberVO)session.getAttribute("S_MEMBER");
			
			UsersVO usersVO  = (UsersVO)event.getValue();
			logger.debug("사용자 로그인 :{}",usersVO.getUserId());
			
			userMap.put(usersVO.getUserId(), usersVO);
			
			ServletContext sc = event.getSession().getServletContext();
			sc.setAttribute("userMap", userMap);
		}
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		logger.debug("attributeRemoved : {}",event.getName());
		
		if("S_USERS".equals(event.getName())) {
			UsersVO usersVO = (UsersVO)event.getValue();
			userMap.remove(usersVO.getUserId());
		}
		
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		
	}

}
