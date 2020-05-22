package shop.model.vo;

public class Payment {
	private int paymentNo;
	private int orderNo;
	private int paymentTotal;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int paymentNo, int orderNo, int paymentTotal) {
		super();
		this.paymentNo = paymentNo;
		this.orderNo = orderNo;
		this.paymentTotal = paymentTotal;
	}
	public int getPaymentNo() {
		return paymentNo;
	}
	public void setPaymentNo(int paymentNo) {
		this.paymentNo = paymentNo;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public int getPaymentTotal() {
		return paymentTotal;
	}
	public void setPaymentTotal(int paymentTotal) {
		this.paymentTotal = paymentTotal;
	}
	
}
