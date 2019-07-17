/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.wizardtest.rndpp;

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

/**
 * GroupMaster generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`GroupMaster`")
public class GroupMaster implements Serializable {

    private Integer groupId;
    private String groupName;
    private Integer sectorId;
    private Integer segmentId;
    private SegmentMaster segmentMaster;
    private SectorMaster sectorMaster;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "`GroupID`", nullable = false, scale = 0, precision = 10)
    public Integer getGroupId() {
        return this.groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    @Column(name = "`GroupName`", nullable = true, length = 255)
    public String getGroupName() {
        return this.groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Column(name = "`SectorID`", nullable = true, scale = 0, precision = 10)
    public Integer getSectorId() {
        return this.sectorId;
    }

    public void setSectorId(Integer sectorId) {
        this.sectorId = sectorId;
    }

    @Column(name = "`SegmentID`", nullable = true, scale = 0, precision = 10)
    public Integer getSegmentId() {
        return this.segmentId;
    }

    public void setSegmentId(Integer segmentId) {
        this.segmentId = segmentId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`SegmentID`", referencedColumnName = "`SegID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_GroupMaster_TO_Segmenxum5W`"))
    @Fetch(FetchMode.JOIN)
    public SegmentMaster getSegmentMaster() {
        return this.segmentMaster;
    }

    public void setSegmentMaster(SegmentMaster segmentMaster) {
        if(segmentMaster != null) {
            this.segmentId = segmentMaster.getSegId();
        }

        this.segmentMaster = segmentMaster;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`SectorID`", referencedColumnName = "`SectorID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_SectorMaster_TO_GroupaMfiv`"))
    @Fetch(FetchMode.JOIN)
    public SectorMaster getSectorMaster() {
        return this.sectorMaster;
    }

    public void setSectorMaster(SectorMaster sectorMaster) {
        if(sectorMaster != null) {
            this.sectorId = sectorMaster.getSectorId();
        }

        this.sectorMaster = sectorMaster;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GroupMaster)) return false;
        final GroupMaster groupMaster = (GroupMaster) o;
        return Objects.equals(getGroupId(), groupMaster.getGroupId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGroupId());
    }
}