package shop.model.vo;

public class Cart {
	private int cartNo;
	private String orderMemberId;
	private int totalPrice;
	private String bnMemberId;
	private String selectOpt;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(int cartNo, String orderMemberId, int totalPrice, String bnMemberId, String selectOpt) {
		super();
		this.cartNo = cartNo;
		this.orderMemberId = orderMemberId;
		this.totalPrice = totalPrice;
		this.bnMemberId = bnMemberId;
		this.selectOpt = selectOpt;
	}
	public int getCartNo() {
		return cartNo;
	}
	public void setCartNo(int cartNo) {
		this.cartNo = cartNo;
	}
	public String getOrderMemberId() {
		return orderMemberId;
	}
	public void setOrderMemberId(String orderMemberId) {
		this.orderMemberId = orderMemberId;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getBnMemberId() {
		return bnMemberId;
	}
	public void setBnMemberId(String bnMemberId) {
		this.bnMemberId = bnMemberId;
	}
	public String getSelectOpt() {
		return selectOpt;
	}
	public void setSelectOpt(String selectOpt) {
		this.selectOpt = selectOpt;
	}
	
}
