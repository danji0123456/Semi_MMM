package qna.model.vo;

import java.sql.Date;

public class QnaNotice {
	private int qnaNoticeNo;
	private String qnaNoticeTitle;
	private String qnaNoticeWriter;
	private String  qnaNoticeContent;
	private Date qnaNoticeDate;
	private String qnaNoticeImgs;
	private int qnaNoticeDeleteBool;
	public QnaNotice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnaNotice(int qnaNoticeNo, String qnaNoticeTitle, String qnaNoticeWriter, String qnaNoticeContent,
			Date qnaNoticeDate, String qnaNoticeImgs, int qnaNoticeDeleteBool) {
		super();
		this.qnaNoticeNo = qnaNoticeNo;
		this.qnaNoticeTitle = qnaNoticeTitle;
		this.qnaNoticeWriter = qnaNoticeWriter;
		this.qnaNoticeContent = qnaNoticeContent;
		this.qnaNoticeDate = qnaNoticeDate;
		this.qnaNoticeImgs = qnaNoticeImgs;
		this.qnaNoticeDeleteBool = qnaNoticeDeleteBool;
	}
	public int getQnaNoticeNo() {
		return qnaNoticeNo;
	}
	public void setQnaNoticeNo(int qnaNoticeNo) {
		this.qnaNoticeNo = qnaNoticeNo;
	}
	public String getQnaNoticeTitle() {
		return qnaNoticeTitle;
	}
	public void setQnaNoticeTitle(String qnaNoticeTitle) {
		this.qnaNoticeTitle = qnaNoticeTitle;
	}
	public String getQnaNoticeWriter() {
		return qnaNoticeWriter;
	}
	public void setQnaNoticeWriter(String qnaNoticeWriter) {
		this.qnaNoticeWriter = qnaNoticeWriter;
	}
	public String getQnaNoticeContent() {
		return qnaNoticeContent;
	}
	public void setQnaNoticeContent(String qnaNoticeContent) {
		this.qnaNoticeContent = qnaNoticeContent;
	}
	public Date getQnaNoticeDate() {
		return qnaNoticeDate;
	}
	public void setQnaNoticeDate(Date qnaNoticeDate) {
		this.qnaNoticeDate = qnaNoticeDate;
	}
	public String getQnaNoticeImgs() {
		return qnaNoticeImgs;
	}
	public void setQnaNoticeImgs(String qnaNoticeImgs) {
		this.qnaNoticeImgs = qnaNoticeImgs;
	}
	public int getQnaNoticeDeleteBool() {
		return qnaNoticeDeleteBool;
	}
	public void setQnaNoticeDeleteBool(int qnaNoticeDeleteBool) {
		this.qnaNoticeDeleteBool = qnaNoticeDeleteBool;
	}
	
}
