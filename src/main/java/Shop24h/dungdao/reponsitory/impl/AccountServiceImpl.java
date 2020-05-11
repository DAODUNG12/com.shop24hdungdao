package Shop24h.dungdao.reponsitory.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Shop24h.dungdao.commom.Base;
import Shop24h.dungdao.entity.Account;
import Shop24h.dungdao.oo.AccountVo;
import Shop24h.dungdao.reponsitory.AccountRepository;
import Shop24h.dungdao.service.AccountService;
import org.hibernate.Session;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private EntityManager entityManager;

	// login
	@Override
	public Account login(String username, String password) {
		password = Base.encryptPassword(password);
		Account account = accountRepository.login(username, password);
		if (account == null)
			return null;
		return account;
	}

	// get one
	@Override
	public Account getOne(String username) {
		Optional<Account> account = accountRepository.findById(username);
		if (!account.isPresent())
			return null;
		return account.get();
	}

	// Get All
	@Override
	public List<Account> getAll() {
		return accountRepository.findAll();
	}

	// list Account by page

	@Override
	public List<AccountVo> getAccountByPage(int pageNumber, int pageSize, String search) {
		List<AccountVo> voList = new ArrayList<AccountVo>();
		String sql = "FROM Account ";
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
			List<Account> listResult = q.getResultList();

			for (Account account : listResult) {
				AccountVo vo = new AccountVo();
				vo.setUsername(account.getUsername());
				vo.setName(account.getName());
				vo.setGender(account.getGender());
				vo.setAge(account.getAge());
				vo.setPhone(account.getPhone());
				vo.setAddress(account.getAddress());
				vo.setTypeUser(account.getTypeUser());
				vo.setEmail(account.getEmail());
				voList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return voList;
	}

	// List Account search by page
	@Override
	public List<AccountVo> getAccountSearchByPage(String search) {
		List<AccountVo> voList = new ArrayList<AccountVo>();
		String sql = "FROM Account ";
		if (!search.isEmpty()) {
			sql += "where" + search;
		}
		try {
			Session session = (Session) entityManager.getDelegate();
			Query q = session.createQuery(sql);

			@SuppressWarnings("unchecked")
			List<Account> listResult = q.getResultList();

			for (Account account : listResult) {
				AccountVo vo = new AccountVo();
				vo.setUsername(account.getUsername());
				vo.setName(account.getName());
				vo.setGender(account.getGender());
				vo.setAge(account.getAge());
				vo.setPhone(account.getPhone());
				vo.setAddress(account.getAddress());
				vo.setTypeUser(account.getTypeUser());
				vo.setEmail(account.getEmail());
				voList.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return voList;
	}

	// Create Account
	@Override
	public Account CreateAccount(Account account) {
		if (getOne(account.getUsername()) != null)
			return null;
		account.setPassword(Base.encryptPassword(account.getPassword()));
		account = accountRepository.save(account);
		return account;
	}

	// Update Account
	@Override
	public boolean updateAccount(Account account, String username) {
		if (getOne(username) == null)
			return false;
		return accountRepository.save(account) != null;
	}

	// Delete Account
	@Override
	public void deleteAccount(String username) {
		accountRepository.deleteById(username);

	}

}
