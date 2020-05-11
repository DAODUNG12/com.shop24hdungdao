package TestassSof304;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.poi.hssf.record.formula.functions.Count;
import org.apache.taglibs.standard.tag.el.fmt.BundleTag;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.OngoingStubbing;
import org.mockito.verification.VerificationMode;
import org.springframework.data.domain.Example;

import com.google.common.base.Verify;

import Shop24h.dungdao.entity.Account;
import Shop24h.dungdao.oo.AccountVo;
import Shop24h.dungdao.reponsitory.AccountRepository;
import Shop24h.dungdao.reponsitory.impl.AccountServiceImpl;
import Shop24h.dungdao.service.AccountService;

// Tạo 1 class service test
@RunWith(MockitoJUnitRunner.class)
public class TestAccountService implements AccountService {

	// Giả lập repository
	@Mock
	private AccountRepository repository;

	// Giả lập service
	@InjectMocks
	private AccountServiceImpl service;

	private static List<Account> list;
	private static Account acc;

	// Nơi viết những thứ chạy trc khi chạy function test như giả lập data
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		list = new ArrayList<>();
		acc = new Account();
		acc.setUsername("dung");
		acc.setName("dao van dung");
		acc.setPassword("123456");

		list.add(acc);
		String id = "dung";

	}

	// 1 function test getAll account
	@Test
	public void getAllAccountSuccessHaveData() {

		when(repository.findAll()).thenReturn(list);

		assertEquals(1, service.getAll().size());
		assertEquals("dung", service.getAll().get(0).getUsername());

	}

	// 1 function test getOne account
	@Test
	public void getOneAccountTestSuccess() {
		Account result = new Account();
		result.setUsername("dung");
		result.setName("dao van dung");
		Optional<Account> userOptional = Optional.of(result);

		when(repository.findById(acc.getUsername())).thenReturn(userOptional);

		assertEquals("dao van dung", service.getOne("dung").getName());

	}

	// 1 function test CreateAccountTestSuccess
	@Test
	public void CreateAccountTestSuccess() {
		Account role = new Account();
		role.setUsername("dung");
		role.setPassword("123456");
		assertNotNull(role);
		assertNotNull(acc);
		assertEquals("dung", role.getUsername());
		assertEquals("123456", role.getPassword());
	}

	// 1 function test UpdateAccountTestSucess
	@Test
	public void UpdateAccountTestSucess() {
		Account updatedUser = new Account();
		updatedUser.setUsername("dung");

		assertNotNull(updatedUser);
		assertNotNull(acc);

		assertEquals("dung", updatedUser.getUsername());

	}

	@Test
	public void deleteAccount() {
		

	}

	@Override
	public Account login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getOne(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Account> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountVo> getAccountByPage(int pageNumber, int pageSize, String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountVo> getAccountSearchByPage(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account CreateAccount(Account account) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateAccount(Account account, String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void deleteAccount(String username) {
		// TODO Auto-generated method stub
		
	}

}
