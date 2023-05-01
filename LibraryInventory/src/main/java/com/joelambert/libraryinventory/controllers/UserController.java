package com.joelambert.libraryinventory.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.joelambert.libraryinventory.models.LoginUser;
import com.joelambert.libraryinventory.models.User;
import com.joelambert.libraryinventory.services.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userServ;
	
	@GetMapping("/")
	public String index(
			@ModelAttribute("newUser") User emptyUser,
			@ModelAttribute("newLogin") LoginUser emptyLoginUser
	) {
		return "/user/index.jsp";
	}

	// PROCESS REGISTER
	@PostMapping("/register")
	public String register(
		@Valid @ModelAttribute("newUser") User filledUser,
		BindingResult results,
		HttpSession session,
		Model model
	) {
		User createdUser = userServ.register(filledUser, results);
		if(results.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "/user/index.jsp";
		}
		// SAVE THE USER'S ID IN SESSION
		session.setAttribute("user_id", createdUser.getId());
		return "redirect:/books";
	}
	
	// PROCESS LOGIN
	@PostMapping("/login")
	public String login(
		@Valid @ModelAttribute("newLogin") LoginUser filledLoginUser,
		BindingResult results,
		HttpSession session,
		Model model
	) {
		User loggedUser = userServ.login(filledLoginUser, results);
		if(results.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "/user/index.jsp";
		}
		// SAVE THE USER'S ID IN SESSION
		session.setAttribute("user_id", loggedUser.getId());
		return "redirect:/books";
	}

//	// CHECK TO SEE IF CURRENT USER IS IN SESSION
//	@GetMapping("/homepage")
//	public String homepage(
//		HttpSession session,
//		Model model
//	) {
//		Long userId = (Long) session.getAttribute("user_id");
//		if(userId == null) {
//			return "redirect:/";
//		}
//		// GRAB ONE USER FROM DB
//		User oneUser = userServ.getOneUser(userId);
//		// PASS ONE USER TO JSP
//		model.addAttribute("oneUser", oneUser);
//		return "dashboard.jsp";
//	}


	//-----------LOGOUT---------------
//	LOGOUT COMPLETELY
	@GetMapping("/logout")
	public String logout(
		HttpSession session
	) {
		session.invalidate();
		return "redirect:/";
	}

	
//	// TO REMOVE USER ID ONLY as in cases of shopping carts in commerce sites
//	@GetMapping("/logout")
//	public String logout(
//		HttpSession session
//	) {
//		session.removeAttribute("user_id");
//		return "redirect:/";
//	}

}
