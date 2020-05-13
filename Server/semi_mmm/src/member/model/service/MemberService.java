package member.model.service;

import java.sql.Connection;

import common.JDBCTemplate;
import member.model.dao.MemberDao;
import member.model.vo.Member;

public class MemberService {
	public Member selectOneMember(String memberId, String memberPw) {
		Connection conn = new JDBCTemplate().getConnection();
		Member m = new MemberDao().selectOneMember(conn, memberId, memberPw);
		JDBCTemplate.close(conn);
		return m;
	}
}
