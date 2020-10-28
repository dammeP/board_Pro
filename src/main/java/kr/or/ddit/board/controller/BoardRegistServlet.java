package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.CBoardVO;
import kr.or.ddit.board.vo.FilesVO;
import kr.or.ddit.fileUpload.FileUploadUtil;

/**
 * Servlet implementation class BoardRegist
 */
@WebServlet("/BoardRegist")
@MultipartConfig
public class BoardRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardRegistServlet.class);
	
	BoardServiceI boardService;
	int insertFilesCnt =0;
	int insertCnt =0;
	FilesVO filesVO;
	
	@Override
		public void init() throws ServletException {
		boardService = new BoardService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/board/boardRegist.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String cboardNo = request.getParameter("cboardNo");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		String userId = request.getParameter("userId");
		
		logger.debug("글제목, 글 내용, cboardNo , 아이디:{},{},{},{}",boardTitle, boardContent,cboardNo,userId);
		
		BoardVO boardVO = new BoardVO();
		boardVO.setUserId(userId);
		boardVO.setBoardTitle(boardTitle);
		boardVO.setBoardContent(boardContent);
		boardVO.setCBoardNo(cboardNo);
		
		
		
		insertCnt = boardService.insertBoard(boardVO);
		for (int i = 1; i < 6; i++) {
			Part profile = request.getPart("fileName" + i);
			logger.debug("file : {}", profile.getHeader("Content-Disposition"));

			String realFilename = FileUploadUtil.getFilename(profile.getHeader("Content-Disposition"));
			String fileName = UUID.randomUUID().toString();
			String filePath = "";
			String realFileNm = "";

			if (profile.getSize() > 0) {
				String extension = FileUploadUtil.getExtenstion(realFilename);
				filePath = "D:\\profile\\" + fileName + "." + extension;
				realFileNm = fileName + "." + extension;
				profile.write(filePath);

				if (realFileNm != null) {

					String board = boardVO.getBoardNo();

					logger.debug("baordNo:{}", board);

					filesVO = new FilesVO();
					filesVO.setFileNm(filePath);
					filesVO.setRealFileNm(realFileNm);
					filesVO.setBoardNo(board);

					insertFilesCnt = boardService.insertFiles(filesVO);
					logger.debug("insertBoardCnt : {}", insertCnt);
					logger.debug("filesVO:{}", filesVO);
					logger.debug("insertFileCnt : {}", insertCnt);
				}

			}
		}
		
		
		if(insertCnt == 1 && insertFilesCnt ==1) {
			request.getSession().setAttribute("userId", boardVO.getUserId());
			request.getSession().setAttribute("BoardList", boardVO);
			request.getSession().setAttribute("cboardNo",cboardNo);
			request.getSession().setAttribute("filesVO",filesVO);
			response.sendRedirect(request.getContextPath() +"/boardList?cboardNo="+cboardNo);
		}
		else {
			doGet(request, response);
		}
		
		
	
	}

}
