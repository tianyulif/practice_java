package net.easipay.springcloud.controller;


import net.easipay.springcloud.model.Dept;
import net.easipay.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author fli
 */
@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @PostMapping("/dept/add")
    public Dept add(Dept dept)
    {
        return deptService.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id)
    {
        return deptService.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> list()
    {
        return deptService.list();
    }
}
