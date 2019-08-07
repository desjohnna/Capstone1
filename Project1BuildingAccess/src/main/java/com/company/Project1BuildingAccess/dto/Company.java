package com.company.Project1BuildingAccess.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@JsonIgnoreProperties({"hibernatelazyinitializer", "handler"})
@Table(name = "Companies")
public class Company {

    @Id
    private Integer floor;

    private String companyName;

    private Integer startTime = 600;

    private Integer endTime = 1900;


    public Company() {

    }

    public Company(Integer floor, @NotEmpty String companyName) {
        this.floor = floor;
        this.companyName = companyName;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
