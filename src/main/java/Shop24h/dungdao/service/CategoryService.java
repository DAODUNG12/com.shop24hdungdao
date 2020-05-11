package Shop24h.dungdao.service;

import java.util.List;

import Shop24h.dungdao.entity.Category;

public interface CategoryService {

	List<Category> getAll();

	Category getOne(Integer id);

	Category createCategory(Category category);

	boolean deleteCategory(Integer id);

	boolean updateCategory(Category category);

}
