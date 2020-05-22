package shop.model.vo;

public class Product {
	private int productNo;
	private String bnMemberId;
	private String productFilename;
	private String productFilepath;
	private String productTitle;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int productNo, String bnMemberId, String productFilename, String productFilepath, String productTitle) {
		super();
		this.productNo = productNo;
		this.bnMemberId = bnMemberId;
		this.productFilename = productFilename;
		this.productFilepath = productFilepath;
		this.productTitle = productTitle;
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
