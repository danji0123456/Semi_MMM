package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;
import member.model.vo.Shop;

public class MemberDao {

	public Member selectOneMember(Connection conn, String memberId, String memberPw) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = null;
		String query = "select * from member where member_id = ? and member_pw = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPw);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberNickname(rset.getString("member_nickname"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberBirth(rset.getDate("member_birth"));
				m.setPhone(rset.getString("phone"));
				m.setAddr(rset.getString("addr"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setMemberLevel(rset.getInt("member_level"));
				m.setProfileImg(rset.getString("profile_img"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public boolean selectId(Connection conn, String id) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select member_id from member";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				if(rset.getString("member_id").equals(id)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return false;
	}

	public boolean selectNick(Connection conn, String nick) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		boolean result = false;
		String query = "select member_nickname from member";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				if(rset.getString("member_nickname").equals(nick)) {
					result = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int insertMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into member values(?,?,?,?,?,?,?,sysdate,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, m.getMemberId());
			pstmt.setString(index++, m.getMemberPw());
			pstmt.setString(index++, m.getMemberNickname());
			pstmt.setString(index++, m.getMemberName());
			pstmt.setDate(index++, m.getMemberBirth());
			pstmt.setString(index++, m.getPhone());
			pstmt.setString(index++, m.getAddr());
			pstmt.setInt(index++, m.getMemberLevel());
			pstmt.setString(index++, m.getProfileImg());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public Member selectOneMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = new Member();
		String query = "select * from member where member_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberNickname(rset.getString("member_nickname"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberBirth(rset.getDate("member_birth"));
				m.setPhone(rset.getString("phone"));
				m.setAddr(rset.getString("addr"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setMemberLevel(rset.getInt("member_level"));
				m.setProfileImg(rset.getString("profile_img"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}
	
	public Member MemberImge(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member m = new Member();
		String query = "select * from member where member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberNickname(rset.getString("member_nickname"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberBirth(rset.getDate("member_birth"));
				m.setPhone(rset.getString("phone"));
				m.setAddr(rset.getString("addr"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setMemberLevel(rset.getInt("member_level"));
				m.setProfileImg(rset.getString("profile_img"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return m;
	}

	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update member set member_pw=?,member_name=?,member_nickname = ?, phone=? ,addr=?, profile_img=? where member_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, m.getMemberPw());
			pstmt.setString(index++, m.getMemberName());
			pstmt.setString(index++, m.getMemberNickname());
			pstmt.setString(index++, m.getPhone());
			pstmt.setString(index++, m.getAddr());
			pstmt.setString(index++, m.getProfileImg());
			pstmt.setString(index++, m.getMemberId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<Member> selectMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		Member m = null;
		
		String query = "select * from member where member_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setMemberNickname(rset.getString("member_nickname"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberBirth(rset.getDate("member_birth"));
				m.setPhone(rset.getString("phone"));
				m.setAddr(rset.getString("addr"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setMemberLevel(rset.getInt("member_level"));
				m.setProfileImg(rset.getString("profile_img"));
				list.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return list;
	}

	public int insertShop(Connection conn, Shop shop) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into shop values(?, ?, ?, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, shop.getShopId());
			pstmt.setString(index++, shop.getShopMemberId());
			pstmt.setString(index++, shop.getShopBank());
			pstmt.setString(index++, shop.getShopBankAccount());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int getDogCount(Connection conn, String memberId) {
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		String query = "select count(*) from dog where dog_member_id = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
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
}
