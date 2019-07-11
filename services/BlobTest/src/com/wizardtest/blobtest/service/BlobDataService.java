/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.wizardtest.blobtest.service;

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

import com.wizardtest.blobtest.BlobData;

/**
 * Service object for domain model class {@link BlobData}.
 */
public interface BlobDataService {

    /**
     * Creates a new BlobData. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on BlobData if any.
     *
     * @param blobData Details of the BlobData to be created; value cannot be null.
     * @return The newly created BlobData.
     */
    BlobData create(@Valid BlobData blobData);


	/**
     * Returns BlobData by given id if exists.
     *
     * @param blobdataId The id of the BlobData to get; value cannot be null.
     * @return BlobData associated with the given blobdataId.
	 * @throws EntityNotFoundException If no BlobData is found.
     */
    BlobData getById(Integer blobdataId);

    /**
     * Find and return the BlobData by given id if exists, returns null otherwise.
     *
     * @param blobdataId The id of the BlobData to get; value cannot be null.
     * @return BlobData associated with the given blobdataId.
     */
    BlobData findById(Integer blobdataId);

	/**
     * Find and return the list of BlobDatas by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param blobdataIds The id's of the BlobData to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return BlobDatas associated with the given blobdataIds.
     */
    List<BlobData> findByMultipleIds(List<Integer> blobdataIds, boolean orderedReturn);


    /**
     * Updates the details of an existing BlobData. It replaces all fields of the existing BlobData with the given blobData.
     *
     * This method overrides the input field values using Server side or database managed properties defined on BlobData if any.
     *
     * @param blobData The details of the BlobData to be updated; value cannot be null.
     * @return The updated BlobData.
     * @throws EntityNotFoundException if no BlobData is found with given input.
     */
    BlobData update(@Valid BlobData blobData);


    /**
     * Partially updates the details of an existing BlobData. It updates only the
     * fields of the existing BlobData which are passed in the blobDataPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on BlobData if any.
     *
     * @param blobdataId The id of the BlobData to be deleted; value cannot be null.
     * @param blobDataPatch The partial data of BlobData which is supposed to be updated; value cannot be null.
     * @return The updated BlobData.
     * @throws EntityNotFoundException if no BlobData is found with given input.
     */
    BlobData partialUpdate(Integer blobdataId, Map<String, Object> blobDataPatch);

    /**
     * Deletes an existing BlobData with the given id.
     *
     * @param blobdataId The id of the BlobData to be deleted; value cannot be null.
     * @return The deleted BlobData.
     * @throws EntityNotFoundException if no BlobData found with the given id.
     */
    BlobData delete(Integer blobdataId);

    /**
     * Deletes an existing BlobData with the given object.
     *
     * @param blobData The instance of the BlobData to be deleted; value cannot be null.
     */
    void delete(BlobData blobData);

    /**
     * Find all BlobDatas matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching BlobDatas.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<BlobData> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all BlobDatas matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching BlobDatas.
     *
     * @see Pageable
     * @see Page
     */
    Page<BlobData> findAll(String query, Pageable pageable);

    /**
     * Exports all BlobDatas matching the given input query to the given exportType format.
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
     * Exports all BlobDatas matching the given input query to the given exportType format.
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
     * Retrieve the count of the BlobDatas in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the BlobData.
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


}