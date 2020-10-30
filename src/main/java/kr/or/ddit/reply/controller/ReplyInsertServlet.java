package kr.or.ddit.reply.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.controller.BoardUpdateServlet;
import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceI;
import kr.or.ddit.reply.vo.ReplyVO;

/**
 * Servlet implementation class ReplyInsert
 */
@WebServlet("/ReplyInsert")
public class ReplyInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ReplyInsertServlet.class);
	ReplyServiceI replyService;
	
	@Override
		public void init() throws ServletException {
			replyService = new ReplyService();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("boardNo");
		
		request.getRequestDispatcher("/BoardDetail?boardNo="+boardNo).forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String replyC = request.getParameter("replyC");
		String boardNo = request.getParameter("boardNo");
		String userId = request.getParameter("userId");
//		List<ReplyVO> replyList = replyService.selectAllReply(boardNo);
		
		
		logger.debug("replyC, boardNo, userId:{},{},{}",replyC,boardNo,userId);
		
		ReplyVO replyVO = new ReplyVO();
		replyVO.setReplyContent(replyC);
		replyVO.setBoardNo(boardNo);
		replyVO.setUserId(userId);
		
		request.setAttribute("replyVO", replyVO);
		
		int insertCnt = replyService.insertReply(replyVO);
		
		if(insertCnt == 1) {
			request.getSession().setAttribute("replyVO", replyVO);
//			request.getSession().setAttribute("replyList", replyList);
			response.sendRedirect(request.getContextPath() +"/BoardDetail?boardNo="+boardNo);
		}
		else {
			doGet(request, response);
		}
		
	}

}
