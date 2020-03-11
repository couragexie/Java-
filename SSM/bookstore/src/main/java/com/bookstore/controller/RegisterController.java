package com.bookstore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.domain.User;
import com.bookstore.service.UserService;

@Controller
public class RegisterController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/register")
	public ModelAndView register(@Valid User user, BindingResult errorResult, Model model) {	
		ModelAndView mv = new ModelAndView();
		System.out.println(user);
		boolean hasError = errorResult.hasErrors();
		Map<String, Object> errorMap = null;
		// 校验字段
		if(hasError) {
			errorMap = handleError(errorResult);
			model.addAttribute("errorInfo",errorMap );
			mv.setViewName("register");
			return mv;
		}
		
		if(userService.register(user)) {
			mv.addObject("username", user.getUsername());
			mv.setViewName("redirect:/pages/login.jsp");
		}else {
			mv.addObject("msg", "注册失败，用户名已存在!");
			mv.setViewName("register");
		}
		return mv;
	}
	
	private Map handleError(BindingResult errorResult) {
		List<FieldError> errors = errorResult.getFieldErrors();		
		Map<String, Object> errorMap = new HashMap<String, Object>();
		for(FieldError error: errors) {	
			System.out.println("错误信息提示：" + error.getDefaultMessage());
			System.out.println("错误字段时：" + error.getField());
			System.out.println(error);
			System.out.println("==================================");
			errorMap.put(error.getField(), error.getDefaultMessage());
		}
		return errorMap;
	}
	
}
