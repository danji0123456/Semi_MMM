package shop.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import member.model.vo.Member;
import shop.model.dao.ShopDao;
import shop.model.vo.Cart;
import shop.model.vo.Product;
import shop.model.vo.ProductData;
import shop.model.vo.ProductOption;
import shop.model.vo.ShopViewData;

public class ShopService {

	public ArrayList<Member> shopList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = new ShopDao().shopList(conn);
		JDBCTemplate.close(conn);
		return list;
	}

	public Product selectOneShop(String bnMemberId) {
		Connection conn = JDBCTemplate.getConnection();
		Product p = new ShopDao().selectOneShop(conn, bnMemberId);
		//ArrayList<Product> list = new ShopDao().selectMenuList(conn,bnMemberId);
		//ShopViewData svd = new ShopViewData(p, list);
		JDBCTemplate.close(conn);
		return p;
	}
	

	public int insertMenu(Product p) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new ShopDao().insertMenu(conn, p);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<ShopViewData> selectMenuListFrm(String bnMemberId) {
		Connection conn = JDBCTemplate.getConnection();
		//Product p = new ShopDao().selectOneShop(conn, bnMemberId);
		ArrayList<Product> list = new ShopDao().selectMenuList(conn,bnMemberId);
		ArrayList<ShopViewData> svd = new ArrayList<ShopViewData>();
		for(int i=0; i<list.size(); i++) {
			ShopViewData s = new ShopViewData();
			s.setProductTitle(list.get(i).getProductTitle());
			 ArrayList<ProductOption> po = new ShopDao().selectSubMenuList(conn,list.get(i).getProductNo(),bnMemberId);
			 s.setSubList(po);
			 svd.add(s);
		}
		JDBCTemplate.close(conn);
		return svd;
	}
	
	public ArrayList<Product> selectMenuList(String bnMemberId){
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Product> list = new ShopDao().selectMenuList(conn, bnMemberId);
		JDBCTemplate.close(conn);
		return list;
	}

	public ArrayList<ProductOption> selectSubMenuList(int productNo,String bnMemberId) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<ProductOption> subList = new ShopDao().selectSubMenuList(conn,productNo,bnMemberId);
		JDBCTemplate.close(conn);
		return subList;
	}

	public int insertSubMenu(ProductOption po) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new ShopDao().insertSubMenu(conn, po);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int UpdateMenu(Product p) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new ShopDao().updateMenu(conn,p);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int updateSubMenu(ProductOption po) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new ShopDao().updateSubMenu(conn,po);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int deleteMenu(int productNo, String bnMemberId) {
		Connection conn = JDBCTemplate.getConnection();
		//int result1 = new ShopDao().deleteSubMenuAll(conn,productNo,bnMemberId);
		int result = new ShopDao().deleteSubMenuAll(conn,productNo,bnMemberId);
		if(result>0) {
			result = new ShopDao().deleteMenu(conn,productNo,bnMemberId);
			if(result>0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public ArrayList<ProductOption> selectSubMenuList(String bnMemberId) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<ProductOption> subList = new ShopDao().selectSubMenuList(conn,bnMemberId);
		JDBCTemplate.close(conn);
		return subList;
	}
	
	public ShopViewData showMenuList(int productNo, String bnMemberId) {
		Connection conn = JDBCTemplate.getConnection();
		Product p = new ShopDao().selectOneMenu(conn,productNo,bnMemberId);
		//ArrayList<Product> p = new ShopDao().selectMenuList(conn, bnMemberId);
		ArrayList<ProductOption> subList = new ShopDao().selectSubMenuList(conn, productNo, bnMemberId);
		//ArrayList<ShopViewData> list = new ShopDao().ShowMenu(conn,p.getProductTitle(),bnMemberId);
		ShopViewData svd = new ShopViewData(p.getProductTitle(), subList);
		JDBCTemplate.close(conn);
		return svd;
	}

	public int insertCart(Cart c) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new ShopDao().insertCart(conn,c);
		if(result>0) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Cart> selectCartList(String orderMemberId) {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Cart> cartList = new ShopDao().selectCartList(conn,orderMemberId);
		JDBCTemplate.close(conn);
		return cartList;
	}

	public int deleteSubMenu(int productNo, String bnMemberId, int optionNo) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new ShopDao().deleteSubMenu(conn,productNo,bnMemberId,optionNo);
		if(result>0) {
				JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
