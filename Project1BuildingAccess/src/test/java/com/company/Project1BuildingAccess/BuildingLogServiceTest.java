package com.company.Project1BuildingAccess;

import com.company.Project1BuildingAccess.Repositories.BuildingLogRepository;
import com.company.Project1BuildingAccess.ServiceLayers.BuildingLogServiceLayer;
import com.company.Project1BuildingAccess.dto.BuildingLog;
import com.company.Project1BuildingAccess.dto.Company;
import com.company.Project1BuildingAccess.dto.Employees;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BuildingLogServiceTest {

    @Mock
    @Autowired
    BuildingLogRepository BuildingRepoMock;

    @InjectMocks
    BuildingLogServiceLayer buildingLogService;

    //Adding companies to test with
    Company company1;
    Company company2;
    Company company3;

    //Adding employees to test with
    Employees employees1;
    Employees employees2;
    Employees employees3;

    BuildingLog logEntry1;
    BuildingLog logEntry2;
    BuildingLog logEntry3;

    //List<Company>

    @Before
    public void setUp() {
        logEntry1 = new BuildingLog(1, 30, "Intel", true, false, "Jan 24, 2019", 600);
        logEntry2 = new BuildingLog(2, 30, "Intel", false, true, "Jan 24, 2019", 1700);
        logEntry3 = new BuildingLog(3, 12, "Gap", true, false, "Jan 40, 2019", 800);
    }

    @Test
    public void getMasterBuildingLogTest(){
        List<BuildingLog> masterBuildingLog = Arrays.asList(logEntry1, logEntry2, logEntry3);
        when(BuildingRepoMock.findAll()).thenReturn(masterBuildingLog);
        assertEquals(masterBuildingLog, buildingLogService.masterBuildingLog());
    }




}

