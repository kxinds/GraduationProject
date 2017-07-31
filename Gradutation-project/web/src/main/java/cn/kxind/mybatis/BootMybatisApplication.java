package cn.kxind.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by kxinds on 2017/3/13 0013
 */
@ComponentScan(basePackages ="cn.kxind.mybatis")
@ServletComponentScan
@SpringBootApplication
public class BootMybatisApplication {
    public static void main(String[] args) {
        SpringApplication.run(BootMybatisApplication.class,args);
    }

}