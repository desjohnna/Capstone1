package com.company.Project1BuildingAccess.ServiceLayers;

import com.company.Project1BuildingAccess.Repositories.EmployeeRepository;
import com.company.Project1BuildingAccess.dto.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class EmployeeServiceLayer {
    @Autowired
    EmployeeRepository employeeRepo;

    //CRUD Routes
    public Employees findByUserId(int id) {
        return employeeRepo.findByUserId(id);
    }


    public Employees createEmployee(Employees employee) {
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(int id) {
        employeeRepo.deleteById(id);
    }

    public Employees updateEmployee(Employees employee, int id) {
        if (employee.getUserId() != id) {
            throw new IllegalArgumentException("No such ID exists, please enter a valid ID.");
        }
        return employeeRepo.save(employee);
    }

    //Creating a method that gets all employees and returns them to a list.
    //This is the list used in the stream that filters by Employees by Company Name.
    public List<Employees> employeesList() {
        return employeeRepo.findAll();
    }

    //Custom method
    public List<Employees> findByCompanyName(String companyName) {
        return employeeRepo.findByCompanyName(companyName);
    }
}
