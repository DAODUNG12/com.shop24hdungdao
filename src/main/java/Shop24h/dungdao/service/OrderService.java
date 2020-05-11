package Shop24h.dungdao.service;

import java.util.List;

import Shop24h.dungdao.entity.Order;
import Shop24h.dungdao.oo.OrderVo;

public interface OrderService {

	
	List<Order> getAll();


	public List<OrderVo> getOrderByPage(int pageNumber, int pageSize, String search);

	
	public List<OrderVo> getOrderSearchByPage(String search);

	
	Order createOrder(Order order);

	
	Order getOne(Integer id);

	
	boolean updateOrder(Order order);

	
	boolean deleteOrder(Integer id);

}
