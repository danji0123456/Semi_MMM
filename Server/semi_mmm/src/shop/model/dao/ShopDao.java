package shop.model.dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;
import shop.model.vo.Cart;
import shop.model.vo.Product;
import shop.model.vo.ProductData;
import shop.model.vo.ProductOption;
import shop.model.vo.ShopViewData;

public class ShopDao {

	public ArrayList<Member> shopList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList<Member>();
		String query = "select * from member where member_level=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, 2);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Member m = new Member();
				m.setAddr(rset.getString("addr"));
				m.setEnrollDate(rset.getDate("enroll_date"));
				m.setMemberBirth(rset.getDate("member_birth"));
				m.setMemberId(rset.getString("member_id"));
				m.setMemberLevel(rset.getInt("member_level"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberNickname(rset.getString("member_nickname"));
				m.setMemberPw(rset.getString("member_pw"));
				m.setPhone(rset.getString("phone"));
				m.setProfileImg(rset.getString("profile_img"));
				list.add(m);
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

	public Product selectOneShop(Connection conn, String bnMemberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product p = new Product();
		String query = "select * from product where bn_member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bnMemberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				p.setBnMemberId(rset.getString("bn_member_id"));
				p.setProductFilename(rset.getString("product_filename"));
				p.setProductFilepath(rset.getString("product_filepath"));
				p.setProductNo(rset.getInt("product_no"));
				p.setProductTitle(rset.getString("product_title"));
				System.out.println(p.getBnMemberId());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return p;
	}
	
	public Product selectOneMenu(Connection conn, int productNo, String bnMemberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Product p = new Product();
		String query = "select * from product where product_no=? and bn_member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productNo);
			pstmt.setString(2, bnMemberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				p.setBnMemberId(rset.getString("bn_member_id"));
				p.setProductFilename(rset.getString("product_filename"));
				p.setProductFilepath(rset.getString("product_filepath"));
				p.setProductNo(rset.getInt("product_no"));
				p.setProductTitle(rset.getString("product_title"));
				System.out.println(p.getBnMemberId());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return p;
	}

	public int insertMenu(Connection conn, Product p) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into product values(product_seq.nextval,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getBnMemberId());
			pstmt.setString(2, p.getProductFilename());
			pstmt.setString(3, p.getProductFilepath());
			pstmt.setString(4, p.getProductTitle());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Product> selectMenuList(Connection conn, String bnMemberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Product> list = new ArrayList<Product>();
		String query = "select * from product where bn_member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bnMemberId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Product p = new Product();
				p.setBnMemberId(rset.getString("bn_member_id"));
				p.setProductFilename(rset.getString("product_filename"));
				p.setProductFilepath(rset.getString("product_filepath"));
				p.setProductNo(rset.getInt("product_no"));
				p.setProductTitle(rset.getString("product_title"));
				list.add(p);
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

	public ArrayList<ProductOption> selectSubMenuList(Connection conn, int productNo, String bnMemberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProductOption> subList = new ArrayList<ProductOption>();
		String query = "select * from product_option where product_no=? and bn_member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productNo);
			pstmt.setString(2, bnMemberId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ProductOption po = new ProductOption();
				po.setOptionNo(rset.getInt("option_no"));
				po.setProductNo(rset.getInt("product_no"));
				po.setBnMemberId(rset.getString("bn_member_id"));
				po.setOptionTitle(rset.getString("option_title"));
				po.setOptionPrice(rset.getInt("option_price"));
				subList.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return subList;
	}

	public int insertSubMenu(Connection conn, ProductOption po) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into product_option values(product_option_seq.nextval,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, po.getProductNo());
			pstmt.setString(2, po.getBnMemberId());
			pstmt.setString(3, po.getOptionTitle());
			pstmt.setInt(4, po.getOptionPrice());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateMenu(Connection conn, Product p) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update product set bn_member_id=?, product_filename=?, product_filepath=?, product_title=? where product_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, p.getBnMemberId());
			pstmt.setString(2, p.getProductFilename());
			pstmt.setString(3, p.getProductFilepath());
			pstmt.setString(4, p.getProductTitle());
			pstmt.setInt(5, p.getProductNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateSubMenu(Connection conn, ProductOption po) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "update product_option set product_no=?, bn_member_id=?, option_title=?, option_price=? where option_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, po.getProductNo());
			pstmt.setString(2, po.getBnMemberId());
			pstmt.setString(3, po.getOptionTitle());
			pstmt.setInt(4, po.getOptionPrice());
			pstmt.setInt(5, po.getOptionNo());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int deleteMenu(Connection conn, int productNo, String bnMemberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from product where product_no=? and bn_member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productNo);
			pstmt.setString(2, bnMemberId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteSubMenuAll(Connection conn, int productNo, String bnMemberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from product_option where product_no=? and bn_member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productNo);
			pstmt.setString(2, bnMemberId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<ProductOption> selectSubMenuList(Connection conn, String bnMemberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProductOption> subList = new ArrayList<ProductOption>();
		String query = "select * from product_option where bn_member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bnMemberId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ProductOption po = new ProductOption();
				po.setOptionNo(rset.getInt("option_no"));
				po.setProductNo(rset.getInt("product_no"));
				po.setBnMemberId(rset.getString("bn_member_id"));
				po.setOptionTitle(rset.getString("option_title"));
				po.setOptionPrice(rset.getInt("option_price"));
				subList.add(po);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return subList;
	}

	public ArrayList<ProductData> sellProductList(Connection conn, String bnMemberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ProductData> pdList = new ArrayList<ProductData>();
		String query = "select po.option_no, p.product_no, p.bn_member_id, po.option_title, po.option_price, p.product_filename, p.product_filepath, p.product_title"
						+" from product_option po,product p where p.bn_member_id=po.bn_member_id and p.product_no=po.product_no and p.bn_member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, bnMemberId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				ProductData pd = new ProductData();
				pd.setBnMemberId(rset.getString("bn_member_id"));
				pd.setOptionNo(rset.getInt("option_no"));
				pd.setOptionPrice(rset.getInt("option_price"));
				pd.setOptionTitle(rset.getString("option_title"));
				pd.setProductFilename(rset.getString("product_filename"));
				pd.setProductFilepath(rset.getString("product_filepath"));
				pd.setProductNo(rset.getInt("product_no"));
				pd.setProductTitle(rset.getString("product_title"));
				pdList.add(pd);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return pdList;
	}
	public ArrayList<ProductOption> pn(Connection conn, int productNo, String bnMemberId) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertCart(Connection conn, Cart c) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "insert into cart values(cart_seq.nextval,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, c.getOrderMemberId());
			pstmt.setInt(2, c.getTotalPrice());
			pstmt.setString(3, c.getBnMemberId());
			pstmt.setString(4, c.getSelectOpt());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Cart> selectCartList(Connection conn, String orderMemberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Cart> list = new ArrayList<Cart>();
		String query = "select * from cart where order_member_id=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, orderMemberId);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				Cart c = new Cart();
				c.setBnMemberId(rset.getString("bn_member_id"));
				c.setCartNo(rset.getInt("cart_no"));
				c.setOrderMemberId(rset.getString("order_member_id"));
				c.setTotalPrice(rset.getInt("total_price"));
				c.setSelectOpt(rset.getString("select_opt"));
				list.add(c);
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

	public int deleteSubMenu(Connection conn, int productNo, String bnMemberId, int optionNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "delete from product_option where product_no=? and bn_member_id=? and option_no=?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, productNo);
			pstmt.setString(2, bnMemberId);
			pstmt.setInt(3, optionNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
}
