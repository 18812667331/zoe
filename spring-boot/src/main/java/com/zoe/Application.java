package com.zoe;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: Application
 * @Description: (启动类)
 * @author zoe 515165137@qq.com
 * @date 2017年12月26日 上午10:01:18
 * @ImportResource(value = { "xxx.xml", "aaa.xml" }) 注解用来扫描xml文件
 *
 */
@SpringBootApplication
public class Application {

	@ResponseBody
	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

	/** 程序启动入口 **/
	public static void main(String[] args) throws IOException {
		SpringApplication app = new SpringApplication(Application.class);
		// app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
		System.out.println("spring-boot启动成功！");
	}
}