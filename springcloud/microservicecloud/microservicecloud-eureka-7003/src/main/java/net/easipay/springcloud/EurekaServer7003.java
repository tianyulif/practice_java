package net.easipay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author fli
 * @version 1.0
 * @date 2020/2/25 21:59
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer7003 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7003.class,args);
    }
}