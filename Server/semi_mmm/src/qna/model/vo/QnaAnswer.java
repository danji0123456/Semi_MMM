package qna.model.vo;

import java.sql.Date;

public class QnaAnswer {
	private int answerNo;
	private int qnaNoticeNo;
	private String answerWriter;
	private Date answerDate;
	private String answerContent;
	private int answerDeleteBool;
	public QnaAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public QnaAnswer(int answerNo, int qnaNoticeNo, String answerWriter, Date answerDate, String answerContent,
			int answerDeleteBool) {
		super();
		this.answerNo = answerNo;
		this.qnaNoticeNo = qnaNoticeNo;
		this.answerWriter = answerWriter;
		this.answerDate = answerDate;
		this.answerContent = answerContent;
		this.answerDeleteBool = answerDeleteBool;
	}
	public int getAnswerNo() {
		return answerNo;
	}
	public void setAnswerNo(int answerNo) {
		this.answerNo = answerNo;
	}
	public int getQnaNoticeNo() {
		return qnaNoticeNo;
	}
	public void setQnaNoticeNo(int qnaNoticeNo) {
		this.qnaNoticeNo = qnaNoticeNo;
	}
	public String getAnswerWriter() {
		return answerWriter;
	}
	public void setAnswerWriter(String answerWriter) {
		this.answerWriter = answerWriter;
	}
	public Date getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(Date answerDate) {
		this.answerDate = answerDate;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public int getAnswerDeleteBool() {
		return answerDeleteBool;
	}
	public void setAnswerDeleteBool(int answerDeleteBool) {
		this.answerDeleteBool = answerDeleteBool;
	}
	
}
