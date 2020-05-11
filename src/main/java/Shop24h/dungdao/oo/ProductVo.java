package Shop24h.dungdao.oo;

import javax.validation.constraints.NotEmpty;

import Shop24h.dungdao.entity.Category;

public class ProductVo {

	private static final long serialVersionUID = 1L;

	Integer id;

	@NotEmpty(message = "Name must be not blank")
	String name;

	@NotEmpty(message = "Price must be not blank")
	double price;

	@NotEmpty(message = "Image must be not blank")
	String image;

	@NotEmpty(message = "Detail must be not blank")
	String detail;

	@NotEmpty(message = "Quantity must be not blank")
	Integer quantity;

	private Category category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
