package com.company.Project1BuildingAccess.Repositories;

import com.company.Project1BuildingAccess.dto.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    //Find Company by company name
    Company findByCompanyName(String companyName);

    Company findByFloor(Integer floor);


}
