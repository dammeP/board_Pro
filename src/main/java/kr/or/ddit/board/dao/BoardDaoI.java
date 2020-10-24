package kr.or.ddit.board.dao;

import kr.or.ddit.board.vo.UsersVO;

public interface BoardDaoI {
	UsersVO getUsers(String userId);
}
