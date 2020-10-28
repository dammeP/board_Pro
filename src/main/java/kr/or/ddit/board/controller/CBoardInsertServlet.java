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
import kr.or.ddit.board.vo.UsersVO;

/**
 * Servlet implementation class CBoardCreateServlet
 */
@WebServlet("/CBoardInsert")
public class CBoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(CBoardInsertServlet.class);
	
	BoardServiceI boardService;
	
	@Override
		public void init() throws ServletException {
		boardService = new BoardService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("cBoardList", boardService.selectAllCBoard());
		
		
		request.getRequestDispatcher("/cBoard/cboardInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String userId = request.getParameter("userId");
		String cboardCategory = request.getParameter("cboardCategory");
		String cboardUseCheck = request.getParameter("cboardUseCheck");
		List<CBoardVO> cBoardVO = boardService.selectAllCBoard();
		
		CBoardVO cboardVO = new CBoardVO();
		cboardVO.setUserId(userId);
		cboardVO.setCboardCategory(cboardCategory);
		cboardVO.setCboardUseCheck(cboardUseCheck);
		
		logger.debug("parameter : {},{},{}",userId,cboardCategory,cboardUseCheck);
		
		
		int insertCnt= boardService.insertCBoard(cboardVO);
		logger.debug("insertCnt : {}",insertCnt);
		
		if(insertCnt == 1) {
			request.getSession().setAttribute("userId", cboardVO.getUserId());
			request.getSession().setAttribute("cBoardList", cBoardVO);
			response.sendRedirect(request.getContextPath() +"/BoardMain");
		}
		else {
			doGet(request, response);
		}
		
		
	}

}
