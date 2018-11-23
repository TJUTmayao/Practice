package TestAspectJ;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 说明：
 *
 * @Auther: 11432_000
 * @Date: 2018/11/8 13:43
 * @Description:
 */
/* 生效时机 */
@Retention(RetentionPolicy.RUNTIME)
/* 注解的位置 */
@Target(ElementType.METHOD)
public @interface MyAnnotation {
    String value();
}
