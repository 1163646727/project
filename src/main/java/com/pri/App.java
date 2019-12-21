package com.pri;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * class name:App <BR>
 * class description: 项目启动入口 <BR>
 * Remark: <BR>
 * @version 1.00 2019年3月28日
 * @author **)ChenQi
 */
@MapperScan(basePackages = "com.pri.dao")
@SpringBootApplication
public class App extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	/**
	 * Method name: configure <BR>
	 * Description: 需要把web项目打成war包部署到外部tomcat运行时需要改变启动方式 <BR>
	 * Remark: <BR>
	 * @param builder
	 * @return  SpringApplicationBuilder<BR>
	 * @author )Mine+
	 */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(App.class);
    }
}
