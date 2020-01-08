package org.starrysea.mail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@MapperScan("org.starrysea.**.mapper")
public class MailApiApplication {
    @RequestMapping("/Hello")
    public static void main(String[] args) {
        SpringApplication.run(MailApiApplication.class, args);
    }
}
