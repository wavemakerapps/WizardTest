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

import com.wizardtest.rndpp.DisclosureDetails;

/**
 * Service object for domain model class {@link DisclosureDetails}.
 */
public interface DisclosureDetailsService {

    /**
     * Creates a new DisclosureDetails. It does cascade insert for all the children in a single transaction.
     *
     * This method overrides the input field values using Server side or database managed properties defined on DisclosureDetails if any.
     *
     * @param disclosureDetails Details of the DisclosureDetails to be created; value cannot be null.
     * @return The newly created DisclosureDetails.
     */
    DisclosureDetails create(@Valid DisclosureDetails disclosureDetails);


	/**
     * Returns DisclosureDetails by given id if exists.
     *
     * @param disclosuredetailsId The id of the DisclosureDetails to get; value cannot be null.
     * @return DisclosureDetails associated with the given disclosuredetailsId.
	 * @throws EntityNotFoundException If no DisclosureDetails is found.
     */
    DisclosureDetails getById(Integer disclosuredetailsId);

    /**
     * Find and return the DisclosureDetails by given id if exists, returns null otherwise.
     *
     * @param disclosuredetailsId The id of the DisclosureDetails to get; value cannot be null.
     * @return DisclosureDetails associated with the given disclosuredetailsId.
     */
    DisclosureDetails findById(Integer disclosuredetailsId);

	/**
     * Find and return the list of DisclosureDetails by given id's.
     *
     * If orderedReturn true, the return List is ordered and positional relative to the incoming ids.
     *
     * In case of unknown entities:
     *
     * If enabled, A null is inserted into the List at the proper position(s).
     * If disabled, the nulls are not put into the return List.
     *
     * @param disclosuredetailsIds The id's of the DisclosureDetails to get; value cannot be null.
     * @param orderedReturn Should the return List be ordered and positional in relation to the incoming ids?
     * @return DisclosureDetails associated with the given disclosuredetailsIds.
     */
    List<DisclosureDetails> findByMultipleIds(List<Integer> disclosuredetailsIds, boolean orderedReturn);


    /**
     * Updates the details of an existing DisclosureDetails. It replaces all fields of the existing DisclosureDetails with the given disclosureDetails.
     *
     * This method overrides the input field values using Server side or database managed properties defined on DisclosureDetails if any.
     *
     * @param disclosureDetails The details of the DisclosureDetails to be updated; value cannot be null.
     * @return The updated DisclosureDetails.
     * @throws EntityNotFoundException if no DisclosureDetails is found with given input.
     */
    DisclosureDetails update(@Valid DisclosureDetails disclosureDetails);


    /**
     * Partially updates the details of an existing DisclosureDetails. It updates only the
     * fields of the existing DisclosureDetails which are passed in the disclosureDetailsPatch.
     *
     * This method overrides the input field values using Server side or database managed properties defined on DisclosureDetails if any.
     *
     * @param disclosuredetailsId The id of the DisclosureDetails to be deleted; value cannot be null.
     * @param disclosureDetailsPatch The partial data of DisclosureDetails which is supposed to be updated; value cannot be null.
     * @return The updated DisclosureDetails.
     * @throws EntityNotFoundException if no DisclosureDetails is found with given input.
     */
    DisclosureDetails partialUpdate(Integer disclosuredetailsId, Map<String, Object> disclosureDetailsPatch);

    /**
     * Deletes an existing DisclosureDetails with the given id.
     *
     * @param disclosuredetailsId The id of the DisclosureDetails to be deleted; value cannot be null.
     * @return The deleted DisclosureDetails.
     * @throws EntityNotFoundException if no DisclosureDetails found with the given id.
     */
    DisclosureDetails delete(Integer disclosuredetailsId);

    /**
     * Deletes an existing DisclosureDetails with the given object.
     *
     * @param disclosureDetails The instance of the DisclosureDetails to be deleted; value cannot be null.
     */
    void delete(DisclosureDetails disclosureDetails);

    /**
     * Find all DisclosureDetails matching the given QueryFilter(s).
     * All the QueryFilter(s) are ANDed to filter the results.
     * This method returns Paginated results.
     *
     * @deprecated Use {@link #findAll(String, Pageable)} instead.
     *
     * @param queryFilters Array of queryFilters to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching DisclosureDetails.
     *
     * @see QueryFilter
     * @see Pageable
     * @see Page
     */
    @Deprecated
    Page<DisclosureDetails> findAll(QueryFilter[] queryFilters, Pageable pageable);

    /**
     * Find all DisclosureDetails matching the given input query. This method returns Paginated results.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query The query to filter the results; No filters applied if the input is null/empty.
     * @param pageable Details of the pagination information along with the sorting options. If null returns all matching records.
     * @return Paginated list of matching DisclosureDetails.
     *
     * @see Pageable
     * @see Page
     */
    Page<DisclosureDetails> findAll(String query, Pageable pageable);

    /**
     * Exports all DisclosureDetails matching the given input query to the given exportType format.
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
     * Exports all DisclosureDetails matching the given input query to the given exportType format.
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
     * Retrieve the count of the DisclosureDetails in the repository with matching query.
     * Note: Go through the documentation for <u>query</u> syntax.
     *
     * @param query query to filter results. No filters applied if the input is null/empty.
     * @return The count of the DisclosureDetails.
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