package kr.or.ddit.reply.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.board.vo.CBoardVO;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.reply.vo.ReplyVO;

public class ReplyDao implements ReplyDaoI{
	private static final Logger logger = LoggerFactory.getLogger(ReplyDao.class);

	@Override
	public int insertReply(ReplyVO replyVO) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int insertCnt = 0;
		
		try {
			insertCnt = sqlSession.insert("reply.insertReply",replyVO);
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
	public List<ReplyVO> selectAllReply(String boardNo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		
		List<ReplyVO> replyList = sqlSession.selectList("reply.selectAllReply",boardNo);
		
		sqlSession.close();
		return replyList;
		
	}

	@Override
	public int updateReply(String replyNo) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		int updateCnt = 0;
		
		try {
			updateCnt = sqlSession.insert("reply.updateReply",replyNo);
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

}
