package kr.or.ddit.reply.service;

import java.util.List;

import kr.or.ddit.reply.dao.ReplyDao;
import kr.or.ddit.reply.dao.ReplyDaoI;
import kr.or.ddit.reply.vo.ReplyVO;

public class ReplyService implements ReplyServiceI{
	
	ReplyDaoI replyDao;
	
	public ReplyService() {
		replyDao = new ReplyDao();
	}
	

	@Override
	public int insertReply(ReplyVO replyVO) {
		return replyDao.insertReply(replyVO);
	}


	@Override
	public List<ReplyVO> selectAllReply(String boardNo) {
		return replyDao.selectAllReply(boardNo);
	}


	@Override
	public int updateReply(String replyNo) {
		return replyDao.updateReply(replyNo);
	}

}
