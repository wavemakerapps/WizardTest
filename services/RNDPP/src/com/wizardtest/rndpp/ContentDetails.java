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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * ContentDetails generated by WaveMaker Studio.
 */
@Entity
@Table(name = "`ContentDetails`")
public class ContentDetails implements Serializable {

    private Integer contentId;
    private String typeofContent;
    private String ndarequired;
    private String ndatype;
    private String approvalFor;
    private String costInvolved;
    private String requestorComments;
    private String disclosureType;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] attachNda;
    @JsonProperty(access = Access.READ_ONLY)
    private byte[] attachDocs;
    private Integer requestId;
    private RequestMain requestMain;

    @Id
    @Column(name = "`ContentID`", nullable = false, scale = 0, precision = 10)
    public Integer getContentId() {
        return this.contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    @Column(name = "`TypeofContent`", nullable = true, length = 255)
    public String getTypeofContent() {
        return this.typeofContent;
    }

    public void setTypeofContent(String typeofContent) {
        this.typeofContent = typeofContent;
    }

    @Column(name = "`NDARequired`", nullable = true, length = 255)
    public String getNdarequired() {
        return this.ndarequired;
    }

    public void setNdarequired(String ndarequired) {
        this.ndarequired = ndarequired;
    }

    @Column(name = "`NDAType`", nullable = true, length = 255)
    public String getNdatype() {
        return this.ndatype;
    }

    public void setNdatype(String ndatype) {
        this.ndatype = ndatype;
    }

    @Column(name = "`ApprovalFor`", nullable = true, length = 255)
    public String getApprovalFor() {
        return this.approvalFor;
    }

    public void setApprovalFor(String approvalFor) {
        this.approvalFor = approvalFor;
    }

    @Column(name = "`CostInvolved`", nullable = true, length = 255)
    public String getCostInvolved() {
        return this.costInvolved;
    }

    public void setCostInvolved(String costInvolved) {
        this.costInvolved = costInvolved;
    }

    @Column(name = "`RequestorComments`", nullable = true, length = 255)
    public String getRequestorComments() {
        return this.requestorComments;
    }

    public void setRequestorComments(String requestorComments) {
        this.requestorComments = requestorComments;
    }

    @Column(name = "`DisclosureType`", nullable = true, length = 255)
    public String getDisclosureType() {
        return this.disclosureType;
    }

    public void setDisclosureType(String disclosureType) {
        this.disclosureType = disclosureType;
    }

    @Column(name = "`AttachNDA`", nullable = true)
    public byte[] getAttachNda() {
        return this.attachNda;
    }

    public void setAttachNda(byte[] attachNda) {
        this.attachNda = attachNda;
    }

    @Column(name = "`AttachDocs`", nullable = true)
    public byte[] getAttachDocs() {
        return this.attachDocs;
    }

    public void setAttachDocs(byte[] attachDocs) {
        this.attachDocs = attachDocs;
    }

    @Column(name = "`RequestID`", nullable = true, scale = 0, precision = 10)
    public Integer getRequestId() {
        return this.requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`ContentID`", referencedColumnName = "`RequestID`", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "`FK_ContentDetails_TO_Reqm1Wmm`"))
    @Fetch(FetchMode.JOIN)
    public RequestMain getRequestMain() {
        return this.requestMain;
    }

    public void setRequestMain(RequestMain requestMain) {
        if(requestMain != null) {
            this.contentId = requestMain.getRequestId();
        }

        this.requestMain = requestMain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContentDetails)) return false;
        final ContentDetails contentDetails = (ContentDetails) o;
        return Objects.equals(getContentId(), contentDetails.getContentId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContentId());
    }
}