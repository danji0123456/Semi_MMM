package admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import admin.model.vo.AdminFnaData;
import admin.model.vo.AdminIndexInfo;
import article.model.vo.ArticleNotice;
import article.model.vo.ArticleNoticeComment;
import common.JDBCTemplate;
import dog.model.vo.Dog;
import fna.model.vo.Fna;
import member.model.vo.Member;
import member.model.vo.Shop;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;
import qna.model.vo.QnaAnswer;
import qna.model.vo.QnaNotice;
import shop.model.vo.Product;
import shop.model.vo.ProductOption;

public class AdminDao {
	
	private Notice setNotice(ResultSet rset, int index) throws SQLException {
		
		return new Notice(rset.getInt(index++), 
				rset.getString(index++),
				rset.getString(index++),
				rset.getString(index++),
				rset.getDate(index++),
				rset.getString(index++),
				rset.getInt(index++),
				rset.getString(index++),
				rset.getInt(index++));
	}
	
	private NoticeComment setNoticeComment(ResultSet rset, int index) throws SQLException {
		
		return new NoticeComment(rset.getInt(index++),
				rset.getString(index++),
				rset.getString(index++),
				rset.getDate(index++),
				rset.getInt(index++),
				rset.getInt(index++),
				rset.getInt(index++),
				rset.getString(index++),
				rset.getInt(index++));
	}

	private QnaNotice setQna(ResultSet rset, int index) throws SQLException {
		
		return new QnaNotice(rset.getInt(index++),
				rset.getString(index++),
				rset.getString(index++),
				rset.getString(index++),
				rset.getDate(index++),
				rset.getString(index++),
				rset.getInt(index++));
	}
	
	private QnaAnswer setQnaAnswer(ResultSet rset, int index) throws SQLException {
		return new QnaAnswer(rset.getInt(index++),
				rset.getInt(index++),
				rset.getString(index++),
				rset.getDate(index++),
				rset.getString(index++),
				rset.getInt(index++));
	}
	
	private ArticleNotice setArticle(ResultSet rset, int index) throws SQLException {
		
		return new ArticleNotice(rset.getInt(index++),
				rset.getString(index++),
				rset.getString(index++),
				rset.getString(index++),
				rset.getString(index++),
				rset.getString(index++),
				rset.getDate(index++),
				rset.getInt(index++),
				rset.getInt(index++),
				rset.getString(index++));
	}

	private ArticleNoticeComment setArticleComment(ResultSet rset, int index) throws SQLException {
		
		return new ArticleNoticeComment(rset.getInt(index++),
				rset.getString(index++),
				rset.getString(index++),
				rset.getDate(index++),
				rset.getInt(index++),
				rset.getInt(index++),
				rset.getInt(index++),
				rset.getInt(index++));
	}

	private Member setMember(ResultSet rset, int index) throws SQLException {
		
		return new Member(rset.getString(index++),
				rset.getString(index++),
				rset.getString(index++),
				rset.getString(index++),
				rset.getDate(index++),
				rset.getString(index++),
				rset.getString(index++),
				rset.getDate(index++),
				rset.getInt(index++),
				rset.getString(index++));
	}
	
	private Dog setDog(ResultSet rset, int index) throws SQLException {
		
		return new Dog(rset.getString(index++),
				rset.getString(index++),
				rset.getString(index++),
				rset.getInt(index++),
				rset.getString(index++),
				rset.getString(index++),
				rset.getInt(index++),
				rset.getString(index++));
	}
	
