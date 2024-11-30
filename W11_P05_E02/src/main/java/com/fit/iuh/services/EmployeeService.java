package com.fit.iuh.services;

import com.fit.iuh.entities.Employee;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {

    Employee findById(int id);

    List<Employee> findAll();

    Page<Employee> findAllWithPaging(int page, int size, String sorBy, String sortDirection);

    Employee save(Employee employee);

    Employee update(int id, Employee employee);

    boolean deleteById(int id);

    List<Employee> search(String keyword);

}
