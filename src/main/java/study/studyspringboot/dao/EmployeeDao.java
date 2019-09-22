package study.studyspringboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import study.studyspringboot.entity.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer> {

}
