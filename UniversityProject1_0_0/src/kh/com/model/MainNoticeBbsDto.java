package kh.com.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("MainNoticeBbsDto")
public class MainNoticeBbsDto implements Serializable {
	private static final long serialVersionUID = 8072410603610302433L;
	
	private int noticeBbsSeq;
	private String userId;
	private String title;
	private String content;
	private int readCount;
	private String fileName;
	private String orgFileName;
	private String wDate;
	public int getNoticeBbsSeq() {
		return noticeBbsSeq;
	}
	public void setNoticeBbsSeq(int noticeBbsSeq) {
		this.noticeBbsSeq = noticeBbsSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getOrgFileName() {
		return orgFileName;
	}
	public void setOrgFileName(String orgFileName) {
		this.orgFileName = orgFileName;
	}
	public String getwDate() {
		return wDate;
	}
	public void setwDate(String wDate) {
		this.wDate = wDate;
	}
	
	@Override
	public String toString() {
		return "MainNoticeBbs [noticeBbsSeq=" + noticeBbsSeq + ", userId=" + userId + ", title=" + title + ", content="
				+ content + ", readCount=" + readCount + ", fileName=" + fileName + ", orgFileName=" + orgFileName
				+ ", wDate=" + wDate + "]";
	}
}
