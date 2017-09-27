package kh.com.model;

import java.io.Serializable;

public class MainBbs implements Serializable {
	private static final long serialVersionUID = 1843374038002416069L;
	
	private String boardName;
	private int bbsRef;
	private String bbsReply;
	private int bbsSeq;
	private String userId;
	private String bbsTitle;
	private String bbsContent;
	private int bbsReadCount;
	private String bbsStoredFileName;
	private String bbsOrgFileName;
	private String bbsStatus;
	private String bbsWdate;
	
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public int getBbsRef() {
		return bbsRef;
	}
	public void setBbsRef(int bbsRef) {
		this.bbsRef = bbsRef;
	}
	public String getBbsReply() {
		return bbsReply;
	}
	public void setBbsReply(String bbsReply) {
		this.bbsReply = bbsReply;
	}
	public int getBbsSeq() {
		return bbsSeq;
	}
	public void setBbsSeq(int bbsSeq) {
		this.bbsSeq = bbsSeq;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBbsTitle() {
		return bbsTitle;
	}
	public void setBbsTitle(String bbsTitle) {
		this.bbsTitle = bbsTitle;
	}
	public String getBbsContent() {
		return bbsContent;
	}
	public void setBbsContent(String bbsContent) {
		this.bbsContent = bbsContent;
	}
	public int getBbsReadCount() {
		return bbsReadCount;
	}
	public void setBbsReadCount(int bbsReadCount) {
		this.bbsReadCount = bbsReadCount;
	}
	public String getBbsStoredFileName() {
		return bbsStoredFileName;
	}
	public void setBbsStoredFileName(String bbsStoredFileName) {
		this.bbsStoredFileName = bbsStoredFileName;
	}
	public String getBbsOrgFileName() {
		return bbsOrgFileName;
	}
	public void setBbsOrgFileName(String bbsOrgFileName) {
		this.bbsOrgFileName = bbsOrgFileName;
	}
	public String getBbsStatus() {
		return bbsStatus;
	}
	public void setBbsStatus(String bbsStatus) {
		this.bbsStatus = bbsStatus;
	}
	public String getBbsWdate() {
		return bbsWdate;
	}
	public void setBbsWdate(String bbsWdate) {
		this.bbsWdate = bbsWdate;
	}
	
	@Override
	public String toString() {
		return "MainBBS [boardName=" + boardName + ", bbsRef=" + bbsRef + ", bbsReply=" + bbsReply + ", bbsSeq="
				+ bbsSeq + ", userId=" + userId + ", bbsTitle=" + bbsTitle + ", bbsContent=" + bbsContent
				+ ", bbsReadCount=" + bbsReadCount + ", bbsStoredFileName=" + bbsStoredFileName + ", bbsOrgFileName="
				+ bbsOrgFileName + ", bbsStatus=" + bbsStatus + ", bbsWdate=" + bbsWdate + "]";
	}
}
