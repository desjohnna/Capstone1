package com.company.Project1BuildingAccess.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;


@Entity
@JsonIgnoreProperties({"hibernatelazyinitializer", "handler"})
@Table(name = "BuildingLog")
public class BuildingLog {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer logEntryId;

    //Many buildingLogs to 1 employee userId
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeId", updatable = false, insertable = false)
    private Employees employees;

    private Integer userId;

    private String companyName;

    private Boolean entryLog;

    private Boolean exitLog;

    private String logDate;

    private Integer logTime;

    public BuildingLog() {

    }

    public BuildingLog(Integer logEntryId, Integer userId, String companyName, Boolean entryLog, Boolean exitLog, String logDate, Integer logTime) {
        this.logEntryId = logEntryId;
        this.userId = userId;
        this.entryLog = entryLog;
        this.exitLog = exitLog;
        this.companyName = companyName;
        this.logDate = logDate;
        this.logTime = logTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Boolean getEntryLog() {
        return entryLog;
    }

    public void setEntryLog(Boolean entry) {
        this.entryLog = entry;
    }

    public Boolean getExitLog() {
        return exitLog;
    }

    public void setExitLog(Boolean exit) {
        this.exitLog = exit;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Integer getLogEntryId() {
        return this.logEntryId;
    }

    public void setLogEntryId(Integer logEntryId) {
        this.logEntryId = logEntryId;
    }

    public Integer getLogTime() {
        return logTime;
    }

    public void setLogTime(Integer logTime) {
        this.logTime = logTime;
    }

    public String getLogDate() {
        return logDate;
    }

    public void setLogDate(String logDate) {
        this.logDate = logDate;
    }
}
