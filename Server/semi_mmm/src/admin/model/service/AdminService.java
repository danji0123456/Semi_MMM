package admin.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import admin.model.dao.AdminDao;
import admin.model.vo.AdminArticleCommentList;
import admin.model.vo.AdminArticleList;
import admin.model.vo.AdminIndexInfo;
import admin.model.vo.AdminNoticeCommentList;
import admin.model.vo.AdminNoticeList;
import article.model.dao.ArticleNoticeDao;
import article.model.vo.ArticleNotice;
import article.model.vo.ArticleNoticeComment;
import common.JDBCTemplate;
import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;

public class AdminService {

	public AdminIndexInfo getInfo() {
		
		Connection conn = JDBCTemplate.getConnection();
		AdminIndexInfo info = new AdminDao().getInfo(conn);
		
		JDBCTemplate.close(conn);
		
		return info;
	}

	public int articleDelete(int articleNoticeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new AdminDao().articleDelete(conn, articleNoticeNo);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int articleRecovery(int articleNoticeNo) {

		Connection conn = JDBCTemplate.getConnection();
		int result = new AdminDao().articleRecovery(conn, articleNoticeNo);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public ArticleNoticeComment articleComment(int articleCommentNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		ArticleNoticeComment comment = new AdminDao().articleComment(conn, articleCommentNo);
		
		JDBCTemplate.close(conn);
		
		return comment;
	}

	public int articleCommentDelete(int articleCommentNo) {

		Connection conn = JDBCTemplate.getConnection();
		int result = new AdminDao().articleCommentDelete(conn, articleCommentNo);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int articleCommentRecovery(int articleCommentNo) {

		Connection conn = JDBCTemplate.getConnection();
		int result = new AdminDao().articleCommentRecovery(conn, articleCommentNo);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public Notice noticeRead(int noticeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		Notice notice = new AdminDao().noticeRead(conn, noticeNo);
		
		JDBCTemplate.close(conn);
		
		return notice;
	}

	public int noticeDelete(int noticeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new AdminDao().noticeDelete(conn, noticeNo);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int noticeRecovery(int noticeNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new AdminDao().noticeRecovery(conn, noticeNo);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public NoticeComment noticeComment(int noticeCommentNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		NoticeComment comment = new AdminDao().noticeComment(conn, noticeCommentNo);
		
		JDBCTemplate.close(conn);
		
		return comment;
	}

	public int noticeCommentRecovery(int noticeCommentNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new AdminDao().noticeCommentRecovery(conn, noticeCommentNo);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int noticeCommentDelete(int noticeCommentNo) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new AdminDao().noticeCommentDelete(conn, noticeCommentNo);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public AdminArticleList articleList(int reqPage) {
		
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;	//한페이지당 게시물 수
		int totalCount = new ArticleNoticeDao().getTotalCount(conn);
		int totalPage = 0;
		
		//총 페이지수를 연산
		if (totalCount % numPerPage == 0 ) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}
		
		//조회해 올 게시물의 첫번호(start)와 끝번호(end)연산
		int start = (reqPage - 1) * numPerPage + 1;
		int end = reqPage * numPerPage;
		
		//해당 페이지의 게시물들 조회
		ArrayList<ArticleNotice> list = new AdminDao().articleList(conn, start, end);
		
		//페이지 네비게이션 제작
		StringBuffer pageNavi = new StringBuffer("");
		
		int pageNaviSize = 10;
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;
		
		if (pageNo != 1) {
			pageNavi.append("<a class='btn' href='/adminArticleNoticeList?reqPage="+ (pageNo - pageNaviSize) + "'>이전</a>");
		}
		
		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {
				pageNavi.append("<span class='selectPage'>" + pageNo + "</span>");
			} else {
				pageNavi.append("<a class='btn' href='/adminArticleNoticeList?reqPage=" + pageNo + "'>" + pageNo + "</a>");
			}

			pageNo++;
			
			if (pageNo > totalPage) {
				break;
			}
		}
		
		if (pageNo <= totalPage) {
			pageNavi.append("<a class='btn' href='/adminArticleNoticeList?reqPage=" + pageNo + "'>다음</a>");
		}
		
		AdminArticleList data = new AdminArticleList(list, pageNavi.toString());
		
		JDBCTemplate.close(conn);
		
		return data;
	}

	public AdminArticleList articleSearchList(int reqPage, String type, String search) {
		
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;	//한페이지당 게시물 수
		int totalCount = new AdminDao().getArticleTotalCount(conn, type, search);
		int totalPage = 0;
		
		//총 페이지수를 연산
		if (totalCount % numPerPage == 0 ) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}
		
		//조회해 올 게시물의 첫번호(start)와 끝번호(end)연산
		int start = (reqPage - 1) * numPerPage + 1;
		int end = reqPage * numPerPage;
		
		//해당 페이지의 게시물들 조회
		ArrayList<ArticleNotice> list = new AdminDao().articleList(conn, start, end, type, search);
		
		//페이지 네비게이션 제작
		StringBuffer pageNavi = new StringBuffer("");
		
		int pageNaviSize = 10;
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;
		
		if (pageNo != 1) {
			pageNavi.append("<a class='btn' href='/adminArticleNoticeList?reqPage="+ (pageNo - pageNaviSize) + "&type=" + type + "&search=" + search + "'>이전</a>");
		}
		
		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {
				pageNavi.append("<span class='selectPage'>" + pageNo + "</span>");
			} else {
				pageNavi.append("<a class='btn' href='/adminArticleNoticeList?reqPage=" + pageNo + "&type=" + type + "&search=" + search + "'>" + pageNo + "</a>");
			}

			pageNo++;
			
			if (pageNo > totalPage) {
				break;
			}
		}
		
		if (pageNo <= totalPage) {
			pageNavi.append("<a class='btn' href='/adminArticleNoticeList?reqPage=" + pageNo + "&type=" + type + "&search=" + search + "'>다음</a>");
		}
		
		AdminArticleList data = new AdminArticleList(list, pageNavi.toString());
		
		JDBCTemplate.close(conn);
		
		return data;
	}

	public AdminArticleCommentList articleCommentList(int reqPage) {
		
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;	//한페이지당 게시물 수
		int totalCount = new AdminDao().getArticleCommentTotalCount(conn);
		int totalPage = 0;
		
		//총 페이지수를 연산
		if (totalCount % numPerPage == 0 ) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}
		
		//조회해 올 게시물의 첫번호(start)와 끝번호(end)연산
		int start = (reqPage - 1) * numPerPage + 1;
		int end = reqPage * numPerPage;
		
		//해당 페이지의 게시물들 조회
		ArrayList<ArticleNoticeComment> list = new AdminDao().articleCommentList(conn, start, end);
		
		//페이지 네비게이션 제작
		StringBuffer pageNavi = new StringBuffer("");
		
		int pageNaviSize = 10;
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;
		
		if (pageNo != 1) {
			pageNavi.append("<a class='btn' href='/adminArticleCommentList?reqPage="+ (pageNo - pageNaviSize) + "'>이전</a>");
		}
		
		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {
				pageNavi.append("<span class='selectPage'>" + pageNo + "</span>");
			} else {
				pageNavi.append("<a class='btn' href='/adminArticleCommentList?reqPage=" + pageNo + "'>" + pageNo + "</a>");
			}

			pageNo++;
			
			if (pageNo > totalPage) {
				break;
			}
		}
		
		if (pageNo <= totalPage) {
			pageNavi.append("<a class='btn' href='/adminArticleCommentList?reqPage=" + pageNo + "'>다음</a>");
		}
		
		AdminArticleCommentList data = new AdminArticleCommentList(list, pageNavi.toString());
		
		JDBCTemplate.close(conn);
		
		return data;
	}

	public AdminArticleCommentList articleCommentSearchList(int reqPage, int articleRef) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;	//한페이지당 게시물 수
		int totalCount = new AdminDao().getArticleCommentTotalCount(conn, articleRef);
		int totalPage = 0;
		
		//총 페이지수를 연산
		if (totalCount % numPerPage == 0 ) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}
		
