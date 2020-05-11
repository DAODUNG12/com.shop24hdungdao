package Shop24h.dungdao.oo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import Shop24h.dungdao.entity.Account;
import Shop24h.dungdao.entity.OrderDetail;

public class OrderVo implements Serializable {

	private static final long serialVersionUID = 1L;

	Integer id;

	@NotEmpty(message = "Address must be not blank")
	String address;

	@NotEmpty(message = "Status must be not blank")
	Integer status;

	@NotEmpty(message = "OrderDate must be not blank")
	Date orderDate;

	@NotEmpty(message = "OrderTotalPrice must be not blank")
	double orderTotalPrice;

	@NotEmpty(message = "Name must be not blank")
	String name;

	@NotEmpty(message = "Phone must be not blank")
	String phone;

	@NotEmpty(message = "Email must be not blank")
	String email;

	@NotEmpty(message = "User must be not blank")
	Account account;

	@NotEmpty(message = "OrderDetails must be not blank")
	List<OrderDetail> orderDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderTotalPrice() {
		return orderTotalPrice;
	}

	public void setOrderTotalPrice(double orderTotalPrice) {
		this.orderTotalPrice = orderTotalPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
