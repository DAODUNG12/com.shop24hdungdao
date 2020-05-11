package Shop24h.dungdao.service;

import java.util.List;

import Shop24h.dungdao.entity.Account;
import Shop24h.dungdao.oo.AccountVo;


public interface AccountService {

	
	Account login(String username, String password);

	
	Account getOne(String username);

	
	List<Account> getAll();

	
	List<AccountVo> getAccountByPage(int pageNumber, int pageSize, String search);

	
	public List<AccountVo> getAccountSearchByPage(String search);

	
	Account CreateAccount(Account account);

	
	boolean updateAccount(Account account, String username);

	
	void deleteAccount(String username);

}
