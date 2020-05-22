package shop.model.vo;

public class OrderDetail {
	private int orderNo;
	private int orderCount;
	private String orderComment;
	public OrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(int orderNo, int orderCount, String orderComment) {
		super();
		this.orderNo = orderNo;
		this.orderCount = orderCount;
		this.orderComment = orderComment;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public String getOrderComment() {
		return orderComment;
	}
	public void setOrderComment(String orderComment) {
		this.orderComment = orderComment;
	}
	
}
