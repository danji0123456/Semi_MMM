package article.model.vo;

import java.sql.Date;

public class ArticleNoticeComment {
	
	private int articleCommentNo;
	private String articleCommentWriter;
	private String articleCommentContent;
	private Date articleCommentDate;
	private int articleRef;
	private int articleCommentRef;
	private int articleCommentLevel;
	private int articleCommentDeleteBool;
	
	public String getContentBr() {
		return articleCommentContent.replaceAll("\r\n", "<br>");
	}
	
	public ArticleNoticeComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticleNoticeComment(int articleCommentNo, String articleCommentWriter, String articleCommentContent,
			Date articleCommentDate, int articleRef, int articleCommentRef, int articleCommentLevel,
			int articleCommentDeleteBool) {
		super();
		this.articleCommentNo = articleCommentNo;
		this.articleCommentWriter = articleCommentWriter;
		this.articleCommentContent = articleCommentContent;
		this.articleCommentDate = articleCommentDate;
		this.articleRef = articleRef;
		this.articleCommentRef = articleCommentRef;
		this.articleCommentLevel = articleCommentLevel;
		this.articleCommentDeleteBool = articleCommentDeleteBool;
	}

	public int getArticleCommentNo() {
		return articleCommentNo;
	}

	public void setArticleCommentNo(int articleCommentNo) {
		this.articleCommentNo = articleCommentNo;
	}

	public String getArticleCommentWriter() {
		return articleCommentWriter;
	}

	public void setArticleCommentWriter(String articleCommentWriter) {
		this.articleCommentWriter = articleCommentWriter;
	}

	public String getArticleCommentContent() {
		return articleCommentContent;
	}

	public void setArticleCommentContent(String articleCommentContent) {
		this.articleCommentContent = articleCommentContent;
	}

	public Date getArticleCommentDate() {
		return articleCommentDate;
	}

	public void setArticleCommentDate(Date articleCommentDate) {
		this.articleCommentDate = articleCommentDate;
	}

	public int getArticleRef() {
		return articleRef;
	}

	public void setArticleRef(int articleRef) {
		this.articleRef = articleRef;
	}

	public int getArticleCommentRef() {
		return articleCommentRef;
	}

	public void setArticleCommentRef(int articleCommentRef) {
		this.articleCommentRef = articleCommentRef;
	}

	public int getArticleCommentLevel() {
		return articleCommentLevel;
	}

	public void setArticleCommentLevel(int articleCommentLevel) {
		this.articleCommentLevel = articleCommentLevel;
	}

	public int getArticleCommentDeleteBool() {
		return articleCommentDeleteBool;
	}

	public void setArticleCommentDeleteBool(int articleCommentDeleteBool) {
		this.articleCommentDeleteBool = articleCommentDeleteBool;
	}
	
}
