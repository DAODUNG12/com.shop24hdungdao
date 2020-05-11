package Shop24h.dungdao.reponsitory.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Shop24h.dungdao.entity.Product;
import Shop24h.dungdao.oo.ProductVo;
import Shop24h.dungdao.reponsitory.ProductRepository;
import Shop24h.dungdao.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Product> getAllProduct() {
		List<Product> productList = productRepository.findAll();
		return productList;
	}

	@Override
	public List<ProductVo> getProductByPage(int pageNumber, int pageSize, String search) {
		List<ProductVo> voList = new ArrayList<ProductVo>();
		String sql = "FROM Product ";
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
			List<Product> listResult = q.getResultList();

			for (Product product : listResult) {
				ProductVo vo = new ProductVo();
				vo.setId(product.getId());
				vo.setName(product.getName());
				vo.setPrice(product.getPrice());
				vo.setImage(product.getImage());
				vo.setDetail(product.getDetail());
				vo.setQuantity(product.getQuantity());
				vo.setCategory(product.getCategory());
				voList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return voList;
	}

	@Override
	public List<ProductVo> getProductSearchByPage(String search) {
		List<ProductVo> voList = new ArrayList<ProductVo>();
		String sql = "FROM Product ";
		if (!search.isEmpty()) {
			sql += "where" + search;
		}
		try {
			Session session = (Session) entityManager.getDelegate();
			Query q = session.createQuery(sql);

			@SuppressWarnings("unchecked")
			List<Product> listResult = q.getResultList();

			for (Product product : listResult) {
				ProductVo vo = new ProductVo();
				vo.setId(product.getId());
				vo.setName(product.getName());
				vo.setPrice(product.getPrice());
				vo.setImage(product.getImage());
				vo.setDetail(product.getDetail());
				vo.setQuantity(product.getQuantity());
				vo.setCategory(product.getCategory());
				voList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return voList;
	}

	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product getOne(Integer id) {
		return productRepository.getOne(id);
	}

	@Override
	public boolean updateProduct(Product product) {
		boolean result = false;
		try {
			productRepository.save(product);
			result = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean deleteProduct(Integer id) {
		if (id != null) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}

}
