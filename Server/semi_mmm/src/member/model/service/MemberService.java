package member.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;
import member.model.vo.Shop;

public class MemberService {
	public Member selectOneMember(String memberId, String memberPw) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().selectOneMember(conn, memberId, memberPw);
		JDBCTemplate.close(conn);
		return m;
	}
	
	public ArrayList<Member> selectMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> m = new MemberDao().selectMember(conn, memberId);
		JDBCTemplate.close(conn);
		return m;
	}

	public boolean selectId(String id) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result = new MemberDao().selectId(conn, id);
		JDBCTemplate.close(conn);
		return result;
	}

	public boolean selectNick(String nick) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result = new MemberDao().selectNick(conn, nick);
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().insertMember(conn, m);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public Member selectOneMember(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().selectOneMember(conn, memberId);
		JDBCTemplate.close(conn);
		return m;
	}
	
	public Member MemberImge(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		Member m = new MemberDao().MemberImge(conn, memberId);
		JDBCTemplate.close(conn);
		return m;
	}

	public int updateMember(Member m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().updateMember(conn, m);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertShop(Shop shop) {
		
		Connection conn = JDBCTemplate.getConnection();
		int result = new MemberDao().insertShop(conn, shop);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		return result;
	}
}
