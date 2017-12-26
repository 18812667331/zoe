package com.zoe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName: ForwardCtrl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zoe 515165137@qq.com
 * @date 2017年12月26日 上午10:05:14
 *
 */
@Controller
public class ForwardCtrl {
	@RequestMapping("/login")
	public String login() {
		System.out.println("进来了1");
		return "forward:/2";
	}

	@RequestMapping("/login2")
	public String login2() {
		System.out.println("进来了2");
		return "redirect:/2";
	}

	@RequestMapping("/login3")
	public String login3() {
		System.out.println("进来了3");
		return "1.jsp";
	}
}
