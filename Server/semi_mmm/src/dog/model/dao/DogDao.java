package dog.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import dog.model.vo.Dog;
import oracle.sql.CHAR;

public class DogDao {

	public ArrayList<Dog> selectDog(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Dog> dog = new ArrayList<>();
		Dog d = null;
		String query="select * from Dog where dog_member_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				d = new Dog();
				d.setDogId(rset.getString("dog_id"));
				d.setDogMemberId(rset.getString("dog_member_id"));
				d.setDogName(rset.getString("dog_name"));
				d.setVariety(rset.getString("variety"));
				d.setAge(rset.getInt("age"));
				d.setDogGender(rset.getString("dog_gender"));
				d.setDogImg(rset.getString("dog_img"));
				d.setDogBool(rset.getInt("dog_bool"));
				dog.add(d);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return dog;
	}

	public int insertDog(Connection conn, Dog dog) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into dog values(?,?,?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, dog.getDogId());
			pstmt.setString(index++, dog.getDogMemberId());
			pstmt.setString(index++, dog.getVariety());
			pstmt.setInt(index++, dog.getAge());
			pstmt.setString(index++, dog.getDogGender());
			pstmt.setString(index++, dog.getDogImg());
			pstmt.setInt(index++, dog.getDogBool());
			pstmt.setString(index++, dog.getDogName());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public boolean selectDogId(Connection conn, String dogId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "select dog_id from dog";
		try {
			pstmt = conn.prepareStatement(query);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				if(rset.getString("dog_id").equals(dogId)) {
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

	public Dog selectOneDog(Connection conn, String dogId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Dog dog = null;
		String query = "select * from dog where dog_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dogId);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				dog = new Dog();
				dog.setDogId(rset.getString("dog_id"));
				dog.setDogMemberId(rset.getString("dog_member_id"));
				dog.setVariety(rset.getString("variety"));
				dog.setAge(rset.getInt("age"));
				dog.setDogGender(rset.getString("dog_gender"));
				dog.setDogImg(rset.getString("dog_img"));
				dog.setDogBool(rset.getInt("dog_bool"));
				dog.setDogName(rset.getString("dog_name"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return dog;
	}

	public int updateDog(Connection conn, String dogId, Dog dog) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update dog set dog_name = ?,variety=?,age = ?, dog_gender=?,dog_img=? where dog_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			int index = 1;
			pstmt.setString(index++, dog.getDogName());
			pstmt.setString(index++, dog.getVariety());
			pstmt.setInt(index++, dog.getAge());
			pstmt.setString(index++, dog.getDogGender());
			pstmt.setString(index++, dog.getDogImg());
			pstmt.setString(index++, dogId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int deleteDog(Connection conn, String dogId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from dog where dog_id = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dogId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
