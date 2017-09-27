package kh.com.util;

public class Pagination {

	private int totalArticle;					//총 게시물
	private int currPage;						//현재 페이지
	private int startBbs;					//시작 게시물
	private int endBbs;						//끝 게시물
	private int startPage;						//리스트 시작 번호
	private int endPage;						//리스트 종료 번호
	private int finalEndPage;					//최종 페이지 번호
	private final int articleLimit = 10;		//한 페이지 당 게시물 제한
	private final int pageLimit = 5;			//한 리스트 당 페이지 수 제한

	@SuppressWarnings("unused")
	private Pagination() {}
	
	public Pagination(int totalArticle, int currPage) {
		this.totalArticle = totalArticle;
		this.currPage = currPage;
		
		//시작 게시물 지정
		startBbs = articleLimit*(currPage - 1) + 1;
		if (startBbs == 0) startBbs = 1; 
		
		//끝 게시물 지정
		endBbs = articleLimit*currPage<=totalArticle?articleLimit*currPage:totalArticle;		
		
		//시작 페이지 지정
		startPage = currPage-(currPage-1)%pageLimit;
		
		//끝나는 페이지 지정
		endPage = (currPage-(currPage-1)%pageLimit)+pageLimit - 1;
		
		if (endPage*articleLimit > totalArticle) {
			// 1의 자리수를 빼고 더한다
			endPage = totalArticle/articleLimit;				
			// 1의 자리수가 1이라도 있으면 페이지를 추가한다
			endPage += (totalArticle%articleLimit > 0)?1:0;	
		}

		//최종 페이지 번호
		finalEndPage = totalArticle/articleLimit;
		finalEndPage += (totalArticle%articleLimit > 0)?1:0;
		
		
	}

	public int getTotalArticle() {
		return totalArticle;
	}

	public void setTotalArticle(int totalArticle) {
		this.totalArticle = totalArticle;
	}

	public int getCurrPage() {
		return currPage;
	}

	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}

	public int getStartBbs() {
		return startBbs;
	}

	public void setStartBbs(int startBbs) {
		this.startBbs = startBbs;
	}

	public int getEndBbs() {
		return endBbs;
	}

	public void setEndBbs(int endBbs) {
		this.endBbs = endBbs;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getArticleLimit() {
		return articleLimit;
	}

	public int getPageLimit() {
		return pageLimit;
	}
	public int getFinalEndPage() {
		return finalEndPage;
	}

	public void setFinalEndPage(int finalEndPage) {
		this.finalEndPage = finalEndPage;
	}

	@Override
	public String toString() {
		return "Pagination [totalArticle=" + totalArticle + ", currPage=" + currPage + ", startArticle=" + startBbs
				+ ", endArticle=" + endBbs + ", startPage=" + startPage + ", endPage=" + endPage + ", finalEndPage="
				+ finalEndPage + ", articleLimit=" + articleLimit + ", pageLimit=" + pageLimit + "]";
	}
	
	
	
}
