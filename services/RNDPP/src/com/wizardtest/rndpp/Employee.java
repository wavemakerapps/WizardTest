/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.wizardtest.rndpp;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Employee generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`Employee`")
public class Employee implements Serializable {

    private Integer empId;
    private String empName;
    private String empEmailId;
    private String ecnumber;
    private String managerName;
    private String managerId;
    private String authorType;
    private Integer requestId;

    @Id
    @Column(name = "`EmpID`", nullable = false, scale = 0, precision = 10)
    public Integer getEmpId() {
        return this.empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Column(name = "`EmpName`", nullable = true, length = 255)
    public String getEmpName() {
        return this.empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    @Column(name = "`EmpEmailID`", nullable = true, length = 255)
    public String getEmpEmailId() {
        return this.empEmailId;
    }

    public void setEmpEmailId(String empEmailId) {
        this.empEmailId = empEmailId;
    }

    @Column(name = "`ECNumber`", nullable = true, length = 255)
    public String getEcnumber() {
        return this.ecnumber;
    }

    public void setEcnumber(String ecnumber) {
        this.ecnumber = ecnumber;
    }

    @Column(name = "`ManagerName`", nullable = true, length = 255)
    public String getManagerName() {
        return this.managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    @Column(name = "`ManagerID`", nullable = true, length = 255)
    public String getManagerId() {
        return this.managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    @Column(name = "`AuthorType`", nullable = true, length = 255)
    public String getAuthorType() {
        return this.authorType;
    }

    public void setAuthorType(String authorType) {
        this.authorType = authorType;
    }

    @Column(name = "`RequestID`", nullable = true, scale = 0, precision = 10)
    public Integer getRequestId() {
        return this.requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
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