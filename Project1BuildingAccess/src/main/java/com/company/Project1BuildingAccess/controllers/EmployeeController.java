package com.company.Project1BuildingAccess.controllers;

import com.company.Project1BuildingAccess.ServiceLayers.EmployeeServiceLayer;
import com.company.Project1BuildingAccess.dto.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeServiceLayer employeeService;

    //CRUD Method routes

    //GET an employee by userId
    @RequestMapping(value = "/employee/user/{id}", method = RequestMethod.GET)
    public Employees findByUserId(@PathVariable @Valid int id) {
        return employeeService.findByUserId(id);
    }

    //Create new employee
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Employees createEmployee(@RequestBody @Valid Employees employee) {
        return employeeService.createEmployee(employee);
    }

    //delete employee
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public void deleteEmployee(@PathVariable @Valid int id) {
        employeeService.deleteEmployee(id);
    }

    //update an employee
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public void updateEmployee(@RequestBody Employees employee, @PathVariable Integer id) {
        employeeService.updateEmployee(employee, id);
    }


    //Custom Repo Method Routes

    //    GET Employee by Company Name
    @RequestMapping(value = "/employee/company/{companyName}", method = RequestMethod.GET)
    public List<Employees> findByCompanyName(@PathVariable @Valid String companyName) {


        //Create a list called temptList to store all employees matching company name in
        List<Employees> tempList = employeeService.employeesList().stream()

                //stream that filters for any match of the passed in value of a company name and returns true if there is a match
                .filter(employees -> employees.getCompanyName().contains(companyName))

                //collecting the objects that return true to the tempList
                .collect(Collectors.toList());
        return tempList;


    }
}
