package com.fit.iuh.services.impl;

import com.fit.iuh.entities.Employee;
import com.fit.iuh.repositories.EmployeeRepository;
import com.fit.iuh.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAllWithPaging(int page, int size, String sorBy, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sorBy).ascending() : Sort.by(sorBy).descending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(int id, Employee employee) {
        this.findById(id);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public boolean deleteById(int id) {
        Employee employee = this.findById(id);
        employeeRepository.delete(employee);
        return true;
    }

    @Override
    public List<Employee> search(String keyword) {
        return employeeRepository.search(keyword);
    }

}
