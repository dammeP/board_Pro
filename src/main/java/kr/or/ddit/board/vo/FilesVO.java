package kr.or.ddit.board.vo;

public class FilesVO {
	private String fileName;
	private String realFileName;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getRealFileName() {
		return realFileName;
	}
	public void setRealFileName(String realFileName) {
		this.realFileName = realFileName;
	}
	
	@Override
	public String toString() {
		return "FilesVO [fileName=" + fileName + ", realFileName=" + realFileName + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fileName == null) ? 0 : fileName.hashCode());
		result = prime * result + ((realFileName == null) ? 0 : realFileName.hashCode());
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
		if (fileName == null) {
			if (other.fileName != null)
				return false;
		} else if (!fileName.equals(other.fileName))
			return false;
		if (realFileName == null) {
			if (other.realFileName != null)
				return false;
		} else if (!realFileName.equals(other.realFileName))
			return false;
		return true;
	}
	
	
}
