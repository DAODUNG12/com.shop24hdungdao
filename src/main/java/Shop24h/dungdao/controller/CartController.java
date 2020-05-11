package Shop24h.dungdao.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Shop24h.dungdao.entity.Cart;
import Shop24h.dungdao.entity.Product;
import Shop24h.dungdao.service.CategoryService;
import Shop24h.dungdao.service.ProductService;

@Controller
public class CartController {
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/cart")
	public String getALl(ModelMap map) {
		map.addAttribute("category", categoryService.getAll());
		return "shop24dungdao/cart";
	}

	@PostMapping(value = "/add/{productId}")
	public String add(ModelMap map, HttpSession session, @PathVariable("productId") Integer productId,
			@RequestParam("quantity") Integer quantity) {
		@SuppressWarnings("unchecked")
		ArrayList<Cart> arrList = (ArrayList<Cart>) session.getAttribute("listCart");
		if (arrList == null) {
			arrList = new ArrayList<Cart>();
		}
		Product product = productService.getOne(productId);
		boolean bought = true;
		for (Cart cart : arrList) {
			if (cart.getProduct().getId() == productId) {
				cart.setQuantity(cart.getQuantity() + quantity);
				bought = false;
			}
		}
		if (bought) {
			Cart cart = new Cart();
			cart.setProduct(product);
			cart.setQuantity(quantity);
			arrList.add(cart);
		}
		double total = 0;
		for (Cart cart : arrList) {
			total += (cart.getProduct().getPrice() * cart.getQuantity());
		}
		session.setAttribute("listCart", arrList);
		session.setAttribute("totalPrice", total);
		return "redirect:/cart";
	}

	@GetMapping(value = "/delete/{productId}")
	public String delete(ModelMap map, HttpSession session, @PathVariable("productId") Integer productId) {
		@SuppressWarnings("unchecked")
		ArrayList<Cart> arrList = (ArrayList<Cart>) session.getAttribute("listCart");
		if (arrList == null) {
			arrList = new ArrayList<Cart>();
		}
		Cart cartDelete = null;
		for (Cart cart : arrList) {
			if (cart.getProduct().getId() == productId) {
				cartDelete = cart;
			}
		}
		if (cartDelete != null) {
			arrList.remove(cartDelete);
		}
		double total = 0;
		for (Cart cart : arrList) {
			total += (cart.getProduct().getPrice() * cart.getQuantity());
		}

		session.setAttribute("listCart", arrList);
		session.setAttribute("totalPrice", total);
		return "redirect:/cart";
	}

}