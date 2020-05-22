package shop.model.vo;

import java.util.ArrayList;

public class CartData {
	public Cart c;
	public ArrayList<ProductOption> po;
	public CartData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CartData(Cart c, ArrayList<ProductOption> po) {
		super();
		this.c = c;
		this.po = po;
	}
	public Cart getC() {
		return c;
	}
	public void setC(Cart c) {
		this.c = c;
	}
	public ArrayList<ProductOption> getPo() {
		return po;
	}
	public void setPo(ArrayList<ProductOption> po) {
		this.po = po;
	}
	
}
