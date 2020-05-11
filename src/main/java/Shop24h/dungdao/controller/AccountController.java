package Shop24h.dungdao.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import Shop24h.dungdao.entity.Account;
import Shop24h.dungdao.service.AccountService;

@Controller
@RequestMapping("")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping("/login")
	public String login() {
		
		return "admin/login";
	}

	@GetMapping("/register")
	public String register() {
		return "admin/register";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("currentAccount", null);
		session.removeAttribute("currentAccount");
		return "redirect:/home";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, HttpSession session,
			RedirectAttributes ra) {
		Account account = accountService.login(username, password);
		if (account == null) {
			ra.addFlashAttribute("message", "Tai khoan hoac mat khau khong chinh xac");
			return "redirect:admin/login";
		}
		if (account.getTypeUser().equals("KH")) {
			session.setAttribute("currentAccount", account);
			ra.addFlashAttribute("message", "Chào mừng qúy khách <b>" + account.getName() + "<b> đã đăng nhập !");
			return "redirect:/";
		}
		session.setAttribute("currentAccount", account);
		ra.addFlashAttribute("message", "Chào mừng Admin <b>" + account.getName() + "<b> đã đăng nhập !");
		return "redirect:/admin/admin";

	}

	@PostMapping("/register")
	public String register(@ModelAttribute Account account, RedirectAttributes ra) {
		account.setTypeUser("Admin");
		Account accounts = accountService.CreateAccount(account);
		if (accounts != null) {
			ra.addFlashAttribute("account", new Account());
			ra.addFlashAttribute("message", "Chúc mừng bạn đã đăng ký thành công !");
			return "redirect:";
		} else {
			ra.addFlashAttribute("account", account);
			ra.addFlashAttribute("message",
					"Đăng ký thất bại, tên đăng nhập <b>" + account.getUsername() + "</b> này đã tồn tại !");
			return "redirect:/home/register";
		}
	}

}
