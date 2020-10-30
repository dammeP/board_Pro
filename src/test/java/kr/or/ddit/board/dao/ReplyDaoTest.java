package kr.or.ddit.board.dao;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.dao.ReplyDaoI;
import kr.or.ddit.reply.vo.ReplyVO;

public class ReplyDaoTest {
	ReplyDaoI replyDao;
	
	public ReplyDaoTest() {
		replyDao = new ReplyDao();
	}
	
	@Test
	public void insertReplyTest() {
		/***Given***/
		ReplyVO replyVO = new ReplyVO();

		/***When***/
		int insertCnt = replyDao.insertReply(replyVO);

		/***Then***/
		assertEquals(1, insertCnt);
		
	}
}
