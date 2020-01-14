package org.starrysea.mail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("org.starrysea.**.dao")
@EnableTransactionManagement
//@EnableSwagger2
public class MailApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MailApiApplication.class, args);
    }
}
