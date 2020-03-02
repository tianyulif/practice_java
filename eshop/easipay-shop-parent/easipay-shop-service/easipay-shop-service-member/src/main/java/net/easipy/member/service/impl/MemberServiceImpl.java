package net.easipy.member.service.impl;


import net.easipay.member.service.MemberService;
import net.easipay.weixin.entity.AppEntity;
import net.easipy.member.feign.AppServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: fli
 * @date: 2020/3/1 18:36
 * @version: 1.0
 * @description:
 */
@RestController
public class MemberServiceImpl implements MemberService {

    @Autowired
    private AppServiceFeign appServiceFeign;

    public AppEntity memberInvokWeixin() {
        return appServiceFeign.getApp();
    }
}
