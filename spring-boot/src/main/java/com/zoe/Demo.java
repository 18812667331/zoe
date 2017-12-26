package com.zoe;

import java.io.IOException;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;



/**
 * @ClassName: Demo
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zoe 515165137@qq.com
 * @date 2017年12月26日 上午10:05:08
 *
 */
@SpringBootApplication
public class Demo {

	public static void main(String[] args) throws IOException {
		// 程序启动入口
		// Properties properties = new Properties();
		// InputStream in =
		// Application.class.getClassLoader().getResourceAsStream("application.properties");
		// properties.load(in);
		// SpringApplication app = new SpringApplication(Application.class);
		// app.setDefaultProperties(properties);
		// app.run(args);
		SpringApplication.run(Demo.class, args);
		System.out.println("spring-boot启动成功！");
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				System.out.println(beanName);
			}

		};
	}

}