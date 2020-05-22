package admin.model.vo;

import java.util.ArrayList;

import qna.model.vo.QnaAnswer;

public class AdminAnswerList {

	ArrayList<QnaAnswer> list;
	String pageNavi;

	public AdminAnswerList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminAnswerList(ArrayList<QnaAnswer> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}

	public ArrayList<QnaAnswer> getList() {
		return list;
	}

	public void setList(ArrayList<QnaAnswer> list) {
		this.list = list;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

}
