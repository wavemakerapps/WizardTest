/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.wizardtest.rndpp.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.security.xss.XssDisable;
import com.wavemaker.tools.api.core.annotations.MapTo;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.wizardtest.rndpp.DisclosureDetails;
import com.wizardtest.rndpp.service.DisclosureDetailsService;


/**
 * Controller object for domain model class DisclosureDetails.
 * @see DisclosureDetails
 */
@RestController("RNDPP.DisclosureDetailsController")
@Api(value = "DisclosureDetailsController", description = "Exposes APIs to work with DisclosureDetails resource.")
@RequestMapping("/RNDPP/DisclosureDetails")
public class DisclosureDetailsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DisclosureDetailsController.class);

    @Autowired
	@Qualifier("RNDPP.DisclosureDetailsService")
	private DisclosureDetailsService disclosureDetailsService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new DisclosureDetails instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DisclosureDetails createDisclosureDetails(@RequestBody DisclosureDetails disclosureDetails) {
		LOGGER.debug("Create DisclosureDetails with information: {}" , disclosureDetails);

		disclosureDetails = disclosureDetailsService.create(disclosureDetails);
		LOGGER.debug("Created DisclosureDetails with information: {}" , disclosureDetails);

	    return disclosureDetails;
	}

    @ApiOperation(value = "Returns the DisclosureDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DisclosureDetails getDisclosureDetails(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting DisclosureDetails with id: {}" , id);

        DisclosureDetails foundDisclosureDetails = disclosureDetailsService.getById(id);
        LOGGER.debug("DisclosureDetails details with id: {}" , foundDisclosureDetails);

        return foundDisclosureDetails;
    }

    @ApiOperation(value = "Updates the DisclosureDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DisclosureDetails editDisclosureDetails(@PathVariable("id") Integer id, @RequestBody DisclosureDetails disclosureDetails) {
        LOGGER.debug("Editing DisclosureDetails with id: {}" , disclosureDetails.getDiscloId());

        disclosureDetails.setDiscloId(id);
        disclosureDetails = disclosureDetailsService.update(disclosureDetails);
        LOGGER.debug("DisclosureDetails details with id: {}" , disclosureDetails);

        return disclosureDetails;
    }
    
    @ApiOperation(value = "Partially updates the DisclosureDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DisclosureDetails patchDisclosureDetails(@PathVariable("id") Integer id, @RequestBody @MapTo(DisclosureDetails.class) Map<String, Object> disclosureDetailsPatch) {
        LOGGER.debug("Partially updating DisclosureDetails with id: {}" , id);

        DisclosureDetails disclosureDetails = disclosureDetailsService.partialUpdate(id, disclosureDetailsPatch);
        LOGGER.debug("DisclosureDetails details after partial update: {}" , disclosureDetails);

        return disclosureDetails;
    }

    @ApiOperation(value = "Deletes the DisclosureDetails instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteDisclosureDetails(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting DisclosureDetails with id: {}" , id);

        DisclosureDetails deletedDisclosureDetails = disclosureDetailsService.delete(id);

        return deletedDisclosureDetails != null;
    }

    /**
     * @deprecated Use {@link #findDisclosureDetails(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of DisclosureDetails instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<DisclosureDetails> searchDisclosureDetailsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering DisclosureDetails list by query filter:{}", (Object) queryFilters);
        return disclosureDetailsService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DisclosureDetails instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<DisclosureDetails> findDisclosureDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DisclosureDetails list by filter:", query);
        return disclosureDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of DisclosureDetails instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<DisclosureDetails> filterDisclosureDetails(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering DisclosureDetails list by filter", query);
        return disclosureDetailsService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportDisclosureDetails(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return disclosureDetailsService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportDisclosureDetailsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = DisclosureDetails.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> disclosureDetailsService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of DisclosureDetails instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countDisclosureDetails( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting DisclosureDetails");
		return disclosureDetailsService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getDisclosureDetailsAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return disclosureDetailsService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service DisclosureDetailsService instance
	 */
	protected void setDisclosureDetailsService(DisclosureDetailsService service) {
		this.disclosureDetailsService = service;
	}

}