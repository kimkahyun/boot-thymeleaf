package idu.cs.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import idu.cs.domain.User;
import idu.cs.repository.UserRepository;

@Controller
public class HomeController {
	@Autowired UserRepository userRepo;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("test","인덕컴소");
		model.addAttribute("kkh","김가현");
		return "index";
	}
	@GetMapping("/users")
	public String getAllUser(Model model) {
		model.addAttribute("user",userRepo.findAll());
		return "userlist";
	}
	@PostMapping("/users")
	public String createUser(@Valid @RequestBody User user, Model model) {
		userRepo.save(user);
		model.addAttribute("user",userRepo.findAll());
		return "redirect:/users";
	}
}
