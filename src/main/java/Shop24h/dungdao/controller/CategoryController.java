package Shop24h.dungdao.controller;

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

import Shop24h.dungdao.entity.Category;
import Shop24h.dungdao.service.CategoryService;

@Controller
@RequestMapping("/admin")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/listCategory")
	public ModelAndView listCategory() {
		ModelAndView m = new ModelAndView("admin/listCategory");
		m.addObject("allCategory", categoryService.getAll());
		return m;
	}

	@GetMapping("/createCategory")
	public ModelAndView createCategory() {
		ModelAndView m = new ModelAndView("admin/createCategory");
		return m;
	}

	@GetMapping("/editCategory/{id}")
	public String editCategory(@PathVariable("id") Integer id, ModelMap map) {
		Category category = categoryService.getOne(id);
		if (category == null) {
			return "redirect:/admin/listCategory";
		}
		if (category != null) {
			map.addAttribute("editCategory", category);
		}
		return "admin/updateCategory";
	}

	@PostMapping("/createCategory")
	public ModelAndView createCategory(@RequestParam("name") String name) {
		try {
			Category category = new Category();
			category.setName(name);
			categoryService.createCategory(category);
			return new ModelAndView("redirect:/admin/listCategory");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/listCategory");
	}

	@GetMapping("/listCategory/delete/{id}")
	public String deleteCategory(@PathVariable("id") Integer id, RedirectAttributes ra) {
		String message = "Bạn phải xóa khóa ngoại của bảng trước!";
		try {
			boolean result = categoryService.deleteCategory(id);
			message = result == true ? "Bạn đã xóa thánh công!" : "Bạn xóa không thành công!";
		} catch (Exception e) {
			e.printStackTrace();
		}
		ra.addFlashAttribute("message", message);
		return "redirect:/admin/listCategory";
	}

	@PostMapping("/editCategory/{id}")
	public ModelAndView editCategory(@PathVariable("id") Integer id, @RequestParam("name") String name) {
		try {
			Category category = new Category();
			category.setId(id);
			category.setName(name);
			categoryService.updateCategory(category);
			return new ModelAndView("redirect:/admin/listCategory");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("redirect:/admin/listCategory");
	}

}