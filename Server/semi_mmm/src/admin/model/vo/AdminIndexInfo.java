package admin.model.vo;

import java.util.ArrayList;

import article.model.vo.ArticleNotice;
import article.model.vo.ArticleNoticeComment;
import member.model.vo.Member;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;
import qna.model.vo.QnaAnswer;
import qna.model.vo.QnaNotice;

public class AdminIndexInfo {
	ArrayList<Notice> notice;
	ArrayList<NoticeComment> noticeComment;
	ArrayList<QnaNotice> qna;
	ArrayList<QnaAnswer> qnaAnswer;
	ArrayList<ArticleNotice> article;
	ArrayList<ArticleNoticeComment> articleComment;
	ArrayList<Member> member;
	ArrayList<Member> shop;

	public AdminIndexInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminIndexInfo(ArrayList<Notice> notice, ArrayList<NoticeComment> noticeComment, ArrayList<QnaNotice> qna,
			ArrayList<QnaAnswer> qnaAnswer, ArrayList<ArticleNotice> article,
			ArrayList<ArticleNoticeComment> articleComment, ArrayList<Member> member, ArrayList<Member> shop) {
		super();
		this.notice = notice;
		this.noticeComment = noticeComment;
		this.qna = qna;
		this.qnaAnswer = qnaAnswer;
		this.article = article;
		this.articleComment = articleComment;
		this.member = member;
		this.shop = shop;
	}

	public ArrayList<Notice> getNotice() {
		return notice;
	}

	public void setNotice(ArrayList<Notice> notice) {
		this.notice = notice;
	}

	public ArrayList<NoticeComment> getNoticeComment() {
		return noticeComment;
	}

	public void setNoticeComment(ArrayList<NoticeComment> noticeComment) {
		this.noticeComment = noticeComment;
	}

	public ArrayList<QnaNotice> getQna() {
		return qna;
	}

	public void setQna(ArrayList<QnaNotice> qna) {
		this.qna = qna;
	}

	public ArrayList<QnaAnswer> getQnaAnswer() {
		return qnaAnswer;
	}

	public void setQnaAnswer(ArrayList<QnaAnswer> qnaAnswer) {
		this.qnaAnswer = qnaAnswer;
	}

	public ArrayList<ArticleNotice> getArticle() {
		return article;
	}

	public void setArticle(ArrayList<ArticleNotice> article) {
		this.article = article;
	}

	public ArrayList<ArticleNoticeComment> getArticleComment() {
		return articleComment;
	}

	public void setArticleComment(ArrayList<ArticleNoticeComment> articleComment) {
		this.articleComment = articleComment;
	}

	public ArrayList<Member> getMember() {
		return member;
	}

	public void setMember(ArrayList<Member> member) {
		this.member = member;
	}

	public ArrayList<Member> getShop() {
		return shop;
	}

	public void setShop(ArrayList<Member> shop) {
		this.shop = shop;
	}

}
