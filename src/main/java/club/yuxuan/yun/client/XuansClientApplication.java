package club.yuxuan.yun.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class XuansClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(XuansClientApplication.class, args);
    }

}
