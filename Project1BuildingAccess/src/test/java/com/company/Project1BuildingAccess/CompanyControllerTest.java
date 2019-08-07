package com.company.Project1BuildingAccess;

import com.company.Project1BuildingAccess.ServiceLayers.CompanyServiceLayer;
import com.company.Project1BuildingAccess.controllers.CompanyController;
import com.company.Project1BuildingAccess.dto.Company;
import com.company.Project1BuildingAccess.dto.Employees;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Calendar;

import static org.mockito.Mockito.when;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class CompanyControllerTest {
    private MockMvc mockMvc;
    @Mock
    CompanyServiceLayer mockCompanyServ;

    @InjectMocks
    CompanyController companyController;

    Company company1;
    Company company2;

    Employees employees1;
    Employees employees2;

    List<Employees> employeesList;
    Calendar calendar = Calendar.getInstance();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();

        company1 = new Company(8, "Test Company One");
        company2 = new Company(7, "Test Company Two");

        employees1 = new Employees(100, "Sandra", "Brown", "Test Company One", "Manager", null, false, false);
        employees2 = new Employees(101, "Conner", "Melling", "Test Company Two", "Team Member", null, false, false);
        employeesList = new ArrayList<>();


    }

//    @Test
//    public void shouldFindCompanyByName() throws Exception {
//        employeesList = Arrays.asList(employees1, employees2);
//
//        when(mockCompanyServ
//                .findByCompanyName(employeesList.get(0).getCompanyName())).thenReturn(employeesList);
//
//        mockMvc.perform(get("/company/name/" + employeesList.get(0).getCompanyName()))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].title", is(employeesList.get(0).getCompanyName())));
//
//        verify(mockCompanyServ).findByCompanyName(employeesList.get(0).getCompanyName());
//    }
}
