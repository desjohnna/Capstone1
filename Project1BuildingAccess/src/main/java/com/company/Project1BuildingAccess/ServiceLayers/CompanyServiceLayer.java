package com.company.Project1BuildingAccess.ServiceLayers;

import com.company.Project1BuildingAccess.Repositories.CompanyRepository;
import com.company.Project1BuildingAccess.dto.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyServiceLayer {

    @Autowired
    CompanyRepository companyRepo;

    //CRUD Method calls

    public List<Company> companyList() {
        return companyRepo.findAll();
    }


    public Company createCompany(Company company) {

        companyRepo.save(company);
        return company;
    }

    //Deleting by floor
    public void deleteCompany(int floor) {
        companyRepo.delete(findByFloor(floor));
    }

    //Custom Repo Methods

    public Company findByCompanyName(String companyName) {
        return companyRepo.findByCompanyName(companyName);
    }

    public Company findByFloor(Integer floor) {
        return companyRepo.findByFloor(floor);
    }


}
