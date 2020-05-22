package shop.model.vo;

import java.util.ArrayList;

public class ShopViewData {
	private String productTitle;
	private ArrayList<ProductOption> subList;
	public ShopViewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShopViewData(String productTitle, ArrayList<ProductOption> subList) {
		super();
		this.productTitle = productTitle;
		this.subList = subList;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	public ArrayList<ProductOption> getSubList() {
		return subList;
	}
	public void setSubList(ArrayList<ProductOption> subList) {
		this.subList = subList;
	}
	
}
