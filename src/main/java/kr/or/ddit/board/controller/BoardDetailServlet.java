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
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.FilesVO;

/**
 * Servlet implementation class BoardDetailServlet
 */
@WebServlet("/BoardDetail")
public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardDetailServlet.class);
	
	BoardServiceI boardService;
	
	@Override
		public void init() throws ServletException {
			boardService = new BoardService();
		}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("boardNo");
		logger.debug("boNO:{}",boardNo);
		
		BoardVO boardVO = boardService.getBoard(boardNo);
		request.setAttribute("boardNo", boardNo);
		request.setAttribute("boardVO", boardVO);
		
		List<FilesVO> filesList = boardService.selectAllFiles(boardNo);
 		
		request.setAttribute("filesList", filesList); 
		
		request.getRequestDispatcher("/board/boardDetail.jsp").forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
