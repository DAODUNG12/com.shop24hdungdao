package Shop24h.dungdao.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Shop24h.dungdao.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

}

