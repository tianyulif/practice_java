package net.easipay.springcloud.service;

import net.easipay.springcloud.model.Dept;

import java.util.List;

public interface DeptService {

    public Dept add(Dept dept);

    public Dept get(Long id);

    public List<Dept> list();

}
