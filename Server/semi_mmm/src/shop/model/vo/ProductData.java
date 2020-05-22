package shop.model.vo;

public class ProductData {
	private int optionNo;
	private int productNo;
	private String bnMemberId;
	private String optionTitle;
	private int optionPrice;
	private String productFilename;
	private String productFilepath;
	private String productTitle;
	public ProductData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductData(int optionNo, int productNo, String bnMemberId, String optionTitle, int optionPrice,
			String productFilename, String productFilepath, String productTitle) {
		super();
		this.optionNo = optionNo;
		this.productNo = productNo;
		this.bnMemberId = bnMemberId;
		this.optionTitle = optionTitle;
		this.optionPrice = optionPrice;
		this.productFilename = productFilename;
		this.productFilepath = productFilepath;
		this.productTitle = productTitle;
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
	public String getProductFilename() {
		return productFilename;
	}
	public void setProductFilename(String productFilename) {
		this.productFilename = productFilename;
	}
	public String getProductFilepath() {
		return productFilepath;
	}
	public void setProductFilepath(String productFilepath) {
		this.productFilepath = productFilepath;
	}
	public String getProductTitle() {
		return productTitle;
	}
	public void setProductTitle(String productTitle) {
		this.productTitle = productTitle;
	}
	
	
	
}
