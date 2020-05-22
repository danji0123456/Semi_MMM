package article.model.vo;

import java.sql.Date;

public class ArticleNotice {
	private int articleNoticeNo;
	private String articleNoticeCategory1;
	private String articleNoticeCategory2;
	private String articleNoticeTitle;
	private String articleNoticeWriter;
	private String articleNoticeContent;
	private Date articleNoticeDate;
	private int articleNoticeSoldBool;
	private int articleNoticeDeleteBool;
	private String articleNoticeImgName;

	public ArticleNotice(int articleNoticeNo, String articleNoticeCategory1, String articleNoticeCategory2,
			String articleNoticeTitle, String articleNoticeWriter, String articleNoticeContent, Date articleNoticeDate,
			int articleNoticeSoldBool, int articleNoticeDeleteBool, String articleNoticeImgName) {
		super();
		this.articleNoticeNo = articleNoticeNo;
		this.articleNoticeCategory1 = articleNoticeCategory1;
		this.articleNoticeCategory2 = articleNoticeCategory2;
		this.articleNoticeTitle = articleNoticeTitle;
		this.articleNoticeWriter = articleNoticeWriter;
		this.articleNoticeContent = articleNoticeContent;
		this.articleNoticeDate = articleNoticeDate;
		this.articleNoticeSoldBool = articleNoticeSoldBool;
		this.articleNoticeDeleteBool = articleNoticeDeleteBool;
		this.articleNoticeImgName = articleNoticeImgName;
	}

	public ArticleNotice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getArticleNoticeImgName() {
		return articleNoticeImgName;
	}

	public void setArticleNoticeImgName(String articleNoticeImgName) {
		this.articleNoticeImgName = articleNoticeImgName;
	}

	public int getArticleNoticeNo() {
		return articleNoticeNo;
	}

	public void setArticleNoticeNo(int articleNoticeNo) {
		this.articleNoticeNo = articleNoticeNo;
	}

	public String getArticleNoticeCategory1() {
		return articleNoticeCategory1;
	}

	public void setArticleNoticeCategory1(String articleNoticeCategory1) {
		this.articleNoticeCategory1 = articleNoticeCategory1;
	}

	public String getArticleNoticeCategory2() {
		return articleNoticeCategory2;
	}

	public void setArticleNoticeCategory2(String articleNoticeCategory2) {
		this.articleNoticeCategory2 = articleNoticeCategory2;
	}

	public String getArticleNoticeTitle() {
		return articleNoticeTitle;
	}

	public void setArticleNoticeTitle(String articleNoticeTitle) {
		this.articleNoticeTitle = articleNoticeTitle;
	}

	public String getArticleNoticeWriter() {
		return articleNoticeWriter;
	}

	public void setArticleNoticeWriter(String articleNoticeWriter) {
		this.articleNoticeWriter = articleNoticeWriter;
	}

	public String getArticleNoticeContent() {
		return articleNoticeContent;
	}

	public void setArticleNoticeContent(String articleNoticeContent) {
		this.articleNoticeContent = articleNoticeContent;
	}

	public Date getArticleNoticeDate() {
		return articleNoticeDate;
	}

	public void setArticleNoticeDate(Date articleNoticeDate) {
		this.articleNoticeDate = articleNoticeDate;
	}

	public int getArticleNoticeSoldBool() {
		return articleNoticeSoldBool;
	}

	public void setArticleNoticeSoldBool(int articleNoticeSoldBool) {
		this.articleNoticeSoldBool = articleNoticeSoldBool;
	}

	public int getArticleNoticeDeleteBool() {
		return articleNoticeDeleteBool;
	}

	public void setArticleNoticeDeleteBool(int articleNoticeDeleteBool) {
		this.articleNoticeDeleteBool = articleNoticeDeleteBool;
	}

}
