package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.CBoardVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.board.vo.UsersVO;
import kr.or.ddit.db.MybatisUtil;

public class BoardDao implements BoardDaoI{

	@Override
	public UsersVO getUsers(String userId) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		UsersVO usersVO = sqlSession.selectOne("users.getUsers",userId);
		sqlSession.close();
		
		return usersVO;
	
	}

	@Override
	public List<CBoardVO> selectAllCBoard() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<CBoardVO> cBoardList = sqlSession.selectList("cboard.selectAllCBoard");
		
		sqlSession.close();
		return cBoardList;
	}

	@Override
	public List<CBoardVO> selectUseCBoard() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<CBoardVO> cBoardList = sqlSession.selectList("cboard.selectUseCBoard");
		
		sqlSession.close();
		return cBoardList;
	}
	
	@Override
	public int insertCBoard(CBoardVO cboardVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		
		try {
			insertCnt = sqlSession.insert("cboard.insertCBoard",cboardVO);
		} catch (Exception e) {
		}
		
		if(insertCnt == 1) {
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return insertCnt;
	}

	@Override
	public int updateCBoard(CBoardVO CBoardVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt = 0;
		
		try {
			updateCnt = sqlSession.update("cboard.updateCBoard",CBoardVO);
		} catch (Exception e) {
		}
		
		if(updateCnt == 1) {
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		sqlSession.close();
		
		return updateCnt;
	}

	@Override
	public List<BoardVO> selectPageBoard(PageVO pageVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<BoardVO> boardPage = sqlSession.selectList("board.selectPageBoard" , pageVO);
		
		sqlSession.close();
		
		return boardPage;
		
	}

	@Override
	public int selectTotalCntBoard(String cboardNo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		int Cnt = sqlSession.selectOne("board.selectTotalCntBoard",cboardNo); 
		return Cnt;
		 
	}

	@Override
	public BoardVO getBoard(String boardNo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		BoardVO boardVO = sqlSession.selectOne("board.getBoard",boardNo);
		sqlSession.close();
		
		return boardVO;
	}


}
