package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
import kr.or.ddit.board.vo.FilesVO;
import kr.or.ddit.fileUpload.FileUploadUtil;

@WebServlet("/BoardUpdate")
@MultipartConfig
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(BoardUpdateServlet.class);
	BoardServiceI boardService;
	BoardVO boardVO;
	int insertFilesCnt =0;
	int updateCnt =0;
	int deleteFilesCnt=0;
	FilesVO filesVO;
	
	@Override
		public void init() throws ServletException {
		
		boardService = new BoardService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("boardNo");
		logger.debug("boNO:{}",boardNo);
		
		BoardVO boardVO = boardService.getBoard(boardNo);
		request.setAttribute("boardVO", boardVO);
		
		List<FilesVO> filesList = boardService.selectAllFiles(boardNo);
		request.setAttribute("filesList", filesList); 
		logger.debug("보드업뎃 서블릿 fileNO:{}",filesList);
		
		request.getRequestDispatcher("/board/boardUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String boardNo = request.getParameter("boardNo");
		String boardTitle = request.getParameter("boardTitle");
		String boardContent = request.getParameter("boardContent");
		
		String[] fileNo = request.getParameterValues("fileNoUp");
//		String[] fileNm = request.getParameterValues("fileNm");
		
//		String fileNo = request.getParameter("fileNo");
//		String fileNm = request.getParameter("fileNm");
		logger.debug("arraystoString : {}",Arrays.toString(fileNo));
		logger.debug("fileNNNNNOOOO:{}",fileNo);

		if(fileNo != null){
			for(String fileNo2 : fileNo) {
				if(!fileNo2.equals("")){
					logger.debug("fileNO222:{}",fileNo2);
					deleteFilesCnt = boardService.deleteFiles(fileNo2);
				}
			}
		}
		
		boardVO = new BoardVO();
		boardVO.setBoardNo(boardNo);
		boardVO.setBoardTitle(boardTitle);
		boardVO.setBoardContent(boardContent);
		
		logger.debug("수정된 제목, 수정된 글 :{},{}"+ boardTitle,boardContent);
		
		
		updateCnt = boardService.updateBoard(boardVO);
		
		
		List<Part> partList = new ArrayList<>(request.getParts());
		
		int cnt = 0;
		for(Part part : partList) {
			if(part.getName().indexOf("fileName")!= -1) {
				cnt++;
			}
		}
		
		for (int i = 1; i<cnt+1; i++) {
			
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
				}
			}
		}
					logger.debug("insertBoardCnt : {}", updateCnt);
					logger.debug("insertFileCnt : {}", insertFilesCnt);
					logger.debug("deleteFilesCnt : {}", deleteFilesCnt);
					
		if(updateCnt == 1 || insertFilesCnt ==1 || deleteFilesCnt ==1) {
			request.getSession().setAttribute("userId", boardVO.getUserId());
			request.getSession().setAttribute("BoardList", boardVO);
			request.getSession().setAttribute("filesVO",filesVO);
			response.sendRedirect(request.getContextPath() +"/BoardDetail?boardNo="+boardVO.getBoardNo());
		}
		else {
			doGet(request, response);
		}
		
		
	
	}

}
