package com.fit.iuh.controllers;

import com.fit.iuh.entities.Employee;
import com.fit.iuh.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees/{id}")
    public ResponseEntity<Map<String, Object>> getAllEmployeeById(@PathVariable int id) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("data", employeeService.findById(id));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Map<String, Object>> saveEmployee(@Valid @RequestBody Employee employee, BindingResult bindingResult) {
        Map<String, Object> response = new LinkedHashMap<>();
        if (bindingResult.hasErrors()) {
            Map<String, Object> errors = new LinkedHashMap<>();
            bindingResult.getFieldErrors().stream().forEach(result -> {
                errors.put(result.getField(), result.getDefaultMessage());
            });

            response.put("status", HttpStatus.BAD_REQUEST.value()); // 400
            response.put("errors", errors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            response.put("status", HttpStatus.OK.value());
            response.put("data", employeeService.save(employee));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Map<String, Object>> updateEmployee(@PathVariable int id, @Valid @RequestBody Employee
            employee, BindingResult bindingResult) {
        Map<String, Object> response = new LinkedHashMap<>();
        if (bindingResult.hasErrors()) {
            Map<String, Object> errors = new LinkedHashMap<>();
            bindingResult.getFieldErrors().forEach(result -> {
                errors.put(result.getField(), result.getDefaultMessage());
            });

            response.put("status", HttpStatus.BAD_REQUEST.value());
            response.put("errors", errors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        } else {
            response.put("status", HttpStatus.OK.value());
            response.put("data", employeeService.update(id, employee));
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable int id) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", HttpStatus.OK.value());
        response.put("data", employeeService.deleteById(id));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/employees")
    public ResponseEntity<Map<String, Object>> getEmployees(@RequestParam(required = false) String keyword) {
        Map<String, Object> response = new LinkedHashMap<>();
        response.put("status", HttpStatus.OK.value());

        if (keyword == null || keyword.isEmpty()) {
            response.put("data", employeeService.findAll());
        } else {
            response.put("data", employeeService.search(keyword));
        }

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
