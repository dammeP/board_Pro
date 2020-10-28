package kr.or.ddit.login;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
	private BoardServiceI boardService;
	
	@Override
	public void init() throws ServletException {
		boardService = new BoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		UsersVO usersVO = boardService.getUsers(userId);
		
		List<CBoardVO> cBoardVO = boardService.selectAllCBoard();
		
		logger.debug("userId : {}, pass : {}" , userId, pass);
		logger.debug("cBoardcategory : {}",cBoardVO);
//		logger.debug("usersVO.getPass : {}", usersVO.getPass());
		
		// 등록된 회원이 없거나, 비밀번호가 틀렸을 떄
		if(usersVO == null || !usersVO.getPass().equals(pass) ) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		// 일치할 때
		else if(usersVO.getPass().equals(pass)){
			request.getSession().setAttribute("S_USERS", usersVO);
			request.getSession().setAttribute("cBoardList", cBoardVO);
			
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}
		
		
	}
	
}
