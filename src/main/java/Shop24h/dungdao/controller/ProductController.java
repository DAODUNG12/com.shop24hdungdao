package Shop24h.dungdao.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Shop24h.dungdao.entity.Account;
import Shop24h.dungdao.entity.Product;
import Shop24h.dungdao.oo.AccountVo;
import Shop24h.dungdao.oo.ProductVo;
import Shop24h.dungdao.service.AccountService;
import Shop24h.dungdao.service.CategoryService;
import Shop24h.dungdao.service.ProductService;

@Controller
@RequestMapping("/admin")
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private AccountService accountService;

	// Get admin
	@GetMapping("/admin")
	public String listAdmin() {
		return "admin/admin";
	}

	// Edit product
	@GetMapping("/edit/{id}")
	public String editProduct(@PathVariable("id") Integer id, ModelMap map) {
		Product product = productService.getOne(id);
		map.addAttribute("category", categoryService.getAll());
		if (product == null) {
			return "redirect:/admin/listProduct";
		}
		if (product != null) {
			map.addAttribute("editProduct", product);
		}
		return "admin/updateProduct";

	}

	// get create product
	@GetMapping("/createProduct")
	public String createProduct(ModelMap map) {
		map.addAttribute("category", categoryService.getAll());
		return "admin/createProduct";
	}

	// List all product
	@GetMapping(value = { "/listProduct/{pageNumber}", "/listProduct" })
	public ModelAndView paginationProduct(@PathVariable(name = "pageNumber", required = false) String pageNumber,
			@RequestParam(name = "search", required = false) String search) {
		int pageNumbers = 1;
		if (pageNumber != null) {
			pageNumbers = Integer.parseInt(pageNumber);
		}
		ModelAndView m = new ModelAndView("admin/listProduct");
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

	// Delete product by id
	@GetMapping("/listProduct/delete/{id}/{currenPage}")
	public String deleteProduct(@PathVariable("id") int id, @PathVariable("currenPage") int currenPage,
			RedirectAttributes ra) {
		String message = "Bạn phải xóa khóa ngoại của bảng trước!";
		try {
			boolean result = productService.deleteProduct(id);
			message = result == true ? "Bạn đã xóa thánh công!" : "Bạn xóa không thành công!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		ra.addFlashAttribute("message", message);
		return "redirect:/admin/listProduct" + "/" + currenPage;
	}

	// Create by id
	@PostMapping("/createProduct")
	public ModelAndView createProduct(@RequestParam("name") String name, @RequestParam("price") double price,
			@RequestParam("image") MultipartFile image, @RequestParam("detail") String detail,
			@RequestParam("quantity") Integer quantity, @RequestParam("category") Integer categoryId) {
		try {

			Product product = new Product();
			product.setName(name);
			product.setPrice(price);
			if (!image.isEmpty()) {
				byte[] bytes = image.getBytes();
				Path path = Paths.get(image.getOriginalFilename());
				Files.write(path, bytes);
				product.setImage(image.getOriginalFilename());
			}
			product.setDetail(detail);
			product.setQuantity(quantity);
			product.setCategory(categoryService.getOne(categoryId));
			productService.createProduct(product);
			return new ModelAndView("redirect:/admin/listProduct");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/listProduct");
	}

	// Edit product by id
	@PostMapping("/edit/{id}")
	public ModelAndView editProduct(@PathVariable("id") Integer id, @RequestParam("name") String name,
			@RequestParam("price") double price, @RequestParam("image") MultipartFile image,
			@RequestParam("detail") String detail, @RequestParam("quantity") Integer quantity,
			@RequestParam("category") Integer categoryId) {
		try {

			Product product = new Product();
			product.setId(id);
			product.setName(name);
			product.setPrice(price);
			Product p = productService.getOne(id);
			product.setImage(p.getImage());
			if (!image.isEmpty()) {
				byte[] bytes = image.getBytes();
				Path path = Paths.get(image.getOriginalFilename());
				Files.write(path, bytes);
				product.setImage(image.getOriginalFilename());
			}
			product.setDetail(detail);
			product.setQuantity(quantity);
			product.setCategory(categoryService.getOne(categoryId));
			productService.updateProduct(product);
			return new ModelAndView("redirect:/admin/listProduct");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/listProduct");
	}

	// List all user
	@GetMapping(value = { "/listUser/{pageNumber}", "/listUser" })
	public ModelAndView listUserByPagination(@PathVariable(name = "pageNumber", required = false) String pageNumber,
			@RequestParam(name = "search", required = false) String search) {
		int pageNumbers = 1;
		if (pageNumber != null) {
			pageNumbers = Integer.parseInt(pageNumber);
		}
		ModelAndView m = new ModelAndView("admin/listUser");
		int pageSize = 10;
		int next = -1;
		int back = -1;
		int totalPage = 0;
		String sql = "";
		List<?> list = null;

		if (search == null || search.equals("")) {
			list = new ArrayList<Account>();
			list = accountService.getAll();
		} else {
			sql = " name like concat('%', convert('" + search + "', binary), '%') or email like concat('%', convert('"
					+ search + "', binary), '%')";
			list = new ArrayList<AccountVo>();
			list = accountService.getAccountSearchByPage(sql);
		}

		// Condition totalPage
		if (list.size() % pageSize == 0) {
			totalPage = list.size() / pageSize;
		} else {
			totalPage = (list.size() / pageSize) + 1;
		}

		if (pageNumbers > 1) {
			back = pageNumbers - 1;
		}
		if (pageNumbers < totalPage) {
			next = pageNumbers + 1;
		}

		m.addObject("search", search);
		m.addObject("next", next);
		m.addObject("back", back);
		m.addObject("currenPage", pageNumbers);
		m.addObject("totalPage", totalPage);
		m.addObject("allUser", accountService.getAccountByPage(pageNumbers, pageSize, sql));
		return m;
	}

}
