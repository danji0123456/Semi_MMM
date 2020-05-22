package article.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import article.model.vo.ArticleNotice;
import article.model.vo.ArticleNoticeComment;
import article.model.vo.ArticleNoticeCommentNick;
import common.JDBCTemplate;

public class ArticleNoticeDao {
	
	private ArticleNotice setArticleNotice(ResultSet rset, int index) throws SQLException {
		
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
	
	private ArticleNoticeComment setArticleNoticeComment(ResultSet rset, int index) throws SQLException {
		
		return new ArticleNoticeComment(rset.getInt(index++),
				rset.getString(index++),
				rset.getString(index++),
				rset.getDate(index++),
				rset.getInt(index++),
				rset.getInt(index++),
				rset.getInt(index++),
				rset.getInt(index++));
	}

	public int articleWrite(Connection conn, ArticleNotice article) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into article_notice values(article_notice_seq.nextval, ?, ?, ?, ?, ?, sysdate, 0, 0, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			int index = 1;
			pstmt.setString(index++, article.getArticleNoticeCategory1());
			pstmt.setString(index++, article.getArticleNoticeCategory2());
			pstmt.setString(index++, article.getArticleNoticeTitle());
			pstmt.setString(index++, article.getArticleNoticeWriter());
			pstmt.setString(index++, article.getArticleNoticeContent());
			pstmt.setString(index++, article.getArticleNoticeImgName());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<ArticleNotice> articleMore(Connection conn, int start, int end) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ArticleNotice> list = new ArrayList<ArticleNotice>();
		String query = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.* FROM"
				+ " (SELECT ARTICLE_NOTICE_NO, ARTICLE_NOTICE_CATEGORY1, ARTICLE_NOTICE_CATEGORY2, "
				+ "ARTICLE_NOTICE_TITLE, M.MEMBER_NICKNAME, ARTICLE_NOTICE_CONTENT, ARTICLE_NOTICE_DATE, "
				+ "ARTICLE_NOTICE_SOLD_BOOL, ARTICLE_NOTICE_DELETE_BOOL, ARTICLE_NOTICE_IMG_NAME "
				+ "FROM ARTICLE_NOTICE A1"
				+ " JOIN MEMBER M ON (MEMBER_ID = ARTICLE_NOTICE_WRITER)"
				+ " WHERE ARTICLE_NOTICE_DELETE_BOOL = 0"
				+ " ORDER BY ARTICLE_NOTICE_NO DESC) A) "
				+ "WHERE RNUM BETWEEN ? AND ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ArticleNotice arNotice = setArticleNotice(rset, 2);
				list.add(arNotice);
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

	public ArticleNotice articleRead(Connection conn, int articleNoticeNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArticleNotice article = null;
		String query = "select * from article_notice where article_notice_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNoticeNo);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				article = setArticleNotice(rset, 1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return article;
	}

	public String getMemberNickname(Connection conn, String memberId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String memberNickname = "";
		String query = "select member_nickname from member where member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			if (rset.next()) {
				memberNickname = rset.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return memberNickname;
	}

	public int articleModify(Connection conn, ArticleNotice article) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update article_notice set ARTICLE_NOTICE_CATEGORY1=?, ARTICLE_NOTICE_CATEGORY2=?, ARTICLE_NOTICE_TITLE=?,"
				+ "ARTICLE_NOTICE_CONTENT=?, article_notice_sold_bool = ?, ARTICLE_NOTICE_IMG_NAME=? where ARTICLE_NOTICE_NO=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			int index = 1;
			pstmt.setString(index++, article.getArticleNoticeCategory1());
			pstmt.setString(index++, article.getArticleNoticeCategory2());
			pstmt.setString(index++, article.getArticleNoticeTitle());
			pstmt.setString(index++, article.getArticleNoticeContent());
			pstmt.setInt(index++, article.getArticleNoticeSoldBool());
			pstmt.setString(index++, article.getArticleNoticeImgName());
			pstmt.setInt(index++, article.getArticleNoticeNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<ArticleNotice> articleKeywordMore(Connection conn, int start, int end,
			String articleNoticeCategory1, String articleNoticeCategory2, ArrayList<String> strs) {
		
		String query = "SELECT * FROM (SELECT ROWNUM AS RNUM, A.* FROM"
				+ " (SELECT ARTICLE_NOTICE_NO, ARTICLE_NOTICE_CATEGORY1, ARTICLE_NOTICE_CATEGORY2, "
				+ "ARTICLE_NOTICE_TITLE, M.MEMBER_NICKNAME, ARTICLE_NOTICE_CONTENT, ARTICLE_NOTICE_DATE, "
				+ "ARTICLE_NOTICE_SOLD_BOOL, ARTICLE_NOTICE_DELETE_BOOL, ARTICLE_NOTICE_IMG_NAME "
				+ "FROM ARTICLE_NOTICE A1"
				+ " JOIN MEMBER M ON (MEMBER_ID = ARTICLE_NOTICE_WRITER)"
				+ " WHERE ARTICLE_NOTICE_DELETE_BOOL = 0"
				+ " and article_notice_category1=? and  article_notice_category2=? and (";
		for (int i = 0; i < strs.size(); i++) {
			query += "Article_Notice_Content like ? or Article_Notice_Title like ?";
			if (i != strs.size() - 1) {
				query += " or ";
			}
		}
		query += ") ORDER BY ARTICLE_NOTICE_NO DESC) A) ";
		query += "WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ArticleNotice> list = new ArrayList<ArticleNotice>();
		
		try {
			pstmt = conn.prepareStatement(query);
			
			int index = 1;
			pstmt.setString(index++, articleNoticeCategory1);
			pstmt.setString(index++, articleNoticeCategory2);
			
			for (int i = 0; i < strs.size(); i++) {
				pstmt.setString(index++, "%" + strs.get(i) + "%");
				pstmt.setString(index++, "%" + strs.get(i) + "%");
			}
			
			pstmt.setInt(index++, start);
			pstmt.setInt(index++, end);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ArticleNotice arNotice = setArticleNotice(rset, 2);
				list.add(arNotice);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return list;
	}

	public int getTotlaKeywordCount(Connection conn, String articleNoticeCategory1, String articleNoticeCategory2,
			ArrayList<String> strs) {

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from article_notice WHERE ARTICLE_NOTICE_DELETE_BOOL = 0"
				+ " and article_Notice_Category1=? and article_Notice_Category2=? and (";
		
		for (int i = 0; i < strs.size(); i++) {
			query += "Article_Notice_Content like ? or Article_Notice_Title like ?";
			if (i != strs.size() - 1) {
				query += " or ";
			}
		}
		query +=")";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			int index = 1;
			pstmt.setString(index++, articleNoticeCategory1);
			pstmt.setString(index++, articleNoticeCategory2);
			
			for (int i = 0; i < strs.size(); i++) {
				pstmt.setString(index++, "%" + strs.get(i) + "%");
				pstmt.setString(index++, "%" + strs.get(i) + "%");
			}
			
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

	public int articleCommentWrite(Connection conn, ArticleNoticeComment comment) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into article_notice_comment values(article_notice_comment_seq.nextval, ?, ?, sysdate, ?, ?, ?, 0)";
		
		try {
			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, comment.getArticleCommentWriter());
			pstmt.setString(index++, comment.getArticleCommentContent());
			pstmt.setInt(index++, comment.getArticleRef());
			pstmt.setString(index++, comment.getArticleCommentRef() == 0 ? null : String.valueOf(comment.getArticleCommentRef()));
			pstmt.setInt(index++, comment.getArticleCommentLevel());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<ArticleNoticeCommentNick> articleCommentList(Connection conn, int articleNoticeNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ArticleNoticeCommentNick> list = new ArrayList<ArticleNoticeCommentNick>();
		String query = "SELECT MEMBER.MEMBER_NICKNAME AS NICKNAME, A.* " 
				+ "FROM ARTICLE_NOTICE_COMMENT A " 
				+ "JOIN MEMBER ON (MEMBER_ID = ARTICLE_COMMENT_WRITER) " 
				+ "WHERE ARTICLE_REF=? order by article_comment_no asc";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, articleNoticeNo);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				ArticleNoticeCommentNick comment = new ArticleNoticeCommentNick(rset.getString(1), setArticleNoticeComment(rset, 2));
				if (comment.getComment().getArticleCommentDeleteBool() == 1) {
					comment.getComment().setArticleCommentContent("삭제된 댓글입니다.");
					comment.setNickname("");
				}
				list.add(comment);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	public int articleCommentModify(Connection conn, String articleCommentContent, int articleCommentNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update article_notice_comment set article_comment_content = ? where article_comment_no = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, articleCommentContent);
			pstmt.setInt(2, articleCommentNo);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int articleCommentDelete(Connection conn, int articleCommentNo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update article_notice_comment set ARTICLE_COMMENT_DELETE_BOOL = 1 where article_comment_no = ?";
		
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
}
