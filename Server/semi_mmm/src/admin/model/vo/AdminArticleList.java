package admin.model.vo;

import java.util.ArrayList;

import article.model.vo.ArticleNotice;

public class AdminArticleList {

	ArrayList<ArticleNotice> list;
	String pageNavi;

	public AdminArticleList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminArticleList(ArrayList<ArticleNotice> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}

	public ArrayList<ArticleNotice> getList() {
		return list;
	}

	public void setList(ArrayList<ArticleNotice> list) {
		this.list = list;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

}
