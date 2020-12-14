package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {

    @RequestMapping("/")
    String hello() {
        return "Hello Spring Boot!";
    }

    @RequestMapping("/AAA")
String AAA() {
    return "AAA!";
}
    public static void main(String[] args) {

    	//スプリングブート起動時にインタフェースを利用したログの出力
        SpringApplication.run(DemoApplication.class, args);
        MessageBean beans = new MessageBeanJa();
        beans.sayHello("Springaaa");

        //DIを利用したログの出力
        //xmlファイルの情報を取得
        ApplicationContext app = new ClassPathXmlApplicationContext("beans2.xml");
        //xmlに紐づいたキー情報のインスタンスを生成
        MessageBean bean = app.getBean("message", MessageBean.class);
        bean.sayHello("Spring");
    }
   }
