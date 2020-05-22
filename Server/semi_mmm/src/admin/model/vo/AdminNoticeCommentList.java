package admin.model.vo;

import java.util.ArrayList;

import notice.model.vo.NoticeComment;

public class AdminNoticeCommentList {

	ArrayList<NoticeComment> list;
	String pageNavi;

	public AdminNoticeCommentList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminNoticeCommentList(ArrayList<NoticeComment> list, String pageNavi) {
		super();
		this.list = list;
		this.pageNavi = pageNavi;
	}

	public ArrayList<NoticeComment> getList() {
		return list;
	}

	public void setList(ArrayList<NoticeComment> list) {
		this.list = list;
	}

	public String getPageNavi() {
		return pageNavi;
	}

	public void setPageNavi(String pageNavi) {
		this.pageNavi = pageNavi;
	}

}
