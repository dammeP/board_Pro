package kr.or.ddit.board.service;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoI;
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

}