	public AdminIndexInfo getInfo(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> notice = new ArrayList<Notice>();
		ArrayList<NoticeComment> noticeComment = new ArrayList<NoticeComment>();
		ArrayList<QnaNotice> qna = new ArrayList<QnaNotice>();
		ArrayList<QnaAnswer> qnaAnswer = new ArrayList<QnaAnswer>();
		ArrayList<ArticleNotice> article = new ArrayList<ArticleNotice>();
		ArrayList<ArticleNoticeComment> articleComment = new ArrayList<ArticleNoticeComment>();
		ArrayList<Member> member = new ArrayList<Member>();
		ArrayList<Member> shop = new ArrayList<Member>();
		String query = "select * from (select rownum as rnum, a.* from "
				+ "(select * from notice order by notice_no desc) a) where rnum between 1 and 5";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n = setNotice(rset, 2);
				notice.add(n);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		query = "select * from (select rownum as rnum, a.* from "
				+ "(select * from notice_comment order by notice_comment_no desc) a) where rnum between 1 and 5";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				NoticeComment nc = setNoticeComment(rset, 2);
				noticeComment.add(nc);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		query = "select * from (select rownum as rnum, a.* from "
				+ "(select * from qna_notice order by qna_notice_no desc) a) where rnum between 1 and 5";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				QnaNotice qn = setQna(rset, 2);
				qna.add(qn);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		query = "select * from (select rownum as rnum, a.* from "
				+ "(select * from qna_answer order by answer_no desc) a) where rnum between 1 and 5";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				QnaAnswer qa = setQnaAnswer(rset, 2);
				qnaAnswer.add(qa);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		query = "select * from (select rownum as rnum, a.* from "
				+ "(select * from article_notice order by article_notice_no desc) a) where rnum between 1 and 5";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ArticleNotice ar = setArticle(rset, 2);
				article.add(ar);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		query = "select * from (select rownum as rnum, a.* from "
				+ "(select * from article_notice_comment order by article_comment_no desc) a) where rnum between 1 and 5";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ArticleNoticeComment arc = setArticleComment(rset, 2);
				articleComment.add(arc);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		query = "select * from (select rownum as rnum, a.* from "
				+ "(select * from member where member_level = 1 or member_level = 3 order by enroll_date desc) a) where rnum between 1 and 5";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member m = setMember(rset, 2);
				member.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		query = "select * from (select rownum as rnum, a.* from "
				+ "(select * from member where member_level = 2 or member_level = 4 order by enroll_date desc) a) where rnum between 1 and 5";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member s = setMember(rset, 2);
				shop.add(s);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		AdminIndexInfo info = new AdminIndexInfo(notice, noticeComment, qna, qnaAnswer, article, articleComment, member, shop);
		return info;
	}

