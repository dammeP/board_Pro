package kr.or.ddit.board.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import kr.or.ddit.reply.service.ReplyService;
import kr.or.ddit.reply.service.ReplyServiceI;
import kr.or.ddit.reply.vo.ReplyVO;

public class ReplyServiceTest {
	ReplyServiceI replySevice;
	
	public ReplyServiceTest() {
		replySevice = new ReplyService();
	}

	@Test
	public void insertReplyTest() {
		/***Given***/
		ReplyVO replyVO = new ReplyVO();

		/***When***/
		int insertCnt = replySevice.insertReply(replyVO);

		/***Then***/
		assertEquals(1, insertCnt);
		
	}
}
