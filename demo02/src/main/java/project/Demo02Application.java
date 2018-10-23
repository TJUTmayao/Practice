package project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/* 扫描**mapper.xml文件的接口 */
@MapperScan("project.dao")
public class Demo02Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo02Application.class, args);
    }
}
