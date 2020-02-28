package net.easipay.springcloud.controller;

import net.easipay.springcloud.model.Dept;
import net.easipay.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author fli
 * @version 1.0
 * @date 2020/2/23 22:27
 */
@RestController
public class DeptConsumerController {

    private static final String REST_URL_PREFIX = "http://MICROSERVICECLOUD-DEPT:8001";

    /**
     * 使用 使用restTemplate访问restful接口非常的简单粗暴无脑。 (url, requestMap,
     * ResponseBean.class)这三个参数分别代表 REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
     *
     *@Autowired
     *RestTemplate restTemplate;
     */
    @Autowired
    DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/add")
    public Dept add(Dept dept)
    {
        return deptClientService.add(dept);
    }

    @RequestMapping(value = "/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id)
    {
        //return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
        return deptClientService.get(id);
    }


    @RequestMapping(value = "/consumer/dept/list")
    public List<Dept> list()
    {
        return deptClientService.list();
    }

}
