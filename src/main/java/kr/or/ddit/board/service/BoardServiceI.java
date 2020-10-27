package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.CBoardVO;
import kr.or.ddit.board.vo.UsersVO;

public interface BoardServiceI {

	UsersVO getUsers(String userId);
		
	List<CBoardVO> selectAllCBoard();	// CBoard 전체 리스트 조회
	
	List<CBoardVO> selectUseCBoard();	// CBoard 사용가능한 리스트만 조회
	
	int insertCBoard(CBoardVO cboardVO);  // 게시판 생성
	
	int updateCBoard(CBoardVO CBoardVO);	// 게시판 사용/미사용 수정
}
