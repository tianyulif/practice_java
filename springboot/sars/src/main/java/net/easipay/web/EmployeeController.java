package net.easipay.web;

import net.easipay.model.Employee;
import net.easipay.net.easipay.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getEmployee/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        Employee e = employeeService.getById(id);
        System.out.println(e);
        return e;
    }

    @GetMapping("/delEmployee/{id}")
    public Employee delEmployee(@PathVariable("id") Integer id){
        Employee e = employeeService.getById(id);
        System.out.println(e);
        employeeService.delete(e);
        return e;
    }

    @GetMapping("/updateEmployee")
    public Employee update(Employee employee){
        Employee emp = employeeService.update(employee);
        return emp;
    }

    @PostMapping("/saveEmployee")
    public Employee saveEmployee(){
        Employee employee = new Employee();
        employee.setLastName("jack");
        employee.setEmail("jack@easipay.net");
        employee.setGender(1);
        employee.setdId(1);
        employeeService.save(employee);
        return employee;
    }
}
