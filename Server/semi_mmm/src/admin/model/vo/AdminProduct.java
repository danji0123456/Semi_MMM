package admin.model.vo;

import java.util.ArrayList;

import shop.model.vo.Product;
import shop.model.vo.ProductOption;

public class AdminProduct {

	Product product;
	ArrayList<ProductOption> options;

	public AdminProduct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdminProduct(Product product, ArrayList<ProductOption> options) {
		super();
		this.product = product;
		this.options = options;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ArrayList<ProductOption> getOptions() {
		return options;
	}

	public void setOptions(ArrayList<ProductOption> options) {
		this.options = options;
	}

}
