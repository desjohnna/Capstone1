package com.company.Project1BuildingAccess.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernatelazyinitializer", "handler"})
@Table(name = "Employees")
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;


    @OneToMany(mappedBy = "employees", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private Set<BuildingLog> buildingLogs;


    @NotEmpty
    private String companyName;

    @NotEmpty
    private String title;

    private Date hireDate;

    private Boolean managerConfRoomAccess = false;

    private Boolean serverRoomAccess = false;


    public Employees() {

    }

    public Employees(Integer userId, String firstName, String lastName, String companyName, String title, Date hireDate, Boolean managerConfRoomAccess, Boolean serverRoomAccess) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.title = title;
        this.hireDate = hireDate;
        this.managerConfRoomAccess = managerConfRoomAccess;
        this.serverRoomAccess = serverRoomAccess;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Boolean getManagerConfRoomAccess() {
        return managerConfRoomAccess;
    }

    public void setManagerConfRoomAccess(Boolean managerConfRoomAccess) {
        this.managerConfRoomAccess = managerConfRoomAccess;
    }

    public Boolean getServerRoomAccess() {
        return serverRoomAccess;
    }

    public void setServerRoomAccess(Boolean serverRoomAccess) {
        this.serverRoomAccess = serverRoomAccess;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


}
