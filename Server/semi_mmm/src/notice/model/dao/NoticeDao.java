package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import common.JDBCTemplate;
import dog.model.vo.Dog;
import notice.model.vo.Notice;
import notice.model.vo.NoticeComment;
import notice.model.vo.NoticeNickname;
import notice.model.vo.dogList;

public class NoticeDao {
	
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
				System.out.println("count 값 : "+result);		
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
	
	
	public ArrayList<Notice> selectLsit(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		String query="select * from notice, member where notice.notice_writer = member.member_id";
		
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("notice_no"));
				n.setNoticeTitle(rset.getString("notice_title"));
				n.setNoticeWriter(rset.getString("member_nickname"));
				n.setNoticeContent(rset.getString("notice_content"));
				n.setNoticeDate(rset.getDate("notice_date"));
				n.setNoticeImgs(rset.getString("notice_imgs"));
				n.setNoticeViewCount(rset.getInt("notice_view_count"));
				n.setDogId(rset.getString("dog_id"));
				n.setNoticeDeleteBool(rset.getInt("notice_delete_bool"));
				list.add(n);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	

	
	
	public ArrayList<Notice> selectList(Connection conn, int start, int end) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		
		
		String query="select * from(select rownum as rnum, n.* from(select notice_no,notice_title,member_nickname,notice_content,notice_date,notice_imgs,notice_view_count,notice_delete_bool from notice join member on(notice.notice_writer = member.member_id)where NOTICE_DELETE_BOOL=0 order by notice_no desc)n)where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, start);
			pstmt.setInt(2, end);

			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("notice_no"));
				n.setNoticeTitle(rset.getString("notice_title"));
				n.setNoticeWriter(rset.getString("member_nickname"));
				n.setNoticeContent(rset.getString("notice_content"));
				n.setNoticeDate(rset.getDate("notice_date"));
				n.setNoticeImgs(rset.getString("notice_imgs"));
				n.setNoticeViewCount(rset.getInt("notice_view_count"));
				n.setNoticeDeleteBool(rset.getInt("notice_delete_bool"));
				list.add(n);
				
				
		
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}


	public int writeNotice(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "insert into notice values(notice_seq.nextval,?,?,?,sysdate,?,0,?,0)";
		
			try {
				pstmt = conn.prepareStatement(query);
				
				int index = 1;
				pstmt.setString(index++, notice.getNoticeTitle());
				pstmt.setString(index++, notice.getNoticeWriter());
				pstmt.setString(index++, notice.getNoticeContent());
				pstmt.setString(index++, notice.getNoticeImgs());
				pstmt.setString(index++, notice.getDogId());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}
		return result;
		
	}
	
	public int noticeUpdate(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE notice SET  NOTICE_title=?, notice_content=?, notice_imgs=? WHERE  notice_no=?";
		
			try {
				pstmt = conn.prepareStatement(query);
				
				int index = 1;
				pstmt.setString(index++, notice.getNoticeTitle());
				pstmt.setString(index++, notice.getNoticeContent());
				pstmt.setString(index++, notice.getNoticeImgs());
				pstmt.setInt(index++, notice.getNoticeNo());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}
		return result;
		
	}


	public Notice selectOneNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Notice n = null;
		
		String query="select * from(select rownum as rnum, n.* from(select member.MEMBER_LEVEL,notice_no,NOTICE_TITLE,NOTICE_WRITER,NOTICE_CONTENT,NOTICE_DATE,NOTICE_IMGS,NOTICE_VIEW_COUNT,NOTICE_DELETE_BOOL,dog.dog_id,member.member_id,member.member_nickname from notice join member on(notice.notice_writer = member.member_id) join dog on (member.member_Id = dog.dog_member_id) order by notice_no desc)n)where notice_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				n = new Notice();
				n.setNoticeNo(rset.getInt("notice_no"));
				n.setNoticeTitle(rset.getString("notice_title"));
				n.setNoticeWriter(rset.getString("member_nickname"));
				n.setNoticeContent(rset.getString("notice_content"));
				n.setNoticeDate(rset.getDate("notice_date"));
				n.setNoticeImgs(rset.getString("notice_imgs"));
				n.setNoticeViewCount(rset.getInt("notice_view_count"));
				n.setDogId(rset.getString("dog_id"));
				n.setNoticeDeleteBool(rset.getInt("notice_delete_bool"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return n;
	}


	public ArrayList<NoticeComment> selectCommentList(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<NoticeComment> list = new ArrayList<NoticeComment>();
		
		String query = "select * from notice_comment where notice_comment_ref=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setInt(1, noticeNo);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				NoticeComment nc = new NoticeComment();
				nc.setNoticeCommentNo(rset.getInt("notice_comment_no"));
				nc.setNoticeCommentContent(rset.getString("notice_comment_content"));
				nc.setNoticeCommentWriter(rset.getString("notice_comment_writer"));
				nc.setNoticeCommentDate(rset.getDate("notice_comment_date"));
				nc.setNoticeCommentLevel(rset.getInt("notice_comment_level"));
				nc.setNoticeCommentRef(rset.getInt("notice_comment_ref"));
				nc.setNoticeCommentRefTwo(rset.getInt("notice_comment_ref_two"));
				nc.setDogId(rset.getString("dog_id"));
				nc.setNoticeCommentBool(rset.getInt("notice_comment_bool"));
				list.add(nc);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return list;
	}


	public int noticeCommentInsert(Connection conn, NoticeComment nc) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into notice_comment values(notice_comment_seq.nextval,?,?,sysdate,?,?,?,?,0)";
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, nc.getNoticeCommentContent());
			pstmt.setString(2, nc.getNoticeCommentWriter());
			pstmt.setInt(3, nc.getNoticeCommentLevel());
			pstmt.setInt(4, nc.getNoticeCommentRef());
			//pstmt.setInt(5, nc.getNoticeCommentRefTwo());
			//null이 들어올 경우를 대비해서 삼항연산자로 표현해서 사용가능.
			pstmt.setString(5, nc.getNoticeCommentRefTwo()==0?null:String.valueOf(nc.getNoticeCommentRefTwo()));
			pstmt.setString(6, nc.getDogId());
			
			
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public Dog noticeDogWrite(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Dog d = new Dog();
		String query = "select * from dog join member on(dog.dog_member_id = member.member_id) where member.member_id=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				d.setDogId(rset.getString("dog_id"));
				d.setDogMemberId(rset.getString("member_nickname"));
				d.setVariety(rset.getString("variety"));
				d.setAge(rset.getInt("age"));
				d.setDogGender(rset.getString("dog_gender"));
				d.setDogImg(rset.getString("dog_img"));
				d.setDogBool(rset.getInt("dog_bool"));
				d.setDogName(rset.getString("dog_name"));

			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return d;
	}


	public int deleteNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="UPDATE notice SET NOTICE_DELETE_BOOL=1 WHERE  notice_no=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public int updateNotice(Connection conn, Notice n) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="update notice set notice_title=?, notice_content=? where notice_no=?";

		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, n.getNoticeTitle());
			pstmt.setString(2, n.getNoticeContent());
			pstmt.setInt(3, n.getNoticeNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public NoticeNickname noticeCommentINickname(Connection conn, String nickName) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		NoticeNickname nn = new NoticeNickname();
		
		String query = "select n.*, m.member_nickname from notice_comment n join member m on(MEMBER_ID = NOTICE_COMMENT_WRITER) where member_nickname =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, nickName);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				nn.setMemberNickname(rset.getString("member_nickname"));
				nn.setNoticeCommentWriter(rset.getString("member_id"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return nn;
	}


	public int noticeCommentUpdate(Connection conn, int noticeCommentNo, int inoticeCommentRef, String noticeCommentContent) {
			PreparedStatement pstmt = null;
			int result = 0;
			String query="update notice_comment set notice_comment_content=? where notice_comment_no=?";
		
			try {
				pstmt = conn.prepareStatement(query);
				
				pstmt.setString(1, noticeCommentContent);
				pstmt.setInt(2, noticeCommentNo);

				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JDBCTemplate.close(pstmt);
			}
			return result;
	}


	public int deleteNoticeCommentNo(Connection conn, int noticeCommentNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query="update notice_comment set NOTICE_COMMENT_BOOL=1 where notice_comment_no=? or notice_comment_ref_two=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeCommentNo);
			pstmt.setInt(2, noticeCommentNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTemplate.close(pstmt);
		}
		return result;
	}


	public Dog noticeDogName(Connection conn, String noticeWriter) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Dog d = new Dog();
		String query = "select * from dog join member on(dog.dog_member_id = member.member_id) where member.member_nickname=?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, noticeWriter);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				d.setDogId(rset.getString("dog_id"));
				d.setDogMemberId(rset.getString("member_nickname"));
				d.setVariety(rset.getString("variety"));
				d.setAge(rset.getInt("age"));
				d.setDogGender(rset.getString("dog_gender"));
				d.setDogImg(rset.getString("dog_img"));
				d.setDogBool(rset.getInt("dog_bool"));
				d.setDogName(rset.getString("dog_name"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return d;
	}


	public int totalCount(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;

		
		String query="select count(*) as cnt from notice where NOTICE_DELETE_BOOL=0 and notice_writer = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = rset.getInt("cnt");
				System.out.println("count 값 : "+result);		
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


	public ArrayList<Notice> selectList(Connection conn, int start, int end, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Notice> list = new ArrayList<Notice>();
		
		
		
		String query="select * from(select rownum as rnum, n.* from(select notice_no,notice_title,member_nickname,notice_content,notice_date,notice_imgs,notice_view_count,notice_delete_bool from notice join member on(notice.notice_writer = member.member_id)where NOTICE_DELETE_BOOL=0 and notice_writer = ? order by notice_no desc)n)where rnum between ? and ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Notice n = new Notice();
				n.setNoticeNo(rset.getInt("notice_no"));
				n.setNoticeTitle(rset.getString("notice_title"));
				n.setNoticeWriter(rset.getString("member_nickname"));
				n.setNoticeContent(rset.getString("notice_content"));
				n.setNoticeDate(rset.getDate("notice_date"));
				n.setNoticeImgs(rset.getString("notice_imgs"));
				n.setNoticeViewCount(rset.getInt("notice_view_count"));
				n.setNoticeDeleteBool(rset.getInt("notice_delete_bool"));
				list.add(n);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}


}
	
	

