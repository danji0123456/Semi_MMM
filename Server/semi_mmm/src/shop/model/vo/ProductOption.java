package shop.model.vo;

public class ProductOption {
	private int optionNo;
	private int productNo;
	private String bnMemberId;
	private String optionTitle;
	private int optionPrice;
	public ProductOption() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductOption(int optionNo, int productNo, String bnMemberId, String optionTitle, int optionPrice) {
		super();
		this.optionNo = optionNo;
		this.productNo = productNo;
		this.bnMemberId = bnMemberId;
		this.optionTitle = optionTitle;
		this.optionPrice = optionPrice;
	}
	public int getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(int optionNo) {
		this.optionNo = optionNo;
	}
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}
	public String getBnMemberId() {
		return bnMemberId;
	}
	public void setBnMemberId(String bnMemberId) {
		this.bnMemberId = bnMemberId;
	}
	public String getOptionTitle() {
		return optionTitle;
	}
	public void setOptionTitle(String optionTitle) {
		this.optionTitle = optionTitle;
	}
	public int getOptionPrice() {
		return optionPrice;
	}
	public void setOptionPrice(int optionPrice) {
		this.optionPrice = optionPrice;
	}
	
}
