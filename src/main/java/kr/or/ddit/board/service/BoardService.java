package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoI;
import kr.or.ddit.board.vo.CBoardVO;
import kr.or.ddit.board.vo.UsersVO;

public class BoardService implements BoardServiceI{

	BoardDaoI boardDao;
	
	public BoardService() {
		boardDao = new BoardDao();
	}

	@Override
	public UsersVO getUsers(String userId) {
		return boardDao.getUsers(userId);
	}

	@Override
	public List<CBoardVO> selectAllCBoard() {
		return boardDao.selectAllCBoard();
	}

	@Override
	public List<CBoardVO> selectUseCBoard() {
		return boardDao.selectUseCBoard();
	}
	
	@Override
	public int insertCBoard(CBoardVO cboardVO) {
		return boardDao.insertCBoard(cboardVO);
	}

	@Override
	public int updateCBoard(CBoardVO CBoardVO) {
		return boardDao.updateCBoard(CBoardVO);
	}



}
