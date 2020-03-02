package net.easipy.member.feign;

import net.easipay.weixin.service.AppService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author: fli
 * @date: 2020/3/1 18:24
 * @version: 1.0
 * @description:
 */
@FeignClient(name = "app-service-weixin")
public interface AppServiceFeign extends AppService {
}
