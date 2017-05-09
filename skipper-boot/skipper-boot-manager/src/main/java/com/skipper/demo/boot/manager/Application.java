package com.skipper.demo.boot.manager;

import org.aspectj.lang.annotation.Aspect;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.ws.rs.Path;


/**
 * application boot
 * <p>
 * Created by shoujian on 2017/5/9.
 */
@SpringBootApplication//spring boot注解
@ComponentScan(//包扫描配置
        basePackages = {"com.skipper"},//需要扫描的package路径
        //useDefaultFilters = false,     //默认为true，此时Spring扫描类时发现如果其被标注为
        // @Component、@Repository、@Service、@Controller则自动实例化为bean并将其添加到上下文中，
        // 如果设置为false，即使将其标注为@Component或者其他，Spring都会忽略
        includeFilters = {      //指定扫描时需要实例化的类型
                @ComponentScan.Filter(Path.class),//扫描含有path注解的类将其实例化
                @ComponentScan.Filter(Aspect.class)//扫描含有aspect注解的类将其实例化
        }
)
@MapperScan(//mapper扫描
        basePackages = {"com.skipper.dao.demo"}
)
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        //从main方法启动spring应用的类
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);

    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(Application.class);
    }

}
