package kr.or.ddit.board.dao;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceI;
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

}
