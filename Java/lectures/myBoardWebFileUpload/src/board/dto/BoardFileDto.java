package board.dto;

import java.time.LocalDateTime;

public class BoardFileDto {
	private int fileId;
	private int boardId;
	private String fileName;
	private long filesize;
	private String fileContentType;
	private String fileUrl;
	private LocalDateTime regDt;
	
	public int getFileId() {
		return fileId;
	}
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getFilesize() {
		return filesize;
	}
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getFileUrl() {
		return fileUrl;
	}
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	public LocalDateTime getRegDt() {
		return regDt;
	}
	public void setRegDt(LocalDateTime regDt) {
		this.regDt = regDt;
	}
}
