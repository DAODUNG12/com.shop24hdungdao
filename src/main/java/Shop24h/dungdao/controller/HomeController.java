package Shop24h.dungdao.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import Shop24h.dungdao.entity.Product;
import Shop24h.dungdao.oo.ProductVo;
import Shop24h.dungdao.service.CategoryService;
import Shop24h.dungdao.service.ProductService;

@Controller
@RequestMapping("")
public class HomeController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/")
	public String home() {
		return "shop24dungdao/index";
	}

	// List all product
	@GetMapping(value = { "/home/{pageNumber}", "/", "/home" })
	public ModelAndView paginationProduct(@PathVariable(name = "pageNumber", required = false) String pageNumber,
			@RequestParam(name = "search", required = false) String search) {
		int pageNumbers = 1;
		if (pageNumber != null) {
			pageNumbers = Integer.parseInt(pageNumber);
		}
		ModelAndView m = new ModelAndView("shop24dungdao/index");
		int pageSize = 12;
		int next = -1;
		int back = -1;
		int totalPage = 0;
		String sql = "";
		List<?> list = null;
		// search by name
		if (search == null || search.equals("")) {
			list = new ArrayList<Product>();
			list = productService.getAllProduct();
		} else {
			sql = " name like concat('%', convert('" + search + "', binary), '%') or price like concat('%', convert('"
					+ search + "', binary), '%')";
			list = new ArrayList<ProductVo>();
			list = productService.getProductSearchByPage(sql);
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

		m.addObject("search", search);
		m.addObject("next", next);
		m.addObject("currenPage", pageNumbers);
		m.addObject("back", back);
		m.addObject("totalPage", totalPage);
		m.addObject("allProduct", productService.getProductByPage(pageNumbers, pageSize, sql));
		return m;
	}

	// list product by page
	@GetMapping(value = { "/listProduct/{pageNumber}", "/listProduct" })
	public ModelAndView paginationProduct(@PathVariable(name = "pageNumber", required = false) String pageNumber,
			@RequestParam(name = "search", required = false) String search,
			@RequestParam(name = "category", required = false) String id) {
		int pageNumbers = 1;
		if (pageNumber != null) {
			pageNumbers = Integer.parseInt(pageNumber);
		}
		ModelAndView m = new ModelAndView("shop24dungdao/productCustommer");
		int pageSize = 12;
		int next = -1;
		int back = -1;
		int totalPage = 0;
		String sql = "";
		List<?> list = null;
		if (id != null) {
			sql = " category = '" + id + "'";
			list = new ArrayList<ProductVo>();
			list = productService.getProductSearchByPage(sql);
		}

		// search by name
		if (search == null || search.equals("")) {
			if (sql.isEmpty()) {
				list = new ArrayList<Product>();
				list = productService.getAllProduct();
			}

		} else {
			if (!sql.isEmpty()) {
				sql += " and name like concat('%', convert('" + search
						+ "', binary), '%') or price like concat('%', convert('" + search + "', binary), '%')";
			}
			sql = " name like concat('%', convert('" + search + "', binary), '%') or price like concat('%', convert('"
					+ search + "', binary), '%')";
			list = new ArrayList<ProductVo>();
			list = productService.getProductSearchByPage(sql);
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
		m.addObject("categoryId", id);
		m.addObject("category", categoryService.getAll());
		m.addObject("search", search);
		m.addObject("next", next);
		m.addObject("currenPage", pageNumbers);
		m.addObject("back", back);
		m.addObject("totalPage", totalPage);
		m.addObject("allProduct", productService.getProductByPage(pageNumbers, pageSize, sql));
		return m;
	}
}
