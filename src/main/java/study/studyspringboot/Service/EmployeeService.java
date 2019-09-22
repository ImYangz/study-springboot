package study.studyspringboot.Service;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import study.studyspringboot.dao.EmployeeDao;
import study.studyspringboot.entity.Employee;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeDao employeeDao;

    public String save(String name, Integer age) {
        Employee e1 = new Employee(name, age);
        System.out.println(employeeDao);
        System.out.println(EmployeeService.class.getName());
        employeeDao.save(e1);
        return "success";
    }

    ;

    public String deleteById(Integer id) {
        employeeDao.deleteById(id);
        return "success";
    }

    public List<Employee> getAll(){
        List<Employee> employees = employeeDao.findAll();
        return employees;
    }

    public Employee addOne(String name,Integer age){
        Employee employee = new Employee(name,age);
        employeeDao.save(employee);
        return employee;
    }
}
