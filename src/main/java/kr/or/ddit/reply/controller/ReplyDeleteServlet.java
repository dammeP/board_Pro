package kr.or.ddit.reply.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceI;

/**
 * Servlet implementation class ReplyDeleteServlet
 */
@WebServlet("/ReplyDelete")
public class ReplyDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ReplyInsertServlet.class);
	ReplyServiceI replyService;
	
	@Override
		public void init() throws ServletException {
			replyService = new ReplyService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String boardNo = request.getParameter("boardNo");
		request.getRequestDispatcher("/board/boardDetail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("boardNo");
		String replyNo = request.getParameter("replyNo");
		
		int deleteCnt = replyService.updateReply(replyNo);
		logger.debug("딜릿ㅅㅅㅅㅅㅅ:{}",deleteCnt);
		if(deleteCnt == 1) {
			request.getSession().setAttribute("boardNo",boardNo);
			response.sendRedirect(request.getContextPath() +"/BoardDetail?boardNo="+boardNo);
		}
		else {
			doGet(request, response);
		}
	}

}
