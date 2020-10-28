package kr.or.ddit.board.vo;

public class FilesVO {
	private String fileNm;
	private String realFileNm;
	private String boardNo;
	
	public String getFileNm() {
		return fileNm;
	}
	public void setFileNm(String fileNm) {
		this.fileNm = fileNm;
	}
	public String getRealFileNm() {
		return realFileNm;
	}
	public void setRealFileNm(String realFileNm) {
		this.realFileNm = realFileNm;
	}
	public String getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((boardNo == null) ? 0 : boardNo.hashCode());
		result = prime * result + ((fileNm == null) ? 0 : fileNm.hashCode());
		result = prime * result + ((realFileNm == null) ? 0 : realFileNm.hashCode());
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
		FilesVO other = (FilesVO) obj;
		if (boardNo == null) {
			if (other.boardNo != null)
				return false;
		} else if (!boardNo.equals(other.boardNo))
			return false;
		if (fileNm == null) {
			if (other.fileNm != null)
				return false;
		} else if (!fileNm.equals(other.fileNm))
			return false;
		if (realFileNm == null) {
			if (other.realFileNm != null)
				return false;
		} else if (!realFileNm.equals(other.realFileNm))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "FilesVO [fileNm=" + fileNm + ", realFileNm=" + realFileNm + ", boardNo=" + boardNo + "]";
	}
	
	
	
	
}
