package top.jianx.coolq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 *
 * 这个是Spring的启动器, 或者说是Springboot的启动器。
 * 但是我并没有用到web、tomcat之类的东西，只是借用了一下Spring和Mybatis的整合
 *
 * @author jianx <[email]jianx@jianx.top>
 * @since JDK1.8
 **/
@SpringBootApplication
public class CoolqApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoolqApplication.class, args);
    }
    // 与robot框架进行整合的代码存在于 config包下的QQConfig类中。

    // 可以看一下controller.TestController类。这个类是SpringBoot中最基础的一个Controller类。
    // 只要没有报错，就代表启动并注入成功了。
}
