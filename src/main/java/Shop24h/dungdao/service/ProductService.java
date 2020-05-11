package Shop24h.dungdao.service;

import java.util.List;

import Shop24h.dungdao.entity.Product;
import Shop24h.dungdao.oo.ProductVo;

public interface ProductService {

	List<Product> getAllProduct();

	public List<ProductVo> getProductByPage(int pageNumber, int pageSize, String search);

	public List<ProductVo> getProductSearchByPage(String search);

	Product createProduct(Product product);

	Product getOne(Integer id);

	boolean updateProduct(Product product);

	boolean deleteProduct(Integer id);
}
