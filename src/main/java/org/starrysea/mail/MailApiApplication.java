package org.starrysea.mail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.starrysea.**.mapper")
public class MailApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailApiApplication.class, args);
    }
}
