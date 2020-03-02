package net.easipay.member.service;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.easipay.weixin.entity.AppEntity;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: fli
 * @date: 2020/3/1 17:49
 * @version: 1.0
 * @description:
 */
@Api(tags = "会员服务接口")
public interface MemberService {

    @ApiOperation(value = "会员调用微信接口")
    @GetMapping("/memberInvokWeixin")
    public AppEntity memberInvokWeixin();

}