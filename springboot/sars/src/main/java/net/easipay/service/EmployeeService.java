package net.easipay.net.easipay.service;

import net.easipay.model.Employee;
import net.easipay.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     *
     *
     *  属性：
     *  cacheNames/value：指定缓存组件的名字;将方法的返回结果放在哪个缓存中，是数组的方式，可以指定多个缓存；
     *  key：缓存数据使用的key；可以用它来指定。默认是使用方法参数的值  1-方法的返回值
     *  编写SpEL； #id;参数id的值   #a0  #p0  #root.args[0]         getEmp[2]
     *  keyGenerator：key的生成器；可以自己指定key的生成器的组件id
     *      *              key/keyGenerator：二选一使用;
     *      *
     *      *
     *      *      cacheManager：指定缓存管理器；或者cacheResolver指定获取解析器
     *      *
     *      *      condition：指定符合条件的情况下才缓存；
     *      *              ,condition = "#id>0"
     *      *          condition = "#a0>1"：第一个参数的值》1的时候才进行缓存
     *      *
     *      *      unless:否定缓存；当unless指定的条件为true，方法的返回值就不会被缓存；可以获取到结果进行判断
     *      *              unless = "#result == null"
     *      *              unless = "#a0==2":如果第一个参数的值是2，结果不缓存；
     *      *      sync：是否使用异步模式
     *
     *
     *
     * @param id
     * @return
     */
    @Cacheable(cacheNames = "employee")
    public Employee getById(Integer id){
        return employeeRepository.getOne(id);
    }

    public Employee getByLastName(String lastname){
        return employeeRepository.findByLastName(lastname);
    }

    public Employee update(Employee e){
        if(e.getdId()==null){
            return e;
        }else{
            Employee employee = employeeRepository.getOne(e.getId());
            employee.setLastName(e.getLastName());
            employeeRepository.saveAndFlush(employee);
            return  employee;
        }
    }

    public Employee save(Employee e){
        return employeeRepository.save(e);
    }

    public void delete(Employee e){
        employeeRepository.deleteById(e.getId());
    }
}
