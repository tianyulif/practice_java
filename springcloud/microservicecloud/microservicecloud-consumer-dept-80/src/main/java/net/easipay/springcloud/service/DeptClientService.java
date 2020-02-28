package net.easipay.springcloud.service;

import net.easipay.springcloud.model.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fli
 * @version 1.0
 * @date 2020/2/27 20:13
 */
@FeignClient(value = "MICROSERVICECLOUD-DEPT", fallback = DeptClientServiceHystrix.class)
public interface DeptClientService {

    @PostMapping("/dept/add")
    public Dept add(Dept dept);

    @GetMapping(value = "/dept/get/{id}")
    public Dept get(@PathVariable("id") Long id);

    @GetMapping(value = "/dept/list")
    public List<Dept> list();

}
