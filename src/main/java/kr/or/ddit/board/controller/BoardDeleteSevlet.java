package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.board.vo.CBoardVO;

/**
 * Servlet implementation class BoardDeleteSevlet
 */
@WebServlet("/BoardDelete")
public class BoardDeleteSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	BoardServiceI boardService;
	private static final Logger logger = LoggerFactory.getLogger(BoardDeleteSevlet.class);
	
	@Override
		public void init() throws ServletException {
			boardService = new BoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/board/boardDetail.jsp").forward(request, response);
		
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String boardNo = request.getParameter("boardNo");
		String cboardNo = request.getParameter("cboardNo");
		logger.debug("boardNo, :{}",boardNo);
		logger.debug("cboardNo:{}",boardNo);
		
		int deleteCnt = boardService.deleteBoard(boardNo);
		if(deleteCnt == 1) {
			
			request.getSession().setAttribute("cboardNo",cboardNo);
			response.sendRedirect(request.getContextPath() +"/boardList?cboardNo="+cboardNo);
			
		}else {
			doGet(request, response);
		}
	}

}
