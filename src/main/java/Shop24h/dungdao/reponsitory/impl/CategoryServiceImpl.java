package Shop24h.dungdao.reponsitory.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Shop24h.dungdao.entity.Category;
import Shop24h.dungdao.reponsitory.CategoryRepository;
import Shop24h.dungdao.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category getOne(Integer id) {
		return categoryRepository.getOne(id);
	}

	@Override
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public boolean deleteCategory(Integer id) {
		if (id != null) {
			categoryRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCategory(Category category) {
		boolean result = false;
		try {
			categoryRepository.save(category);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
