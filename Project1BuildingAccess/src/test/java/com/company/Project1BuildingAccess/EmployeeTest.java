package com.company.Project1BuildingAccess;

import com.company.Project1BuildingAccess.Repositories.CompanyRepository;
import com.company.Project1BuildingAccess.Repositories.EmployeeRepository;
import com.company.Project1BuildingAccess.dto.Company;
import com.company.Project1BuildingAccess.dto.Employees;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import static org.junit.Assert.*;


import java.util.List;


//DAO (Repo) Testing

@RunWith(SpringRunner.class)
@SpringBootTest

public class EmployeeTest {

    @Autowired
    CompanyRepository companyRepo;

    @Autowired
    EmployeeRepository employeeRepo;



    Company company1;
    Company company2;
    Company company3;

    Employees employees1;
    Employees employees2;
    Employees employees3;

    @Before
    public void setUp() {
        company1 = new Company(8, "Ross");
        company2 = new Company(5, "Gap");
        company3 = new Company(6,"Intel");

        employees1 = new Employees(1, "Karen", "Smith", "Intel", "Manager", null , true, false);
        employees2 = new Employees(2, "DJ", "Gray", "Ross", "Manager",null , false, false);
        employees3 = new Employees(3, "Jeffery", "Barington", "Intel", "Team Member",null , false, false);
    }

    @Test
    @Transactional
    public void findByEmployeeByCompanyName() {
        //adding companies to test with
        companyRepo.save(company1);
        companyRepo.save(company2);
        companyRepo.save(company3);

        //adding employees to test with
        employeeRepo.save(employees1);
        employeeRepo.save(employees2);
        employeeRepo.save(employees3);

        //creating a list that = searching the employeeRepo findByCompanyName method for Intel.
        List<Employees> company3List = employeeRepo.findByCompanyName("Intel");

        //asserting that the list should return 2 employees
        assertEquals(2, company3List.size());

    }

    @After
    public void tearDown() {
        companyRepo.deleteAll();
        employeeRepo.deleteAll();
    }

}
