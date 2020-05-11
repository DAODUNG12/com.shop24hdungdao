package Shop24h.dungdao.reponsitory.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Shop24h.dungdao.entity.Order;
import Shop24h.dungdao.oo.OrderVo;
import Shop24h.dungdao.reponsitory.OrderRepository;
import Shop24h.dungdao.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository ordersRepository;
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Order> getAll() {
		return ordersRepository.findAll();
	}

	@Override
	public List<OrderVo> getOrderByPage(int pageNumber, int pageSize, String search) {
		List<OrderVo> voList = new ArrayList<OrderVo>();
		String sql = "FROM Order ";
		if (!search.isEmpty()) {
			sql += "where" + search;
		}
		try {
			int start = (pageNumber - 1) * pageSize;
			Session session = (Session) entityManager.getDelegate();
			Query q = session.createQuery(sql);
			q.setFirstResult(start);
			q.setMaxResults(pageSize);

			@SuppressWarnings("unchecked")
			List<Order> listResult = q.getResultList();

			for (Order order : listResult) {
				OrderVo vo = new OrderVo();
				vo.setId(order.getId());
				vo.setAddress(order.getAddress());
				vo.setStatus(order.getStatus());
				vo.setOrderDate(order.getOrderDate());
				vo.setOrderTotalPrice(order.getOrderTotalPrice());
				vo.setName(order.getName());
				vo.setPhone(order.getPhone());
				vo.setEmail(order.getEmail());
				vo.setAccount(order.getAccount());
				voList.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return voList;
	}

	@Override
	public List<OrderVo> getOrderSearchByPage(String search) {
		List<OrderVo> voList = new ArrayList<OrderVo>();
		String sql = "FROM Order ";
		if (!search.isEmpty()) {
			sql += "where" + search;
		}
		try {
			Session session = (Session) entityManager.getDelegate();
			Query q = session.createQuery(sql);

			@SuppressWarnings("unchecked")
			List<Order> listResult = q.getResultList();

			for (Order order : listResult) {
				OrderVo vo = new OrderVo();
				vo.setId(order.getId());
				vo.setAddress(order.getAddress());
				vo.setStatus(order.getStatus());
				vo.setOrderDate(order.getOrderDate());
				vo.setOrderTotalPrice(order.getOrderTotalPrice());
				vo.setName(order.getName());
				vo.setPhone(order.getPhone());
				vo.setEmail(order.getEmail());
				vo.setAccount(order.getAccount());
				voList.add(vo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return voList;
	}

	@Override
	public Order createOrder(Order order) {
		return ordersRepository.save(order);
	}

	@Override
	public Order getOne(Integer id) {
		return ordersRepository.getOne(id);
	}

	@Override
	public boolean updateOrder(Order order) {
		boolean result = false;
		try {
			ordersRepository.save(order);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteOrder(Integer id) {
		if (id != null) {
			ordersRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
