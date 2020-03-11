package com.bookstore.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.domain.User;
import com.bookstore.service.UserService;

@Controller
public class LoginController {
    @Autowired
	private UserService userService;
	@RequestMapping("/login")
    public ModelAndView login(User user, HttpSession session) {	
		User checkUser = userService.checkUp(user, false);
		ModelAndView mv = new ModelAndView();
    	if(checkUser == null) {
    		mv.addObject("msg","账号密码错误！请重新输入！");
    		mv.setViewName("login");
    	}else {
    		session.setAttribute("userID", checkUser.getId());
    		session.setAttribute("username", checkUser.getUsername());
    		mv.setViewName("redirect:/index.jsp");
    	}
		return mv;
    }
	
	@RequestMapping("/adlogin")
	public ModelAndView adLogin(User user, HttpSession session) {
		User checkUser = userService.checkUp(user, true);
		ModelAndView mv = new ModelAndView();
    	if(checkUser == null) {
    		mv.addObject("msg","账号密码错误！请重新输入！");
    		mv.setViewName("backLogin");
    	}else {
    		session.setAttribute("adID", checkUser.getId());
    		session.setAttribute("adUsername", checkUser.getUsername());
    		mv.setViewName("redirect:/pages/backIndex.jsp");
    	}
		return mv;
	}
	
	@ResponseBody
	@RequestMapping("/loginOut")
	public String loginOut(HttpSession session) {
		System.out.println("退出登陆成功！");
		session.removeAttribute("userID");
		session.removeAttribute("username");
		session.invalidate();
		return "200";
	}
	
	
}
