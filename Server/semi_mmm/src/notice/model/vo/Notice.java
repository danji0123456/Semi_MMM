package notice.model.vo;

import java.sql.Date;

public class Notice {
	private int noticeNo;
	private String noticeTitle;
	private String noticeWriter;
	private String noticeContent;
	private Date noticeDate;
	private String noticeImgs;
	private int noticeViewCount;
	private String dogId;
	private int noticeDeleteBool;
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notice(int noticeNo, String noticeTitle, String noticeWriter, String noticeContent, Date noticeDate,
			String noticeImgs, int noticeViewCount, String dogId, int noticeDeleteBool) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeWriter = noticeWriter;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeImgs = noticeImgs;
		this.noticeViewCount = noticeViewCount;
		this.dogId = dogId;
		this.noticeDeleteBool = noticeDeleteBool;
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeWriter() {
		return noticeWriter;
	}
	public void setNoticeWriter(String noticeWriter) {
		this.noticeWriter = noticeWriter;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public Date getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNoticeImgs() {
		return noticeImgs;
	}
	public void setNoticeImgs(String noticeImgs) {
		this.noticeImgs = noticeImgs;
	}
	public int getNoticeViewCount() {
		return noticeViewCount;
	}
	public void setNoticeViewCount(int noticeViewCount) {
		this.noticeViewCount = noticeViewCount;
	}
	public String getDogId() {
		return dogId;
	}
	public void setDogId(String dogId) {
		this.dogId = dogId;
	}
	public int getNoticeDeleteBool() {
		return noticeDeleteBool;
	}
	public void setNoticeDeleteBool(int noticeDeleteBool) {
		this.noticeDeleteBool = noticeDeleteBool;
	}
	
}
