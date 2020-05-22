package notice.model.vo;

import java.sql.Date;

public class NoticeComment {
	private int noticeCommentNo;
	private String noticeCommentContent;
	private String noticeCommentWriter;
	private Date noticeCommentDate;
	private int noticeCommentLevel;
	private int noticeCommentRef;
	private int noticeCommentRefTwo;
	private String dogId;
	private int noticeCommentBool;
	
	public String getContentBr() {
		return noticeCommentContent.replaceAll("\r\n", "<br>");
	}
	
	public NoticeComment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NoticeComment(int noticeCommentNo, String noticeCommentContent, String noticeCommentWriter,
			Date noticeCommentDate, int noticeCommentLevel, int noticeCommentRef, int noticeCommentRefTwo, String dogId,
			int noticeCommentBool) {
		super();
		this.noticeCommentNo = noticeCommentNo;
		this.noticeCommentContent = noticeCommentContent;
		this.noticeCommentWriter = noticeCommentWriter;
		this.noticeCommentDate = noticeCommentDate;
		this.noticeCommentLevel = noticeCommentLevel;
		this.noticeCommentRef = noticeCommentRef;
		this.noticeCommentRefTwo = noticeCommentRefTwo;
		this.dogId = dogId;
		this.noticeCommentBool = noticeCommentBool;
	}
	public int getNoticeCommentNo() {
		return noticeCommentNo;
	}
	public void setNoticeCommentNo(int noticeCommentNo) {
		this.noticeCommentNo = noticeCommentNo;
	}
	public String getNoticeCommentContent() {
		return noticeCommentContent;
	}
	public void setNoticeCommentContent(String noticeCommentContent) {
		this.noticeCommentContent = noticeCommentContent;
	}
	public String getNoticeCommentWriter() {
		return noticeCommentWriter;
	}
	public void setNoticeCommentWriter(String noticeCommentWriter) {
		this.noticeCommentWriter = noticeCommentWriter;
	}
	public Date getNoticeCommentDate() {
		return noticeCommentDate;
	}
	public void setNoticeCommentDate(Date noticeCommentDate) {
		this.noticeCommentDate = noticeCommentDate;
	}
	public int getNoticeCommentLevel() {
		return noticeCommentLevel;
	}
	public void setNoticeCommentLevel(int noticeCommentLevel) {
		this.noticeCommentLevel = noticeCommentLevel;
	}
	public int getNoticeCommentRef() {
		return noticeCommentRef;
	}
	public void setNoticeCommentRef(int noticeCommentRef) {
		this.noticeCommentRef = noticeCommentRef;
	}
	public int getNoticeCommentRefTwo() {
		return noticeCommentRefTwo;
	}
	public void setNoticeCommentRefTwo(int noticeCommentRefTwo) {
		this.noticeCommentRefTwo = noticeCommentRefTwo;
	}
	public String getDogId() {
		return dogId;
	}
	public void setDogId(String dogId) {
		this.dogId = dogId;
	}
	public int getNoticeCommentBool() {
		return noticeCommentBool;
	}
	public void setNoticeCommentBool(int noticeCommentBool) {
		this.noticeCommentBool = noticeCommentBool;
	}
	
}
