package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;


/**
 * Servlet implementation class CBoardList
 */
@WebServlet("/CBoardList")
public class CBoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	BoardServiceI boardService;
	
	@Override
		public void init() throws ServletException {
		boardService = new BoardService();
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		List<CBoradVO> cBoardList = cBoardService.selectAllCBoard();
		request.setAttribute("cBoardList", boardService.selectUseCBoard());
		
		request.getRequestDispatcher("/cBoard/CBoardList.jsp").forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