		//조회해 올 게시물의 첫번호(start)와 끝번호(end)연산
		int start = (reqPage - 1) * numPerPage + 1;
		int end = reqPage * numPerPage;
		
		//해당 페이지의 게시물들 조회
		ArrayList<ArticleNoticeComment> list = new AdminDao().articleCommentList(conn, start, end, articleRef);
		
		//페이지 네비게이션 제작
		StringBuffer pageNavi = new StringBuffer("");
		
		int pageNaviSize = 10;
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;
		
		if (pageNo != 1) {
			pageNavi.append("<a class='btn' href='/adminArticleCommentList?reqPage="+ (pageNo - pageNaviSize) + "&type=article_ref&search=" + articleRef + "'>이전</a>");
		}
		
		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {
				pageNavi.append("<span class='selectPage'>" + pageNo + "</span>");
			} else {
				pageNavi.append("<a class='btn' href='/adminArticleCommentList?reqPage=" + pageNo + "&type=article_ref&search=" + articleRef + "'>" + pageNo + "</a>");
			}

			pageNo++;
			
			if (pageNo > totalPage) {
				break;
			}
		}
		
		if (pageNo <= totalPage) {
			pageNavi.append("<a class='btn' href='/adminArticleCommentList?reqPage=" + pageNo + "&type=article_ref&search=" + articleRef + "'>다음</a>");
		}
		
		AdminArticleCommentList data = new AdminArticleCommentList(list, pageNavi.toString());
		
		JDBCTemplate.close(conn);
		
		return data;
	}

	public AdminArticleCommentList articleCommentSearchList(int reqPage, String type, String search) {
		
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;	//한페이지당 게시물 수
		int totalCount = new AdminDao().getArticleCommentTotalCount(conn, type, search);
		int totalPage = 0;
		
		//총 페이지수를 연산
		if (totalCount % numPerPage == 0 ) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}
		
		//조회해 올 게시물의 첫번호(start)와 끝번호(end)연산
		int start = (reqPage - 1) * numPerPage + 1;
		int end = reqPage * numPerPage;
		
		//해당 페이지의 게시물들 조회
		ArrayList<ArticleNoticeComment> list = new AdminDao().articleCommentSearchList(conn, start, end, type, search);
		
		//페이지 네비게이션 제작
		StringBuffer pageNavi = new StringBuffer("");
		
		int pageNaviSize = 10;
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;
		
		if (pageNo != 1) {
			pageNavi.append("<a class='btn' href='/adminArticleCommentList?reqPage="+ (pageNo - pageNaviSize) + "&type=" + type + "&search=" + search + "'>이전</a>");
		}
		
		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {
				pageNavi.append("<span class='selectPage'>" + pageNo + "</span>");
			} else {
				pageNavi.append("<a class='btn' href='/adminArticleCommentList?reqPage=" + pageNo + "&type=" + type + "&search=" + search + "'>" + pageNo + "</a>");
			}

			pageNo++;
			
			if (pageNo > totalPage) {
				break;
			}
		}
		
		if (pageNo <= totalPage) {
			pageNavi.append("<a class='btn' href='/adminArticleCommentList?reqPage=" + pageNo + "&type=" + type + "&search=" + search + "'>다음</a>");
		}
		
		AdminArticleCommentList data = new AdminArticleCommentList(list, pageNavi.toString());
		
		JDBCTemplate.close(conn);
		
		return data;
	}

	public AdminNoticeList noticeList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;	//한페이지당 게시물 수
		int totalCount = new NoticeDao().totalCount(conn);
		int totalPage = 0;
		
		//총 페이지수를 연산
		if (totalCount % numPerPage == 0 ) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}
		
		//조회해 올 게시물의 첫번호(start)와 끝번호(end)연산
		int start = (reqPage - 1) * numPerPage + 1;
		int end = reqPage * numPerPage;
		
		//해당 페이지의 게시물들 조회
		ArrayList<Notice> list = new AdminDao().noticeList(conn, start, end);
		
		//페이지 네비게이션 제작
		StringBuffer pageNavi = new StringBuffer("");
		
		int pageNaviSize = 10;
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;
		
		if (pageNo != 1) {
			pageNavi.append("<a class='btn' href='/adminNoticeList?reqPage="+ (pageNo - pageNaviSize) + "'>이전</a>");
		}
		
		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {
				pageNavi.append("<span class='selectPage'>" + pageNo + "</span>");
			} else {
				pageNavi.append("<a class='btn' href='/adminNoticeList?reqPage=" + pageNo + "'>" + pageNo + "</a>");
			}

			pageNo++;
			
			if (pageNo > totalPage) {
				break;
			}
		}
		
		if (pageNo <= totalPage) {
			pageNavi.append("<a class='btn' href='/adminNoticeList?reqPage=" + pageNo + "'>다음</a>");
		}
		
		AdminNoticeList data = new AdminNoticeList(list, pageNavi.toString());
		
		JDBCTemplate.close(conn);
		
		return data;
	}

	public AdminNoticeList noticeList(int reqPage, String type, String search) {
		
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;	//한페이지당 게시물 수
		int totalCount = new AdminDao().getNoticeTotalCount(conn, type, search);
		int totalPage = 0;
		
		//총 페이지수를 연산
		if (totalCount % numPerPage == 0 ) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}
		
		//조회해 올 게시물의 첫번호(start)와 끝번호(end)연산
		int start = (reqPage - 1) * numPerPage + 1;
		int end = reqPage * numPerPage;
		
		//해당 페이지의 게시물들 조회
		ArrayList<Notice> list = new AdminDao().noticeList(conn, start, end, type, search);
		
		//페이지 네비게이션 제작
		StringBuffer pageNavi = new StringBuffer("");
		
		int pageNaviSize = 10;
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;
		
		if (pageNo != 1) {
			pageNavi.append("<a class='btn' href='/adminNoticeList?reqPage="+ (pageNo - pageNaviSize) + "&type=" + type + "&search=" + search + "'>이전</a>");
		}
		
		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {
				pageNavi.append("<span class='selectPage'>" + pageNo + "</span>");
			} else {
				pageNavi.append("<a class='btn' href='/adminNoticeList?reqPage=" + pageNo + "&type=" + type + "&search=" + search + "'>" + pageNo + "</a>");
			}

			pageNo++;
			
			if (pageNo > totalPage) {
				break;
			}
		}
		
		if (pageNo <= totalPage) {
			pageNavi.append("<a class='btn' href='/adminNoticeList?reqPage=" + pageNo + "&type=" + type + "&search=" + search + "'>다음</a>");
		}
		
		AdminNoticeList data = new AdminNoticeList(list, pageNavi.toString());
		
		JDBCTemplate.close(conn);
		
		return data;
	}

	public AdminNoticeCommentList noticeCommentList(int reqPage) {

		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;	//한페이지당 게시물 수
		int totalCount = new AdminDao().getNoticeCommentTotalCount(conn);
		int totalPage = 0;
		
		//총 페이지수를 연산
		if (totalCount % numPerPage == 0 ) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}
		
		//조회해 올 게시물의 첫번호(start)와 끝번호(end)연산
		int start = (reqPage - 1) * numPerPage + 1;
		int end = reqPage * numPerPage;
		
		//해당 페이지의 게시물들 조회
		ArrayList<NoticeComment> list = new AdminDao().noticeCommentList(conn, start, end);
		
		//페이지 네비게이션 제작
		StringBuffer pageNavi = new StringBuffer("");
		
		int pageNaviSize = 10;
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;
		
		if (pageNo != 1) {
			pageNavi.append("<a class='btn' href='/adminCommentList?reqPage="+ (pageNo - pageNaviSize) + "'>이전</a>");
		}
		
		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {
				pageNavi.append("<span class='selectPage'>" + pageNo + "</span>");
			} else {
				pageNavi.append("<a class='btn' href='/adminCommentList?reqPage=" + pageNo + "'>" + pageNo + "</a>");
			}

			pageNo++;
			
			if (pageNo > totalPage) {
				break;
			}
		}
		
		if (pageNo <= totalPage) {
			pageNavi.append("<a class='btn' href='/adminCommentList?reqPage=" + pageNo + "'>다음</a>");
		}
		
		AdminNoticeCommentList data = new AdminNoticeCommentList(list, pageNavi.toString());
		
		JDBCTemplate.close(conn);
		
		return data;
	}

	public AdminNoticeCommentList noticeCommentSearchList(int reqPage, int noticeCommentRef) {
		
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;	//한페이지당 게시물 수
		int totalCount = new AdminDao().getNoticeCommentTotalCount(conn, noticeCommentRef);
		int totalPage = 0;
		
		//총 페이지수를 연산
		if (totalCount % numPerPage == 0 ) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}
		
		//조회해 올 게시물의 첫번호(start)와 끝번호(end)연산
		int start = (reqPage - 1) * numPerPage + 1;
		int end = reqPage * numPerPage;
		
		//해당 페이지의 게시물들 조회
		ArrayList<NoticeComment> list = new AdminDao().noticeCommentList(conn, start, end, noticeCommentRef);
		
		//페이지 네비게이션 제작
		StringBuffer pageNavi = new StringBuffer("");
		
		int pageNaviSize = 10;
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;
		
		if (pageNo != 1) {
			pageNavi.append("<a class='btn' href='/adminCommentList?reqPage="+ (pageNo - pageNaviSize) + "&type=notice_comment_ref&search=" + noticeCommentRef + "'>이전</a>");
		}
		
		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {
				pageNavi.append("<span class='selectPage'>" + pageNo + "</span>");
			} else {
				pageNavi.append("<a class='btn' href='/adminCommentList?reqPage=" + pageNo + "&type=notice_comment_ref&search=" + noticeCommentRef + "'>" + pageNo + "</a>");
			}

			pageNo++;
			
			if (pageNo > totalPage) {
				break;
			}
		}
		
		if (pageNo <= totalPage) {
			pageNavi.append("<a class='btn' href='/adminCommentList?reqPage=" + pageNo + "&type=notice_comment_ref&search=" + noticeCommentRef + "'>다음</a>");
		}
		
		AdminNoticeCommentList data = new AdminNoticeCommentList(list, pageNavi.toString());
		
		JDBCTemplate.close(conn);
		
		return data;
	}

	public AdminNoticeCommentList noticeCommentSearchList(int reqPage, String type, String search) {
		Connection conn = JDBCTemplate.getConnection();
		int numPerPage = 10;	//한페이지당 게시물 수
		int totalCount = new AdminDao().getNoticeCommentTotalCount(conn, type, search);
		int totalPage = 0;
		
		//총 페이지수를 연산
		if (totalCount % numPerPage == 0 ) {
			totalPage = totalCount / numPerPage;
		} else {
			totalPage = totalCount / numPerPage + 1;
		}
		
		//조회해 올 게시물의 첫번호(start)와 끝번호(end)연산
		int start = (reqPage - 1) * numPerPage + 1;
		int end = reqPage * numPerPage;
		
		//해당 페이지의 게시물들 조회
		ArrayList<NoticeComment> list = new AdminDao().noticeCommentList(conn, start, end, type, search);
		
		//페이지 네비게이션 제작
		StringBuffer pageNavi = new StringBuffer("");
		
		int pageNaviSize = 10;
		int pageNo = ((reqPage - 1) / pageNaviSize) * pageNaviSize + 1;
		
		if (pageNo != 1) {
			pageNavi.append("<a class='btn' href='/adminCommentList?reqPage="+ (pageNo - pageNaviSize) + "&type=" + type + "&search=" + search + "'>이전</a>");
		}
		
		for (int i = 0; i < pageNaviSize; i++) {
			if (reqPage == pageNo) {
				pageNavi.append("<span class='selectPage'>" + pageNo + "</span>");
			} else {
				pageNavi.append("<a class='btn' href='/adminCommentList?reqPage=" + pageNo + "&type=" + type + "&search=" + search + "'>" + pageNo + "</a>");
			}

			pageNo++;
			
			if (pageNo > totalPage) {
				break;
			}
		}
		
		if (pageNo <= totalPage) {
			pageNavi.append("<a class='btn' href='/adminCommentList?reqPage=" + pageNo + "&type=" + type + "&search=" + search + "'>다음</a>");
		}
		
		AdminNoticeCommentList data = new AdminNoticeCommentList(list, pageNavi.toString());
		
		JDBCTemplate.close(conn);
		
		return data;
	}
}
