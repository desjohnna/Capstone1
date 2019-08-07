package com.company.Project1BuildingAccess.ServiceLayers;

import com.company.Project1BuildingAccess.Repositories.BuildingLogRepository;
import com.company.Project1BuildingAccess.dto.BuildingLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class BuildingLogServiceLayer {

    @Autowired
    BuildingLogRepository buildingLogRepo;

    public List<BuildingLog> findLogByUserId(Integer userId) {
        return buildingLogRepo.findLogByUserId(userId);
    }

    public List<BuildingLog> findLogByCompanyName(String companyName) {
        return buildingLogRepo.findLogByCompanyName(companyName);
    }

    public List<BuildingLog> masterBuildingLog(){
        return buildingLogRepo.findAll();
    }

    public BuildingLog newLogEntry(BuildingLog buildingLog) {
        return buildingLogRepo.save(buildingLog);
    }
}
