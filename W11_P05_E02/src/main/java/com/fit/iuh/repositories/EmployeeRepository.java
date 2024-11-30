package com.fit.iuh.repositories;

import com.fit.iuh.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    @Query("SELECT e " +
            "FROM Employee e " +
            "WHERE e.firstName LIKE %:keyword% " +
            "OR e.lastName LIKE %:keyword% " +
            "OR e.emailAddress LIKE %:keyword% " +
            "OR e.phoneNumber LIKE %:keyword%")
    List<Employee> search(@Param("keyword") String keyword);

}
