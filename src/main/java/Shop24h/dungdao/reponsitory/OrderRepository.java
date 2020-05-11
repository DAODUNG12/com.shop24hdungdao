package Shop24h.dungdao.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Shop24h.dungdao.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
