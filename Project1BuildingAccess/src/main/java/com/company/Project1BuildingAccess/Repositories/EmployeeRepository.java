package com.company.Project1BuildingAccess.Repositories;

import com.company.Project1BuildingAccess.dto.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

    Employees findByUserId(int id);

    //get a list of employees by company name
    List<Employees> findByCompanyName(String companyName);
}
