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

import com.wizardtest.rndpp.RequestMain;
import com.wizardtest.rndpp.service.RequestMainService;


/**
 * Controller object for domain model class RequestMain.
 * @see RequestMain
 */
@RestController("RNDPP.RequestMainController")
@Api(value = "RequestMainController", description = "Exposes APIs to work with RequestMain resource.")
@RequestMapping("/RNDPP/RequestMain")
public class RequestMainController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RequestMainController.class);

    @Autowired
	@Qualifier("RNDPP.RequestMainService")
	private RequestMainService requestMainService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new RequestMain instance.")
    @RequestMapping(method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RequestMain createRequestMain(@RequestBody RequestMain requestMain) {
		LOGGER.debug("Create RequestMain with information: {}" , requestMain);

		requestMain = requestMainService.create(requestMain);
		LOGGER.debug("Created RequestMain with information: {}" , requestMain);

	    return requestMain;
	}

    @ApiOperation(value = "Returns the RequestMain instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RequestMain getRequestMain(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting RequestMain with id: {}" , id);

        RequestMain foundRequestMain = requestMainService.getById(id);
        LOGGER.debug("RequestMain details with id: {}" , foundRequestMain);

        return foundRequestMain;
    }

    @ApiOperation(value = "Updates the RequestMain instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RequestMain editRequestMain(@PathVariable("id") Integer id, @RequestBody RequestMain requestMain) {
        LOGGER.debug("Editing RequestMain with id: {}" , requestMain.getRequestId());

        requestMain.setRequestId(id);
        requestMain = requestMainService.update(requestMain);
        LOGGER.debug("RequestMain details with id: {}" , requestMain);

        return requestMain;
    }
    
    @ApiOperation(value = "Partially updates the RequestMain instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public RequestMain patchRequestMain(@PathVariable("id") Integer id, @RequestBody @MapTo(RequestMain.class) Map<String, Object> requestMainPatch) {
        LOGGER.debug("Partially updating RequestMain with id: {}" , id);

        RequestMain requestMain = requestMainService.partialUpdate(id, requestMainPatch);
        LOGGER.debug("RequestMain details after partial update: {}" , requestMain);

        return requestMain;
    }

    @ApiOperation(value = "Deletes the RequestMain instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteRequestMain(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting RequestMain with id: {}" , id);

        RequestMain deletedRequestMain = requestMainService.delete(id);

        return deletedRequestMain != null;
    }

    /**
     * @deprecated Use {@link #findRequestMains(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of RequestMain instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<RequestMain> searchRequestMainsByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering RequestMains list by query filter:{}", (Object) queryFilters);
        return requestMainService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RequestMain instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<RequestMain> findRequestMains(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RequestMains list by filter:", query);
        return requestMainService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of RequestMain instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<RequestMain> filterRequestMains(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering RequestMains list by filter", query);
        return requestMainService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportRequestMains(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return requestMainService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportRequestMainsAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = RequestMain.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> requestMainService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of RequestMain instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countRequestMains( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting RequestMains");
		return requestMainService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getRequestMainAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return requestMainService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service RequestMainService instance
	 */
	protected void setRequestMainService(RequestMainService service) {
		this.requestMainService = service;
	}

}