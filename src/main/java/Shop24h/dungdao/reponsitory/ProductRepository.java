package Shop24h.dungdao.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Shop24h.dungdao.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
