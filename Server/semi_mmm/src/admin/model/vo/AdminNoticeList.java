package admin.model.vo;

import java.util.ArrayList;

import notice.model.vo.Notice;

public class AdminNoticeList {
	ArrayList<Notice> list;
	String pageNavi;

	public AdminNoticeList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminNoticeList(ArrayList<Notice> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}

	public ArrayList<Notice> getList() {
		return list;
	}

	public void setList(ArrayList<Notice> list) {
		this.list = list;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

}
