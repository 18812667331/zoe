package com.zoe.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserCtrl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zoe 515165137@qq.com
 * @date 2017年12月26日 上午10:06:21
 *
 */
@RestController
public class UserCtrl {
	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(request.getAttribute("id"));
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id);
		return "id:" + id + "pwd:" + pwd;
	}

	// @RequestMapping("/login")
	// public String login(HttpServletRequest request, HttpServletResponse response)
	// {
	// String id = request.getParameter("id");
	// System.out.println(id);
	// String pwd = request.getParameter("pwd");
	// return "id:" + id + "pwd:" + pwd;
	// }
}
