package article.model.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.StringTokenizer;

import article.model.dao.ArticleNoticeDao;
import article.model.vo.ArticleNotice;
import article.model.vo.ArticleNoticeComment;
import article.model.vo.ArticleNoticeCommentNick;
import common.JDBCTemplate;

public class ArticleNoticeService {

	public int articleWrite(ArticleNotice article) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ArticleNoticeDao().articleWrite(conn, article);
		
		if (result > 0) { 
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public ArrayList<ArticleNotice> articleMore(int start) {
		
		Connection conn = JDBCTemplate.getConnection();
		int length = 5;
		int end = start + length - 1;
		
		ArrayList<ArticleNotice> list = new ArticleNoticeDao().articleMore(conn, start, end);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public int getTotalCount() {
		
		Connection conn = JDBCTemplate.getConnection();
		int totalCount = new ArticleNoticeDao().getTotalCount(conn);
		
		JDBCTemplate.close(conn);
		
		return totalCount;
	}

	public ArticleNotice articleRead(int articleNoticeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArticleNotice article = new ArticleNoticeDao().articleRead(conn, articleNoticeNo);
		
		JDBCTemplate.close(conn);
		
		return article;
	}
	
	public String getMemberNickname(String memberId) {
		
		Connection conn = JDBCTemplate.getConnection();
		String memberNickname = new ArticleNoticeDao().getMemberNickname(conn, memberId);
		
		JDBCTemplate.close(conn);
		
		return memberNickname;
	}

	public int articleModify(ArticleNotice article) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ArticleNoticeDao().articleModify(conn, article);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public ArrayList<ArticleNotice> articleKeywordMore(int start, String articleNoticeCategory1,
			String articleNoticeCategory2, String search) {
		
		ArrayList<String> strs = new ArrayList<String>();
		StringTokenizer sT = new StringTokenizer(search, " ");
		while(sT.hasMoreTokens()) {
			strs.add(sT.nextToken());
		}

		int length = 5;
		int end = start + length - 1;
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<ArticleNotice> list = new ArticleNoticeDao().articleKeywordMore(conn, start, end, articleNoticeCategory1, articleNoticeCategory2, strs);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public int getTotlaKeywordCount(String articleNoticeCategory1, String articleNoticeCategory2, String search) {

		ArrayList<String> strs = new ArrayList<String>();
		StringTokenizer sT = new StringTokenizer(search, " ");
		while(sT.hasMoreTokens()) {
			strs.add(sT.nextToken());
		}
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ArticleNoticeDao().getTotlaKeywordCount(conn, articleNoticeCategory1, articleNoticeCategory2, strs);
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int articleDelete(int articleNoticeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ArticleNoticeDao().articleDelete(conn, articleNoticeNo);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int articleCommentWrite(ArticleNoticeComment comment) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ArticleNoticeDao().articleCommentWrite(conn, comment);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public ArrayList<ArticleNoticeCommentNick> articleCommentList(int articleNoticeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<ArticleNoticeCommentNick> list = new ArticleNoticeDao().articleCommentList(conn, articleNoticeNo);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public int articleCommentModify(String articleCommentContent, int articleCommentNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ArticleNoticeDao().articleCommentModify(conn, articleCommentContent, articleCommentNo);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int articleCommentDelete(int articleCommentNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new ArticleNoticeDao().articleCommentDelete(conn, articleCommentNo);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

}
