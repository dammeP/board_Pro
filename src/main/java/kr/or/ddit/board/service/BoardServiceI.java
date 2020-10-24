package kr.or.ddit.board.service;

import kr.or.ddit.board.vo.UsersVO;

public interface BoardServiceI {

	UsersVO getUsers(String userId);
}
