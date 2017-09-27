package kh.com.model;

import java.io.Serializable;

import org.apache.ibatis.type.Alias;

@Alias("MainPdsDto")
public class MainPdsDto implements Serializable {
	private static final long serialVersionUID = -7643888834953524245L;
	
	private int ref;
	private String replyShape;
	private String pdsSeq;
	private String userId;
	private String title;
	private String content;
	private int readCount;
	private String fileName;
	private String orgFileName;
	private int status;
	private String wDate;
	public int getRef() {
		return ref;
	}
	public void setRef(int ref) {
		this.ref = ref;
	}
	public String getReplyShape() {
		return replyShape;
	}
	public void setReplyShape(String replyShape) {
		this.replyShape = replyShape;
	}
	public String getPdsSeq() {
		return pdsSeq;
	}
	public void setPdsSeq(String pdsSeq) {
		this.pdsSeq = pdsSeq;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getwDate() {
		return wDate;
	}
	public void setwDate(String wDate) {
		this.wDate = wDate;
	}
	
	@Override
	public String toString() {
		return "MainPdsDto [ref=" + ref + ", replyShape=" + replyShape + ", pdsSeq=" + pdsSeq + ", userId=" + userId
				+ ", title=" + title + ", content=" + content + ", readCount=" + readCount + ", fileName=" + fileName
				+ ", orgFileName=" + orgFileName + ", status=" + status + ", wDate=" + wDate + "]";
	}

}
