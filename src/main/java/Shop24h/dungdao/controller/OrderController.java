package Shop24h.dungdao.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Shop24h.dungdao.entity.Order;
import Shop24h.dungdao.oo.OrderVo;
import Shop24h.dungdao.service.AccountService;
import Shop24h.dungdao.service.OrderService;

@Controller
@RequestMapping("/admin")
public class OrderController {

	@Autowired
	private OrderService ordersService;
	@Autowired
	private AccountService accountService;

	@GetMapping(value = { "/listOrder/{pageNumber}", "admin/listOrder" })
	public ModelAndView paginationOrders(@PathVariable(name = "pageNumber", required = false) String pageNumber,
			@RequestParam(name = "search", required = false) String search) {
		int pageNumbers = 1;
		if (pageNumber != null) {
			pageNumbers = Integer.parseInt(pageNumber);
		}

		ModelAndView m = new ModelAndView("admin/listOrder");
		int pageSize = 12;
		int next = -1;
		int back = -1;
		int totalPage = 0;
		String sql = "";
		List<?> list = null;

		if (search == null || search.equals("")) {
			list = new ArrayList<Order>();
			list = ordersService.getAll();
		} else {
			sql = " address like concat('%', convert('" + search
					+ "', binary), '%') or status like concat('%', convert('" + search + "', binary), '%')";
			list = new ArrayList<OrderVo>();
			list = ordersService.getOrderSearchByPage(sql);
		}

		// Condition totalPage
		if (list.size() % pageSize == 0) {
			totalPage = list.size() / pageSize;
		} else {
			totalPage = (list.size() / pageSize) + 1;
		}

		if (pageNumbers > totalPage) {
			pageNumbers = 1;
		}
		if (pageNumbers > 1) {
			back = pageNumbers - 1;
		}
		if (pageNumbers < totalPage) {
			next = pageNumbers + 1;
		}
		HashMap<Integer, String> arrStatus = new HashMap<Integer, String>();
		arrStatus.put(1, "Đang đặt hàng");
		arrStatus.put(2, "Đang giao hàng");
		arrStatus.put(3, "Đã giao hàng");
		arrStatus.put(4, "Yêu cầu hủy");

		m.addObject("arrStatus", arrStatus);
		m.addObject("search", search);
		m.addObject("next", next);
		m.addObject("currenPage", pageNumbers);
		m.addObject("back", back);
		m.addObject("totalPage", totalPage);
		m.addObject("allOrder", ordersService.getOrderByPage(pageNumbers, pageSize, sql));
		return m;
	}

	// Edit Order
	@GetMapping("/editOrders/{id}")
	public String editOrder(@PathVariable("id") Integer id, ModelMap map) {
		Order order = ordersService.getOne(id);
		HashMap<Integer, String> arrStatus = new HashMap<Integer, String>();
		arrStatus.put(1, "Đang đặt hàng");
		arrStatus.put(2, "Đang giao hàng");
		arrStatus.put(3, "Đã giao hàng");
		arrStatus.put(4, "Yêu cầu hủy");
		if (order == null) {
			return "redirect:/admin/listOder";
		}
		if (order != null) {
			map.addAttribute("editOrders", order);
			map.addAttribute("arrStatus", arrStatus);
		}
		return "admin/updateOrder";

	}

	@PostMapping("/editOrders/{id}")
	public ModelAndView editOrder(@PathVariable("id") Integer id, @RequestParam("username") String username,
			@RequestParam("status") Integer status, @RequestParam("address") String address,
			@RequestParam("orderTotalPrice") double orderTotalPrice, @RequestParam("name") String name,
			@RequestParam("phone") String phone, @RequestParam("email") String email) {
		Order order = ordersService.getOne(id);
		try {
			order.setAccount(accountService.getOne(username));
			order.setStatus(status);
			order.setAddress(address);
			order.setOrderTotalPrice(orderTotalPrice);
			order.setName(name);
			order.setPhone(phone);
			order.setEmail(email);
			ordersService.updateOrder(order);
			return new ModelAndView("redirect:/admin/listOrder");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/listOrder");
	}

	@GetMapping("/listOrder/delete/{id}/{currenPage}")
	public String deleteOrders(@PathVariable("id") int id, @PathVariable("currenPage") int currenPage,
			RedirectAttributes ra) {
		String message = "Bạn phải xóa khóa ngoại của bảng trước!";
		try {

			boolean result = ordersService.deleteOrder(id);
			message = result == true ? "Bạn đã xóa thánh công!" : "Bạn xóa không thành công!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		ra.addFlashAttribute("message", message);
		return "redirect:/admin/listOrder" + "/" + currenPage;
	}
}