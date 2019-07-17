/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.wizardtest.rndpp.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.model.Downloadable;

import com.wizardtest.rndpp.GroupMaster;
import com.wizardtest.rndpp.RequestMain;
import com.wizardtest.rndpp.SectorMaster;

/**
 * Service object for domain model class {@link SectorMaster}.
 */
public interface SectorMasterService {

    /**
     * Creates a new SectorMaster. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on SectorMaster if any.
     *
     * @param sectorMaster Details of the SectorMaster to be created; value cannot be null.
     * @return The newly created SectorMaster.
     */
    SectorMaster create(@Valid SectorMaster sectorMaster);


	/**
     * Returns SectorMaster by given id if exists.
     *
     * @param sectormasterId The id of the SectorMaster to get; value cannot be null.
     * @return SectorMaster associated with the given sectormasterId.
	 * @throws EntityNotFoundException If no SectorMaster is found.
     */
    SectorMaster getById(Integer sectormasterId);

    /**
     * Find and return the SectorMaster by given id if exists, returns null otherwise.
     *
     * @param sectormasterId The id of the SectorMaster to get; value cannot be null.
     * @return SectorMaster associated with the given sectormasterId.
     */
    SectorMaster findById(Integer sectormasterId);

	/**
     * Find and return the list of SectorMasters by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param sectormasterIds The id's of the SectorMaster to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return SectorMasters associated with the given sectormasterIds.
     */
    List<SectorMaster> findByMultipleIds(List<Integer> sectormasterIds, boolean orderedReturn);


    /**
     * Updates the details of an existing SectorMaster. It replaces all fields of the existing SectorMaster with the given sectorMaster.
     *
     * This method overrides the input field values using Server side or database managed properties defined on SectorMaster if any.
     *
     * @param sectorMaster The details of the SectorMaster to be updated; value cannot be null.
     * @return The updated SectorMaster.
     * @throws EntityNotFoundException if no SectorMaster is found with given input.
     */
    SectorMaster update(@Valid SectorMaster sectorMaster);


    /**
     * Partially updates the details of an existing SectorMaster. It updates only the
     * fields of the existing SectorMaster which are passed in the sectorMasterPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on SectorMaster if any.
     *
     * @param sectormasterId The id of the SectorMaster to be deleted; value cannot be null.
     * @param sectorMasterPatch The partial data of SectorMaster which is supposed to be updated; value cannot be null.
     * @return The updated SectorMaster.
     * @throws EntityNotFoundException if no SectorMaster is found with given input.
     */
    SectorMaster partialUpdate(Integer sectormasterId, Map<String, Object> sectorMasterPatch);

    /**
     * Deletes an existing SectorMaster with the given id.
     *
     * @param sectormasterId The id of the SectorMaster to be deleted; value cannot be null.
     * @return The deleted SectorMaster.
     * @throws EntityNotFoundException if no SectorMaster found with the given id.
     */
    SectorMaster delete(Integer sectormasterId);

    /**
     * Deletes an existing SectorMaster with the given object.
     *
     * @param sectorMaster The instance of the SectorMaster to be deleted; value cannot be null.
     */
    void delete(SectorMaster sectorMaster);

    /**
     * Find all SectorMasters matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SectorMasters.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<SectorMaster> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all SectorMasters matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching SectorMasters.
     *
     * @see Pageable
     * @see Page
     */
    Page<SectorMaster> findAll(String query, Pageable pageable);

    /**
     * Exports all SectorMasters matching the given input query to the given exportType format.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param exportType The format in which to export the data; value cannot be null.
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return The Downloadable file in given export type.
     *
     * @see Pageable
     * @see ExportType
     * @see Downloadable
     */
    Downloadable export(ExportType exportType, String query, Pageable pageable);

    /**
     * Exports all SectorMasters matching the given input query to the given exportType format.
     *
     * @param options The export options provided by the user; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @param outputStream The output stream of the file for the exported data to be written to.
     *
     * @see DataExportOptions
     * @see Pageable
     * @see OutputStream
     */
    void export(DataExportOptions options, Pageable pageable, OutputStream outputStream);

    /**
     * Retrieve the count of the SectorMasters in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the SectorMaster.
     */
    long count(String query);

    /**
     * Retrieve aggregated values with matching aggregation info.
     *
     * @param aggregationInfo info related to aggregations.
     * @param pageable Details of the pagination information along with the sorting options. If null exports all matching records.
     * @return Paginated data with included fields.
     *
     * @see AggregationInfo
     * @see Pageable
     * @see Page
	 */
    Page<Map<String, Object>> getAggregatedValues(AggregationInfo aggregationInfo, Pageable pageable);

    /*
     * Returns the associated requestMains for given SectorMaster id.
     *
     * @param sectorId value of sectorId; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated RequestMain instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<RequestMain> findAssociatedRequestMains(Integer sectorId, Pageable pageable);

    /*
     * Returns the associated groupMasters for given SectorMaster id.
     *
     * @param sectorId value of sectorId; value cannot be null
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of associated GroupMaster instances.
     *
     * @see Pageable
     * @see Page
     */
    Page<GroupMaster> findAssociatedGroupMasters(Integer sectorId, Pageable pageable);

}