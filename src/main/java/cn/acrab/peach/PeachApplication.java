package cn.acrab.peach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 使用EnableScheduling注解开启定时任务
 *
 * */

@SpringBootApplication
@EnableScheduling
public class PeachApplication {

    public static void main(String[] args) {
        SpringApplication.run(PeachApplication.class, args);
    }
}
