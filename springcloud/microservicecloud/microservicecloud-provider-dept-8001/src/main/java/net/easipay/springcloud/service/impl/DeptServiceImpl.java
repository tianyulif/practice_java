package net.easipay.springcloud.service.impl;

import net.easipay.springcloud.model.Dept;
import net.easipay.springcloud.repository.DeptRepository;
import net.easipay.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author fli
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptRepository deptRepository;

    @Override
    public Dept add(Dept dept) {
        return deptRepository.save(dept);
    }

    @Override
    public Dept get(Long id) {
        return deptRepository.getOne(id);
    }

    @Override
    public List<Dept> list() {
        return deptRepository.findAll();
    }
}
