package kr.or.ddit.board.vo;

public class CBoradVO {
	private String cboardUseCheck;
	private String cboardCategory;
	private String cboardNo;
	private String userId;
	
	public String getCboardUseCheck() {
		return cboardUseCheck;
	}
	public void setCboardUseCheck(String cboardUseCheck) {
		this.cboardUseCheck = cboardUseCheck;
	}
	public String getCboardCategory() {
		return cboardCategory;
	}
	public void setCboardCategory(String cboardCategory) {
		this.cboardCategory = cboardCategory;
	}
	public String getCboardNo() {
		return cboardNo;
	}
	public void setCboardNo(String cboardNo) {
		this.cboardNo = cboardNo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "CBoradVO [cboardUseCheck=" + cboardUseCheck + ", cboardCategory=" + cboardCategory + ", cboardNo="
				+ cboardNo + ", userId=" + userId + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cboardCategory == null) ? 0 : cboardCategory.hashCode());
		result = prime * result + ((cboardNo == null) ? 0 : cboardNo.hashCode());
		result = prime * result + ((cboardUseCheck == null) ? 0 : cboardUseCheck.hashCode());
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
		CBoradVO other = (CBoradVO) obj;
		if (cboardCategory == null) {
			if (other.cboardCategory != null)
				return false;
		} else if (!cboardCategory.equals(other.cboardCategory))
			return false;
		if (cboardNo == null) {
			if (other.cboardNo != null)
				return false;
		} else if (!cboardNo.equals(other.cboardNo))
			return false;
		if (cboardUseCheck == null) {
			if (other.cboardUseCheck != null)
				return false;
		} else if (!cboardUseCheck.equals(other.cboardUseCheck))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}
	
	
	
}
