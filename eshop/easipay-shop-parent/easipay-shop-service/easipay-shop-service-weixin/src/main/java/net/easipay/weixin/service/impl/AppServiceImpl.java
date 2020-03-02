package net.easipay.weixin.service.impl;

import net.easipay.weixin.entity.AppEntity;
import net.easipay.weixin.service.AppService;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: fli
 * @date: 2020/3/1 18:32
 * @version: 1.0
 * @description:
 */
@RestController
public class AppServiceImpl implements AppService {

    public AppEntity getApp() {
        return new AppEntity().setAppId("1234567").setAppSecret("1234567");
    }
}
