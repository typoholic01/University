package kh.com.model;

import java.io.Serializable;

public class Query implements Serializable {
	private static final long serialVersionUID = -2619339902153486228L;
	
	private String boardName;					//게시판 제목
	private int bbsSeq;							//질의 번호
	private int startArticle;					//시작 게시물
	private int endArticle;						//끝 게시물

	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public int getBbsSeq() {
		return bbsSeq;
	}
	public void setBbsSeq(int bbsSeq) {
		this.bbsSeq = bbsSeq;
	}
	public int getStartArticle() {
		return startArticle;
	}
	public void setStartArticle(int startArticle) {
		this.startArticle = startArticle;
	}
	public int getEndArticle() {
		return endArticle;
	}
	public void setEndArticle(int endArticle) {
		this.endArticle = endArticle;
	}
	
	@Override
	public String toString() {
		return "Query [boardName=" + boardName + ", bbsSeq=" + bbsSeq + ", startArticle=" + startArticle
				+ ", endArticle=" + endArticle + "]";
	}

	
}
