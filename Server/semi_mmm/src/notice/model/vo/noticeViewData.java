package notice.model.vo;

import java.util.ArrayList;

public class noticeViewData {
	private Notice n;
	private ArrayList<NoticeComment> list;
	
	
	
	public noticeViewData(Notice n, ArrayList<NoticeComment> list) {
		super();
		this.n = n;
		this.list = list;
	}
	
	
	public noticeViewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notice getN() {
		return n;
	}
	public void setN(Notice n) {
		this.n = n;
	}
	public ArrayList<NoticeComment> getList() {
		return list;
	}
	public void setList(ArrayList<NoticeComment> list) {
		this.list = list;
	}
	
	
}