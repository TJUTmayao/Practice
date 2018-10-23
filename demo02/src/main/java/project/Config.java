package project;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.MultipartConfigElement;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/10/23 10:08
 * @Description:
 */
@Configuration
public class Config {

   /* @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("5MB");
        factory.setMaxRequestSize("5MB");
        return factory.createMultipartConfig();
    }*/
}
