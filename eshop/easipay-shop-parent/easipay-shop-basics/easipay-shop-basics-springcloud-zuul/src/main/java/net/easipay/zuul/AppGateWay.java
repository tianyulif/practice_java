package net.easipay.zuul;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: fli
 * @date: 2020/3/1 20:50
 * @version: 1.0
 * @description: 微服务网关入口
 */
@SpringBootApplication
@EnableSwagger2Doc
@EnableEurekaClient
@EnableZuulProxy
public class AppGateWay {

    public static void main(String[] args) {
        SpringApplication.run(AppGateWay.class,args);
    }


    /**
     *  添加文档来源
     *  网关使用服务别名获取远程服务SwaggerApi
     */
    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider {

        @Override
        public List<SwaggerResource> get() {
            List resources = new ArrayList<SwaggerResource>();
            // app-itmayiedu-order
            resources.add(swaggerResource("app-easipay-member", "/app-easipay-member/v2/api-docs", "2.0"));
            resources.add(swaggerResource("app-easipay-weixin", "/app-easipay-weixin/v2/api-docs", "2.0"));
            return resources;
        }

        private SwaggerResource swaggerResource(String name, String location, String version) {
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }

    }

}
