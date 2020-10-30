package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.CBoardVO;
import kr.or.ddit.board.vo.FilesVO;
import kr.or.ddit.board.vo.PageVO;
import kr.or.ddit.board.vo.UsersVO;
import kr.or.ddit.db.MybatisUtil;

public class BoardDao implements BoardDaoI{

	private static final Logger logger = LoggerFactory.getLogger(BoardDao.class);
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
		logger.debug("CntTTTTTT:{}",insertCnt);
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
		sqlSession.close();
		return Cnt;
		 
	}

	@Override
	public BoardVO getBoard(String boardNo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		BoardVO boardVO = sqlSession.selectOne("board.getBoard",boardNo);
		sqlSession.close();
		
		return boardVO;
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		
		try {
			insertCnt = sqlSession.insert("board.insertBoard",boardVO);
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
	public int insertFiles(FilesVO filesVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		
		try {
			insertCnt = sqlSession.insert("files.insertFiles",filesVO);
		} catch (Exception e) {
		}
		logger.debug("cntttt:{}",insertCnt);
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
	public int deleteBoard(String boardNo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int deleteCnt = 0;
		
		try {
			deleteCnt = sqlSession.update("board.deleteBoard",boardNo);
		} catch (Exception e) {
		}

		if(deleteCnt == 1) {
			sqlSession.commit();
		}
		else {
			sqlSession.rollback();
		}
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public List<FilesVO> selectAllFiles(String boardNo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		List<FilesVO> filesVO = sqlSession.selectList("files.selectAllFiles",boardNo);
		
		sqlSession.close();
		
		return filesVO;
	}

	@Override
	public int updateBoard(BoardVO boardVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt = 0;
		
		try {
			updateCnt = sqlSession.update("board.updateBoard",boardVO);
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
	public int deleteFiles(String fileNo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt = 0;
//		logger.debug("######dao-side-fileNo : {}", fileNo);
		try {
			updateCnt = sqlSession.delete("files.deleteFiles",fileNo);

		} catch (Exception e) {
			e.printStackTrace();
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
	public FilesVO selectImgfiles(String fileNo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		FilesVO filesVO = sqlSession.selectOne("files.getFilesImg",fileNo);
		sqlSession.close();
		
		return filesVO;
	}

	@Override
	public int insertBoardPa(BoardVO boardVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		
		try {
			insertCnt = sqlSession.insert("board.insertBoardPa",boardVO);
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
	


}
