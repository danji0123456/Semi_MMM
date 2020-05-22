package admin.model.vo;

import java.util.ArrayList;

import article.model.vo.ArticleNoticeComment;

public class AdminArticleCommentList {

	ArrayList<ArticleNoticeComment> list;
	String pageNavi;

	public AdminArticleCommentList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminArticleCommentList(ArrayList<ArticleNoticeComment> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}

	public ArrayList<ArticleNoticeComment> getList() {
		return list;
	}

	public void setList(ArrayList<ArticleNoticeComment> list) {
		this.list = list;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

}
