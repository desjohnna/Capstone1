package com.company.Project1BuildingAccess.controllers;

import com.company.Project1BuildingAccess.ServiceLayers.CompanyServiceLayer;
import com.company.Project1BuildingAccess.dto.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CompanyController {
    @Autowired
    CompanyServiceLayer companyService;

    //CRUD Method routes
    // WORKING: RETURNING ALL COMPANIES
    @RequestMapping(value = "/company", method = RequestMethod.GET)
    public List<Company> companyList() {
        return companyService.companyList();
    }

    //WORKING: CREATES NEW COMPANY
    @RequestMapping(value = "/company", method = RequestMethod.POST)
    public Company createCompany(@RequestBody @Valid Company company) {

        return companyService.createCompany(company);
    }

    //WORKING: GETTING COMPANY BY FLOOR AND THROWING EXCEPTIONS
    @RequestMapping(value = "/company/floor/{floor}", method = RequestMethod.GET)
    public Company findByFloor(@PathVariable @Valid int floor) {

        //Throwing an exception if the number passed is not a valid floor number 1-8.
        if (floor >= 8) {
            throw new IllegalArgumentException("Please select a floor between 1 - 8.");
        }
        return companyService.findByFloor(floor);
    }

    //WORKING DELETING COMPANY BY FLOOR
    @RequestMapping(value = "/company/{floor}", method = RequestMethod.DELETE)
    public void deleteCompany(@PathVariable int floor) {
        companyService.deleteCompany(floor);
    }

    //WORKING: GETTING A COMPANY BY COMPANY NAME
    // FUTURE: NEED TO ADD LOGIC TO ACCOUNT FOR SPACES
    @RequestMapping(value = "/company/name/{name}", method = RequestMethod.GET)
    public Company findByCompanyName(@PathVariable @Valid String name) {
        name.toLowerCase();
        for (int i = 0; i < companyList().size(); i++) {
            if (companyList().get(i).getCompanyName().contains(name)) {
                return companyList().get(i);
            }

        }
        //FUTURE: throw IllegalArgumentException("Please enter a valid company name.")
        return null;
    }

}
