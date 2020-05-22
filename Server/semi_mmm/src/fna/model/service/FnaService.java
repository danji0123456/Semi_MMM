package fna.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import fna.model.dao.FnaDao;
import fna.model.vo.Fna;

public class FnaService {

	public ArrayList<Fna> selectAll() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Fna> fna = new FnaDao().selectAll(conn); 
		JDBCTemplate.close(conn);
		return fna;
	}

}
