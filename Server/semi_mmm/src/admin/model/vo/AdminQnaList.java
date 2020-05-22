package admin.model.vo;

import java.util.ArrayList;

import qna.model.vo.QnaNotice;

public class AdminQnaList {

	ArrayList<QnaNotice> list;
	String pageNavi;

	public AdminQnaList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminQnaList(ArrayList<QnaNotice> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}

	public ArrayList<QnaNotice> getList() {
		return list;
	}

	public void setList(ArrayList<QnaNotice> list) {
		this.list = list;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

}
