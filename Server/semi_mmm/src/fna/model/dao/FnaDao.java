package fna.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import fna.model.vo.Fna;

public class FnaDao {

	public ArrayList<Fna>selectAll (Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select rownum as rnum, f.question, f.answer from (select * from fna order by qna_no asc) f";
		ArrayList<Fna> fna = new ArrayList<Fna>();
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Fna f = new Fna();
				f.setQnaNo(rset.getInt(1));
				f.setQuestion(rset.getString(2));
				f.setAnswer(rset.getString(3));
				fna.add(f);
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


}
