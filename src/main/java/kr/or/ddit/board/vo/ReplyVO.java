package kr.or.ddit.board.vo;

import java.sql.Date;

public class ReplyVO {
	private String replyNo;
	private String replyContent;
	private Date replyDate;
	private String replyDelCheck;
	private String userId;
	
	public String getReplyNo() {
		return replyNo;
	}
	public void setReplyNo(String replyNo) {
		this.replyNo = replyNo;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public String getReplyDelCheck() {
		return replyDelCheck;
	}
	public void setReplyDelCheck(String replyDelCheck) {
		this.replyDelCheck = replyDelCheck;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", replyContent=" + replyContent + ", replyDate=" + replyDate
				+ ", replyDelCheck=" + replyDelCheck + ", userId=" + userId + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((replyContent == null) ? 0 : replyContent.hashCode());
		result = prime * result + ((replyDate == null) ? 0 : replyDate.hashCode());
		result = prime * result + ((replyDelCheck == null) ? 0 : replyDelCheck.hashCode());
		result = prime * result + ((replyNo == null) ? 0 : replyNo.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReplyVO other = (ReplyVO) obj;
		if (replyContent == null) {
			if (other.replyContent != null)
				return false;
		} else if (!replyContent.equals(other.replyContent))
			return false;
		if (replyDate == null) {
			if (other.replyDate != null)
				return false;
		} else if (!replyDate.equals(other.replyDate))
			return false;
		if (replyDelCheck == null) {
			if (other.replyDelCheck != null)
				return false;
		} else if (!replyDelCheck.equals(other.replyDelCheck))
			return false;
		if (replyNo == null) {
			if (other.replyNo != null)
				return false;
		} else if (!replyNo.equals(other.replyNo))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	
}
