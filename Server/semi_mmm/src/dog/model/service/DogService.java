package dog.model.service;


import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import dog.model.dao.DogDao;
import dog.model.vo.Dog;
import member.model.dao.MemberDao;

public class DogService {

	public ArrayList<Dog> selectDog(String memberId) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Dog> dog = new DogDao().selectDog(conn, memberId);
		JDBCTemplate.close(conn);
		return dog;
	}

	public int insertDog(Dog dog) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new DogDao().insertDog(conn, dog);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public boolean selectDogId(String dogId) {
		Connection conn = JDBCTemplate.getConnection();
		boolean result = new DogDao().selectDogId(conn, dogId);
		JDBCTemplate.close(conn);
		return result;
	}

	public Dog selectOneDog(String dogId) {
		Connection conn = JDBCTemplate.getConnection();
		Dog dog = new DogDao().selectOneDog(conn, dogId);
		JDBCTemplate.close(conn);
		return dog;
	}

	public int updateDog(String dogId, Dog dog) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new DogDao().updateDog(conn, dogId, dog);
		if (result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteDog(String dogId) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new DogDao().deleteDog(conn, dogId);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

}
