package admin.model.vo;

import java.util.ArrayList;

import member.model.vo.Member;
import member.model.vo.Shop;

public class AdminShopData {

	Member member;
	Shop shop;
	ArrayList<AdminProduct> products;

	public AdminShopData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminShopData(Member member, Shop shop, ArrayList<AdminProduct> products) {
		super();
		this.member = member;
		this.shop = shop;
		this.products = products;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public ArrayList<AdminProduct> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<AdminProduct> products) {
		this.products = products;
	}

}
