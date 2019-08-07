package com.company.Project1BuildingAccess.controllers;

import com.company.Project1BuildingAccess.ServiceLayers.BuildingLogServiceLayer;
import com.company.Project1BuildingAccess.dto.BuildingLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class BuildingLogController {

    @Autowired
    BuildingLogServiceLayer buildingLogService;

    @RequestMapping(value = "/log/user/{userId}", method = RequestMethod.GET)
    public List<BuildingLog> findLogByUserId(@PathVariable Integer userId) {
        return buildingLogService.findLogByUserId(userId);
    }


    @RequestMapping(value = "/log/company/{companyName}", method = RequestMethod.GET)
    public List<BuildingLog> findLogByCompanyName(@PathVariable String companyName) {
        return buildingLogService.findLogByCompanyName(companyName);
    }

    @RequestMapping(value = "/log", method = RequestMethod.GET)
    public List<BuildingLog> getMasterBuildingLog() {
        return buildingLogService.masterBuildingLog();
    }

    @RequestMapping(value = "/log", method = RequestMethod.POST)
    public BuildingLog newLogEntry(@RequestBody BuildingLog buildingLog) {

        //If requested time is between 6am - 7pm allow building entry
        if (buildingLog.getLogTime() > 600 && buildingLog.getLogTime() < 1900) {
            return buildingLogService.newLogEntry(buildingLog);

            //If outside those times show that the building is closed
        } else if (buildingLog.getLogTime() < 600 || buildingLog.getLogTime() > 1900) {
            throw new IllegalArgumentException("Sorry, building is closed, please come back between working hours: 6:00am - 7:00pm");

            //If time is outside of all these parameters, show exception to enter time correctly
        } else {
            throw new IllegalArgumentException("Please enter current time in Military Time, omitting leading zero.");
        }

    }
}

