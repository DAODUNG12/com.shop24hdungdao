package Shop24h.dungdao.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import Shop24h.dungdao.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String> {

	@Query("SELECT a FROM Account a WHERE a.username = ?1 AND a.password = ?2")
	Account login(String username, String password);

}
