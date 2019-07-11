/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.wizardtest.testdemo2;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Employee generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Employee`")
public class Employee implements Serializable {

    private Integer empId;
    private String name;
    private String username;
    private String password;
    private String role;
    private Integer mangerId;
    private String image;
    private Employee employeeByMangerId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`EmpID`", nullable = false, scale = 0, precision = 10)
    public Integer getEmpId() {
        return this.empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Column(name = "`Name`", nullable = true, length = 255)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "`Username`", nullable = true, length = 255)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "`Password`", nullable = true, length = 255)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "`Role`", nullable = true, length = 255)
    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "`MangerID`", nullable = true, scale = 0, precision = 10)
    public Integer getMangerId() {
        return this.mangerId;
    }

    public void setMangerId(Integer mangerId) {
        this.mangerId = mangerId;
    }

    @Column(name = "`Image`", nullable = true, length = 255)
    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    // ignoring self relation properties to avoid circular loops & unwanted fields from the related entity.
    @JsonIgnoreProperties({"employeeByMangerId", "employeesForMangerId"})
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`MangerID`", referencedColumnName = "`EmpID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_Employee_TO_Employee_UlC4H`"))
    @Fetch(FetchMode.JOIN)
    public Employee getEmployeeByMangerId() {
        return this.employeeByMangerId;
    }

    public void setEmployeeByMangerId(Employee employeeByMangerId) {
        if(employeeByMangerId != null) {
            this.mangerId = employeeByMangerId.getEmpId();
        }

        this.employeeByMangerId = employeeByMangerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        final Employee employee = (Employee) o;
        return Objects.equals(getEmpId(), employee.getEmpId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmpId());
    }
}