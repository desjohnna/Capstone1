package com.company.Project1BuildingAccess.Repositories;

import com.company.Project1BuildingAccess.dto.BuildingLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BuildingLogRepository extends JpaRepository<BuildingLog, Integer> {

    List<BuildingLog> findLogByUserId(Integer userId);

    List<BuildingLog> findLogByCompanyName(String companyName);
    }

