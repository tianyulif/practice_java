package net.easipay.springcloud.service;

import net.easipay.springcloud.model.Dept;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fli
 * @version 1.0
 * @date 2020/2/27 22:00
 */
@Component
public class DeptClientServiceHystrix implements DeptClientService{

    @Override
    public Dept add(Dept dept) {
        return new Dept().setId(0L).setDeptName("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
                .setDbSource("no this database in MySQL");
    }

    @Override
    public Dept get(Long id) {
        return new Dept().setId(id).setDeptName("该ID："+id+"没有没有对应的信息,null--@HystrixCommand")
                .setDbSource("no this database in MySQL");
    }

    @Override
    public List<Dept> list() {
        return null;
    }
}
