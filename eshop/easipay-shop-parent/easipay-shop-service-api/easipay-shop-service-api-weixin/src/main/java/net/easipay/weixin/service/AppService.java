package net.easipay.weixin.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.easipay.weixin.entity.AppEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author fli
 * @version 1.0
 * @date 2020/3/1 17:44
 * @description: app服务
 */
@Api(tags = "微信接口服务")
public interface AppService {
    /**
     * 获取app应用信息
     *
     * @return AppEntity
     */
    @ApiOperation("查询微信应用商户接口")
    @GetMapping("/getApp")
    public AppEntity getApp();

}
