package member.model.vo;

public class Shop {
	private String shopId;
	private String shopMemberId;
	private String shopBank;
	private String shopBankAccount;
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Shop(String shopId, String shopMemberId, String shopBank, String shopBankAccount) {
		super();
		this.shopId = shopId;
		this.shopMemberId = shopMemberId;
		this.shopBank = shopBank;
		this.shopBankAccount = shopBankAccount;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getShopMemberId() {
		return shopMemberId;
	}
	public void setShopMemberId(String shopMemberId) {
		this.shopMemberId = shopMemberId;
	}
	public String getShopBank() {
		return shopBank;
	}
	public void setShopBank(String shopBank) {
		this.shopBank = shopBank;
	}
	public String getShopBankAccount() {
		return shopBankAccount;
	}
	public void setShopBankAccount(String shopBankAccount) {
		this.shopBankAccount = shopBankAccount;
	}
	
}
