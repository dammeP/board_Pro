package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.board.vo.PageVO;

/**
 * Servlet implementation class CBoardList
 */
@WebServlet("/boardList")
public class BoardListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(BoardListServlet.class);
	
	BoardServiceI boardService;
	
	@Override
		public void init() throws ServletException {
		boardService = new BoardService();
	}
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cboardNo = request.getParameter("cboardNo");
		request.setAttribute("cboardNo", cboardNo);
		
		logger.debug("cboardNo : {}",cboardNo);
		
		// page
		String page_str = request.getParameter("page");
		int page = page_str == null ? 1 : Integer.parseInt(page_str);
		request.setAttribute("page", page);
		
		// pageSize
		String pageSize_str = request.getParameter("pageSize");
		int pageSize = pageSize_str == null ? 10 : Integer.parseInt(page_str);
		request.setAttribute("pageSize", pageSize);
		
		PageVO pageVO = new PageVO(page, pageSize,cboardNo);
		
		logger.debug("page,pageSize,cboardNo:{},{},{}",page, pageSize,cboardNo);
		
		Map<String , Object> map = boardService.selectPageBoard(pageVO);
		request.setAttribute("boardList", map.get("boardList"));
		request.setAttribute("pages", map.get("pages"));
		
		logger.debug("boardList:{}",map.get("boardList"));
		logger.debug("pages:{}",map.get("pages"));
		
		request.getRequestDispatcher("/board/boardList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
