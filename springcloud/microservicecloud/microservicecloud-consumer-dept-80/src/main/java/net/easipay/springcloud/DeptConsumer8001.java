package net.easipay.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author fli
 * @version 1.0
 * @date 2020/2/26 20:05
 */
@EnableFeignClients
@SpringCloudApplication
public class DeptConsumer8001 {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer8001.class, args);
    }
}
