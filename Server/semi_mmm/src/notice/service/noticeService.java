package notice.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import dog.model.vo.Dog;
import member.model.dao.MemberDao;
import notice.model.dao.NoticeDao;
import notice.model.vo.NoticePageData;
import notice.model.vo.NoticePageDataImge;
import notice.model.vo.dogList;
import notice.model.vo.noticeViewData;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;
import notice.model.vo.NoticeNickname;


public class noticeService {

	
	public NoticePageDataImge selectList(int reqPage) {
		Connection conn = JDBCTemplate.getConnection();
		
		int numPerPage = 6;// 한페이지당 게시물 수
		System.out.println(numPerPage);
		//총 게시물 수를 구하는 dao 호출
		int totalCount = new NoticeDao().totalCount(conn);
		System.out.println("토탈 카운터 : "+totalCount);
		//총페이지 수를 연산
		int totalPage = 0;
		// 10, 72 -> 8개
		// 10, 85 -> 9개
		
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage+1;
		}
		
		//조회해 올 게시물 시작번호와 끝번호연산
		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage;
		//해당페이지에 게시물들 조회
		ArrayList<Notice> list = new NoticeDao().selectList(conn, start, end);

		
		//페이지 네비게이션 작성시작
		String pageNavi = "";
		//페이지 네비게이션 길이
		int pageNaviSize = 5; 
		int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
		
		if(pageNo != 1) {
			pageNavi += "<a class='btn' href='/noticeList?reqPage="+(pageNo-pageNaviSize)+"' style=' background-color:#F4F4F4; border-radius: 30px; margin-left: 2px;'>이전</a>";
		}
		for(int i=0; i<pageNaviSize; i++) {
			if(reqPage == pageNo) {
				pageNavi += "<span class='btn' style=' background-color:#76D5FF; border-radius: 30px; margin-left: 2px;'>"+pageNo+"</span>";
			}else {
				pageNavi += "<a class='btn' href='/noticeList?reqPage="+pageNo+"' style=' background-color:#B6EAFA; border-radius: 30px; margin-left: 2px;'>"+pageNo+"</a>";			
				}
			pageNo++;
			if(pageNo>totalPage) {
				break;
			}
		}
		
		if(pageNo <= totalPage) {
			pageNavi += "<a class='btn' href='/noticeList?reqPage="+pageNo+"' style=' background-color:#F4F4F4; border-radius: 30px; margin-left: 2px;'>다음</a>";
		}

		
		NoticePageDataImge pd = new NoticePageDataImge(list, pageNavi);		
		JDBCTemplate.close(conn);
		
		return pd;
	}

	public int noticeWrite(Notice notice) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().writeNotice(conn, notice);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else{
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int noticeUpdate(Notice notice) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new NoticeDao().noticeUpdate(conn, notice);
		
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else{
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public noticeViewData selectOneNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		Notice n = new NoticeDao().selectOneNotice(conn, noticeNo);
		ArrayList<NoticeComment> list = new NoticeDao().selectCommentList(conn,noticeNo);
		
		noticeViewData nvd = new noticeViewData(n, list);
		JDBCTemplate.close(conn);
		return nvd;
	}

	public int noticeCommentInsert(NoticeComment nc) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().noticeCommentInsert(conn,nc);
		
		if(result>0) {	
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Dog noticeDogWrite(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Dog dogList = new NoticeDao().noticeDogWrite(conn, memberId);
		
		JDBCTemplate.close(conn);
		return dogList;
	}

	public int deleteNotice(int noticeNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().deleteNotice(conn,noticeNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateNotice(Notice n) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().updateNotice(conn,n);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public NoticeNickname noticeCommentINickname(String noticeWriter, String nickName) {
		Connection conn = JDBCTemplate.getConnection();
		NoticeNickname nn = new NoticeDao().noticeCommentINickname(conn, nickName);
		
		JDBCTemplate.close(conn);
		return nn;
	}

	public int noticeCommentUpdate(int noticeCommentNo, int inoticeCommentRef, String noticeCommentContent) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().noticeCommentUpdate(conn,noticeCommentNo, inoticeCommentRef, noticeCommentContent);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteNoticeCommentNo(int noticeCommentNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new NoticeDao().deleteNoticeCommentNo(conn,noticeCommentNo);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Dog noticeDogName(String noticeWriter) {
		Connection conn = JDBCTemplate.getConnection();
		Dog dogList = new NoticeDao().noticeDogName(conn, noticeWriter);
		
		JDBCTemplate.close(conn);
		return dogList;
	}

	public NoticePageDataImge selectList(int reqPage, String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		
		int numPerPage = 6;// 한페이지당 게시물 수
		System.out.println(numPerPage);
		//총 게시물 수를 구하는 dao 호출
		int totalCount = new NoticeDao().totalCount(conn,memberId);
		//총페이지 수를 연산
		int totalPage = 0;
		// 10, 72 -> 8개
		// 10, 85 -> 9개
		
		if(totalCount%numPerPage == 0) {
			totalPage = totalCount/numPerPage;
		}else {
			totalPage = totalCount/numPerPage+1;
		}
		
		//조회해 올 게시물 시작번호와 끝번호연산
		int start = (reqPage-1)*numPerPage+1;
		int end = reqPage*numPerPage;
		//해당페이지에 게시물들 조회
		ArrayList<Notice> list = new NoticeDao().selectList(conn, start, end, memberId);

		
		//페이지 네비게이션 작성시작
				String pageNavi = "";
				//페이지 네비게이션 길이
				int pageNaviSize = 5; 
				int pageNo = ((reqPage-1)/pageNaviSize)*pageNaviSize+1;
				
				if(pageNo != 1) {
					pageNavi += "<a class='btn' href='/showMyList?reqPage="+(pageNo-pageNaviSize)+"&memberId="+memberId+"' style=' background-color:#F4F4F4; border-radius: 30px; margin-left: 2px;'>이전</a>";
				}
				for(int i=0; i<pageNaviSize; i++) {
					if(reqPage == pageNo) {
						pageNavi += "<span class='btn' style=' background-color:#76D5FF; border-radius: 30px; margin-left: 2px;'>"+pageNo+"</span>";
					}else {
						pageNavi += "<a class='btn' href='/showMyList?reqPage="+pageNo+"&memberId="+memberId+"' style=' background-color:#B6EAFA; border-radius: 30px; margin-left: 2px;'>"+pageNo+"</a>";			
						}
					pageNo++;
					if(pageNo>totalPage) {
						break;
					}
				}
				
				if(pageNo <= totalPage) {
					pageNavi += "<a class='btn' href='/showMyList?reqPage="+pageNo+"&memberId="+memberId+"' style=' background-color:#F4F4F4; border-radius: 30px; margin-left: 2px;'>다음</a>";
				}

				
				NoticePageDataImge pd = new NoticePageDataImge(list, pageNavi);		
				JDBCTemplate.close(conn);
				
				return pd;
			}

	public int getDogCount(String memberId) {
		
		Connection conn = JDBCTemplate.getConnection();
		int count = new MemberDao().getDogCount(conn, memberId);
		
		JDBCTemplate.close(conn);
		return count;
	}
} 
