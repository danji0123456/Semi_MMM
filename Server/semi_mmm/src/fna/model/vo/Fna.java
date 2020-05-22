package fna.model.vo;

public class Fna {
	private int qnaNo;
	private String question;
	private String answer;
	public Fna() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fna(int qnaNo, String question, String answer) {
		super();
		this.qnaNo = qnaNo;
		this.question = question;
		this.answer = answer;
	}
	public int getQnaNo() {
		return qnaNo;
	}
	public void setQnaNo(int qnaNo) {
		this.qnaNo = qnaNo;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
}