	public int articleDelete(Connection conn, int articleNoticeNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update article_notice set article_notice_delete_bool = 1 where article_notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNoticeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int articleRecovery(Connection conn, int articleNoticeNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update article_notice set article_notice_delete_bool = 0 where article_notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNoticeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArticleNoticeComment articleComment(Connection conn, int articleCommentNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		ArticleNoticeComment comment = null;
		String query = "select * from article_notice_comment where article_comment_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleCommentNo);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				comment = setArticleComment(rset, 1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return comment;
	}

	public int articleCommentDelete(Connection conn, int articleCommentNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update article_notice_comment set article_comment_delete_bool = 1 where article_comment_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleCommentNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int articleCommentRecovery(Connection conn, int articleCommentNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update article_notice_comment set article_comment_delete_bool = 0 where article_comment_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleCommentNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Notice noticeRead(Connection conn, int noticeNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice notice = null;
		String query = "select * from notice where notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				notice = setNotice(rset, 1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return notice;
	}

	public int noticeDelete(Connection conn, int noticeNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update notice set notice_delete_bool = 1 where notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int noticeRecovery(Connection conn, int noticeNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update notice set notice_delete_bool = 0 where notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public NoticeComment noticeComment(Connection conn, int noticeCommentNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset =null;
		NoticeComment comment = null;
		String query = "select * from notice_comment where notice_comment_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeCommentNo);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				comment = setNoticeComment(rset, 1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return comment;
	}

	public int noticeCommentRecovery(Connection conn, int noticeCommentNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update notice_comment set NOTICE_COMMENT_BOOL = 0 where NOTICE_COMMENT_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeCommentNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int noticeCommentDelete(Connection conn, int noticeCommentNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update notice_comment set NOTICE_COMMENT_BOOL = 1 where NOTICE_COMMENT_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeCommentNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<ArticleNotice> articleList(Connection conn, int start, int end) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ArticleNotice> list = new ArrayList<ArticleNotice>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from article_notice order by article_notice_no desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ArticleNotice article = setArticle(rset, 2);
				list.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int getArticleTotalCount(Connection conn, String type, String search) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from article_notice where " + type + " like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<ArticleNotice> articleList(Connection conn, int start, int end, String type, String search) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ArticleNotice> list = new ArrayList<ArticleNotice>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from article_notice where " + type + " like ? order by article_notice_no desc) S) where rnum between ? and ?";
//		System.out.println(query);
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ArticleNotice article = setArticle(rset, 2);
				list.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int getArticleCommentTotalCount(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from article_notice_comment";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<ArticleNoticeComment> articleCommentList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ArticleNoticeComment> list = new ArrayList<ArticleNoticeComment>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from article_notice_comment order by article_comment_no desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ArticleNoticeComment comment = setArticleComment(rset, 2);
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int getArticleCommentTotalCount(Connection conn, int articleRef) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from article_notice_comment where article_ref=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleRef);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<ArticleNoticeComment> articleCommentList(Connection conn, int start, int end, int articleRef) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ArticleNoticeComment> list = new ArrayList<ArticleNoticeComment>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from article_notice_comment where article_ref=? order by article_comment_no desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleRef);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ArticleNoticeComment comment = setArticleComment(rset, 2);
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int getArticleCommentTotalCount(Connection conn, String type, String search) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from article_notice_comment where " + type + " like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<ArticleNoticeComment> articleCommentSearchList(Connection conn, int start, int end, String type,
			String search) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ArticleNoticeComment> list = new ArrayList<ArticleNoticeComment>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from article_notice_comment where " + type +" like ? order by article_comment_no desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ArticleNoticeComment comment = setArticleComment(rset, 2);
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Notice> noticeList(Connection conn, int start, int end) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from notice order by notice_no desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice notice = setNotice(rset, 2);
				list.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int getNoticeTotalCount(Connection conn, String type, String search) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from notice where " + type + " like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			rset = pstmt.executeQuery();
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Notice> noticeList(Connection conn, int start, int end, String type, String search) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from notice where " + type + " like ? order by notice_no desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice notice = setNotice(rset, 2);
				list.add(notice);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int getNoticeCommentTotalCount(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from notice_comment";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<NoticeComment> noticeCommentList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<NoticeComment> list = new ArrayList<NoticeComment>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from notice_comment order by notice_comment_no desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				NoticeComment comment = setNoticeComment(rset, 2);
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int getNoticeCommentTotalCount(Connection conn, int noticeCommentRef) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from notice_comment where notice_comment_ref = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeCommentRef);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<NoticeComment> noticeCommentList(Connection conn, int start, int end, int noticeCommentRef) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<NoticeComment> list = new ArrayList<NoticeComment>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from notice_comment where notice_Comment_Ref=? order by notice_comment_no desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeCommentRef);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				NoticeComment comment = setNoticeComment(rset, 2);
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int getNoticeCommentTotalCount(Connection conn, String type, String search) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from notice_comment where " + type + " like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<NoticeComment> noticeCommentList(Connection conn, int start, int end, String type, String search) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<NoticeComment> list = new ArrayList<NoticeComment>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from notice_comment where " + type + " like ? order by notice_comment_no desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				NoticeComment comment = setNoticeComment(rset, 2);
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public QnaNotice qnaNoticeRead(Connection conn, int qnaNoticeNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		QnaNotice qna = null;
		String query = "select * from qna_notice where qna_notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNoticeNo);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				qna = setQna(rset, 1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return qna;
	}

	public int qnaNoticeDelete(Connection conn, int qnaNoticeNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update qna_notice set QNA_NOTICE_DELETE_BOOL = 1 where qna_notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNoticeNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
	
		return result;
	}

	public int qnaNoticeRecovery(Connection conn, int qnaNoticeNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update qna_notice set QNA_NOTICE_DELETE_BOOL = 0 where qna_notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNoticeNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
	
		return result;
	}

	public QnaAnswer qnaAnswer(Connection conn, int answerNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		QnaAnswer answer = null;
		String query = "select * from qna_answer where answer_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, answerNo);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				answer = setQnaAnswer(rset, 1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return answer;
	}

	public int qnaTotalCount(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from qna_notice";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<QnaNotice> qnaList(Connection conn, int start, int end) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<QnaNotice> list = new ArrayList<QnaNotice>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from qna_notice order by QNA_NOTICE_NO desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				QnaNotice qna = setQna(rset, 2);
				list.add(qna);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int qnaTotalCount(Connection conn, String type, String search) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from qna_notice where " + type + " like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<QnaNotice> qnaList(Connection conn, int start, int end, String type, String search) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<QnaNotice> list = new ArrayList<QnaNotice>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from qna_notice where " + type + " like ? order by QNA_NOTICE_NO desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, search);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				QnaNotice qna = setQna(rset, 2);
				list.add(qna);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int qnaAnswerTotalCount(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from qna_answer";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<QnaAnswer> qnaAnswerList(Connection conn, int start, int end) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<QnaAnswer> list = new ArrayList<QnaAnswer>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from qna_answer order by ANSWER_NO desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				QnaAnswer comment = setQnaAnswer(rset, 2);
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int qnaAnswerTotalCount(Connection conn, int qnaNoticeNo) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from qna_answer where qna_notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNoticeNo);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<QnaAnswer> qnaAnswerSearchList(Connection conn, int start, int end, int qnaNoticeNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<QnaAnswer> list = new ArrayList<QnaAnswer>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from qna_answer where qna_notice_no = ? order by ANSWER_NO desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNoticeNo);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				QnaAnswer comment = setQnaAnswer(rset, 2);
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int qnaAnswerTotalCount(Connection conn, String type, String search) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from qna_answer where " + type + " like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<QnaAnswer> qnaAnswerSearchList(Connection conn, int start, int end, String type, String search) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<QnaAnswer> list = new ArrayList<QnaAnswer>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from qna_answer where " + type + " like ? order by ANSWER_NO desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				QnaAnswer comment = setQnaAnswer(rset, 2);
				list.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public ArrayList<AdminFnaData> fnaSelectAll(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select rownum as rnum, f.* from (select * from fna order by qna_no asc) f";
		ArrayList<AdminFnaData> fna = new ArrayList<AdminFnaData>();
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Fna f = new Fna();
				f.setQnaNo(rset.getInt(2));
				f.setQuestion(rset.getString(3));
				f.setAnswer(rset.getString(4));
				fna.add(new AdminFnaData(f, rset.getInt(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return fna;
	}

	public Fna fnaSelectAll(Connection conn, int qnaNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select * from fna where qna_no = ?";
		Fna fna = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNo);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				fna = new Fna(rset.getInt(1), rset.getString(2), rset.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return fna;
	}

	public int adminFnaDelete(Connection conn, int qnaNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from fna where qna_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int adminFnaModify(Connection conn, Fna fna) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update fna set question=?, answer=? where qna_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, fna.getQuestion());
			pstmt.setString(index++, fna.getAnswer());
			pstmt.setInt(index++, fna.getQnaNo());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int adminFnaInsert(Connection conn, Fna fna) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into fna values(fna_seq.nextval, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, fna.getQuestion());
			pstmt.setString(index++, fna.getAnswer());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public Member getMember(Connection conn, String memberId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		String query = "select * from member where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				member = setMember(rset, 1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return member;
	}

	public ArrayList<Dog> getDogs(Connection conn, String memberId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Dog> dogs = new ArrayList<Dog>();
		String query = "select * from dog where dog_member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Dog dog = setDog(rset, 1);
				dogs.add(dog);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return dogs;
	}

	public int adminMemberLevelUpdate(Connection conn, String memberId, int memberLevel) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member set member_level = ? where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, memberLevel);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int userTotal(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from member where member_level = 1 or member_level = 3";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Member> userList(Connection conn, int start, int end) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from member where member_level = 1 or member_level = 3 order by ENROLL_DATE desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = setMember(rset, 2);
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int userTotal(Connection conn, String type, String search) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from member where (member_level = 1 or member_level = 3) and " + type + " like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Member> userList(Connection conn, int start, int end, String type, String search) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from member where (member_level = 1 or member_level = 3) and " + type + " like ? order by ENROLL_DATE desc) S) where rnum between ? and ?";
				
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = setMember(rset, 2);
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int getTotalCount(Connection conn) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from article_notice WHERE ARTICLE_NOTICE_DELETE_BOOL = 0";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int totalCount(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		String query="select count(*) as cnt from notice where NOTICE_DELETE_BOOL=0";
		try {
			pstmt = conn.prepareStatement(query);

			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("cnt");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int shopTotal(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from member where member_level = 2 or member_level = 4";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Member> shopList(Connection conn, int start, int end) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from member where member_level = 2 or member_level = 4 order by ENROLL_DATE desc) S) where rnum between ? and ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = setMember(rset, 2);
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int shopTotal(Connection conn, String type, String search) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from member where (member_level = 2 or member_level = 4) and " + type + " like ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				result = rset.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Member> shopList(Connection conn, int start, int end, String type, String search) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from (select rownum as rnum, s.* from "
				+ "(select * from member where (member_level = 2 or member_level = 4) and " + type + " like ? order by ENROLL_DATE desc) S) where rnum between ? and ?";
				
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Member member = setMember(rset, 2);
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public ArrayList<Product> getProducts(Connection conn, String memberId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		String query = "select * from product where bn_member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				Product p = new Product(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getString(5));
				list.add(p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
		
	}

	public ArrayList<ProductOption> getOptions(Connection conn, int productNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProductOption> options = new ArrayList<ProductOption>();
		String query = "select * from product_option where product_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productNo);
			rset = pstmt.executeQuery();
			
			while (rset.next()) {
				ProductOption option = new ProductOption(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getString(4), rset.getInt(5));
				options.add(option);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return options;
	}

	public Shop getShop(Connection conn, String memberId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Shop shop = null;
		String query = "select * from shop where shop_member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				shop = new Shop(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return shop;
	}
}
