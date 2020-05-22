package article.model.vo;

public class ArticleNoticeCommentNick {

	String nickname;
	ArticleNoticeComment comment;

	public ArticleNoticeCommentNick() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArticleNoticeCommentNick(String nickname, ArticleNoticeComment comment) {
		super();
		this.nickname = nickname;
		this.comment = comment;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public ArticleNoticeComment getComment() {
		return comment;
	}

	public void setComment(ArticleNoticeComment comment) {
		this.comment = comment;
	}

}
