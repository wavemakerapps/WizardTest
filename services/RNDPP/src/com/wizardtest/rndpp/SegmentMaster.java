/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.wizardtest.rndpp;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SegmentMaster generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`SegmentMaster`")
public class SegmentMaster implements Serializable {

    private Integer segId;
    private String segmentName;
    private String segDescription;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`SegID`", nullable = false, scale = 0, precision = 10)
    public Integer getSegId() {
        return this.segId;
    }

    public void setSegId(Integer segId) {
        this.segId = segId;
    }

    @Column(name = "`SegmentName`", nullable = true, length = 255)
    public String getSegmentName() {
        return this.segmentName;
    }

    public void setSegmentName(String segmentName) {
        this.segmentName = segmentName;
    }

    @Column(name = "`SegDescription`", nullable = true, length = 255)
    public String getSegDescription() {
        return this.segDescription;
    }

    public void setSegDescription(String segDescription) {
        this.segDescription = segDescription;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SegmentMaster)) return false;
        final SegmentMaster segmentMaster = (SegmentMaster) o;
        return Objects.equals(getSegId(), segmentMaster.getSegId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSegId());
    }
}