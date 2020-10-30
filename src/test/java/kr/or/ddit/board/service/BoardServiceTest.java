package kr.or.ddit.board.service;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.CBoardVO;
import kr.or.ddit.board.vo.FilesVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.board.vo.UsersVO;
import kr.or.ddit.reply.vo.ReplyVO;

public class BoardServiceTest {
	BoardServiceI boardService;
	
	@Before
	public void setup() {
		boardService = new BoardService();
	}
	
	@Test
	public void getUsersTest() {
		/***Given***/
		String userId = "brown";
		
		UsersVO answerUsersVO = new UsersVO();
		answerUsersVO.setUserId("brown");
		answerUsersVO.setPass("brownPass");
		
		/***When***/
		UsersVO usersVO = boardService.getUsers(userId);

		/***Then***/
		assertEquals("brown", usersVO.getUserId());
		assertEquals("brownPass", usersVO.getPass());
	}
	
	@Test
	public void selectAllCBoardTest() {
		/***Given***/
		
		/***When***/
		List<CBoardVO> cboardList = boardService.selectAllCBoard();
		
		/***Then***/
		assertEquals(6, cboardList.size());
	}
	
	@Test
	public void selectUseCBoardTest() {
		/***Given***/

		/***When***/
		List<CBoardVO> cboardList = boardService.selectUseCBoard();
		
		/***Then***/
		assertEquals(4, cboardList.size());
		
	}
	
	@Test
	public void insertCBoardTest() {
		/***Given***/
		CBoardVO cboardVO = new CBoardVO("1","공지사항2","7","brown");

		/***When***/
		int insertCnt = boardService.insertCBoard(cboardVO);

		/***Then***/
		assertEquals(1, insertCnt);

	}
	
	@Test
	public void updateCBoardTest() {
		/***Given***/
		

		/***When***/

		/***Then***/
		
	}
	
	@Test
	public void selectPageBoardTest() {
		/***Given***/
		PageVO pageVO = new PageVO(1, 10, "10");

		/***When***/
		Map<String, Object> map = boardService.selectPageBoard(pageVO);
		List<BoardVO> boardListPage = (List<BoardVO>)map.get("boardList");
		int pages = (int)map.get("pages");

		/***Then***/
		assertEquals(10, boardListPage.size());
		assertEquals(3, 4);
		
	}
	
	@Test
	public void selectTotalCntBoardTest() {
		/***Given***/
		String cboardNo = "1";

		/***When***/
		int boardCnt = boardService.selectTotalCntBoard(cboardNo);
		
		/***Then***/
		assertEquals(33, boardCnt);
	}
	
	@Test
	public void getBoardTest() {
		/***Given***/
		String boardNo = "1";

		/***When***/
		BoardVO boardVO = boardService.getBoard(boardNo);

		/***Then***/
		assertEquals("공지사항1", boardVO.getBoardTitle());
	}
	
	@Test
	public void insertBoardTest() {
		/***Given***/
//		BoardVO boardVO = new BoardVO("200","글제목","글내용","2020-11-01","sally","1","1","5");
		BoardVO boardVO = new BoardVO();

		/***When***/
		int insertCnt = boardService.insertBoard(boardVO);
		
		/***Then***/
		assertEquals(1, insertCnt);

	}

	@Test
	public void insertFilesTest() {
		/***Given***/
		FilesVO filesVO = new FilesVO();

		/***When***/
		int insertCnt = boardService.insertFiles(filesVO);
		
		/***Then***/
		assertEquals(1, insertCnt);
		
	}
	
	@Test
	public void deleteBoardTest() {
		/***Given***/
		String boardNo = "4";

		/***When***/
		int deleteCnt = boardService.deleteBoard(boardNo);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	@Test
	public void updateBoard() {
		/***Given***/
		BoardVO boardVO = new BoardVO();

		/***When***/
		int updateCnt = boardService.updateBoard(boardVO);

		/***Then***/
		assertEquals(1, updateCnt);
		
	}
	
	@Test
	public void deleteFilesTest() {
		/***Given***/
		String fileNo = "1";

		/***When***/
		int deleteCnt = boardService.deleteFiles(fileNo);

		/***Then***/
		assertEquals(1, deleteCnt);
		
	}
	
	@Test
	public void selectImgfilesTest() {
		/***Given***/
		String fileNo = "34";

		/***When***/
		FilesVO filesVO = boardService.selectImgfiles(fileNo);

		/***Then***/
		assertEquals("감자.PNG", filesVO.getRealFileNm());
		
	}
	
	
}
