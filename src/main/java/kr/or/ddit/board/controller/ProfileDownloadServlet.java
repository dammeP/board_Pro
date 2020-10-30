package kr.or.ddit.board.controller;

import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
import kr.or.ddit.board.vo.FilesVO;

/**
 * Servlet implementation class ProfileDownloadServlet
 */
@WebServlet("/profileDownload")
public class ProfileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
BoardServiceI boardService;
	
	@Override
		public void init() throws ServletException {
		boardService = new BoardService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("image/png");
		
		String fileNo = request.getParameter("fileNo");
		
		FilesVO filesVO = boardService.selectImgfiles(fileNo);
		
		response.setHeader("Content-Disposition", "attachment; filename=\"\"" + filesVO.getRealFileNm()+ "\"");
		response.setContentType("application/octet-stream");
		
		
		FileInputStream fis = new FileInputStream(filesVO.getFileNm());
		ServletOutputStream sos = response.getOutputStream();
		
		byte[] buffer = new byte[512];
		
		while(fis.read(buffer) != -1) { 
			sos.write(buffer);
		}
		
		fis.close();
		sos.flush();
		sos.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
