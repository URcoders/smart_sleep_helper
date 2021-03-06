package com.linxu.pillow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author linxu
 * @date 2019/4/13
 */
@SpringBootApplication
@EnableAutoConfiguration()
@ServletComponentScan
@EnableTransactionManagement
public class PillowApplication {

    public static void main(String[] args) {
        SpringApplication.run(PillowApplication.class, args);
    }

}
