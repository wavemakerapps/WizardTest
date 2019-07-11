/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.wizardtest.blobtest.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.TypeMismatchException;
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
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.wavemaker.commons.wrapper.StringWrapper;
import com.wavemaker.runtime.data.export.DataExportOptions;
import com.wavemaker.runtime.data.export.ExportType;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.model.AggregationInfo;
import com.wavemaker.runtime.file.manager.ExportedFileManager;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wavemaker.runtime.file.model.Downloadable;
import com.wavemaker.runtime.security.xss.XssDisable;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.tools.api.core.annotations.MapTo;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import com.wizardtest.blobtest.BlobData;
import com.wizardtest.blobtest.service.BlobDataService;


/**
 * Controller object for domain model class BlobData.
 * @see BlobData
 */
@RestController("BlobTest.BlobDataController")
@Api(value = "BlobDataController", description = "Exposes APIs to work with BlobData resource.")
@RequestMapping("/BlobTest/BlobData")
public class BlobDataController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlobDataController.class);

    @Autowired
	@Qualifier("BlobTest.BlobDataService")
	private BlobDataService blobDataService;

	@Autowired
	private ExportedFileManager exportedFileManager;

	@ApiOperation(value = "Creates a new BlobData instance.")
    @RequestMapping(method = RequestMethod.POST, consumes = "multipart/form-data")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public BlobData createBlobData(@RequestPart("wm_data_json") BlobData blobData, @RequestPart(value = "image", required = false) MultipartFile _image) {
		LOGGER.debug("Create BlobData with information: {}" , blobData);

    blobData.setImage(WMMultipartUtils.toByteArray(_image));
		blobData = blobDataService.create(blobData);
		LOGGER.debug("Created BlobData with information: {}" , blobData);

	    return blobData;
	}

    @ApiOperation(value = "Returns the BlobData instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public BlobData getBlobData(@PathVariable("id") Integer id) {
        LOGGER.debug("Getting BlobData with id: {}" , id);

        BlobData foundBlobData = blobDataService.getById(id);
        LOGGER.debug("BlobData details with id: {}" , foundBlobData);

        return foundBlobData;
    }

    @ApiOperation(value = "Retrieves content for the given BLOB field in BlobData instance" )
    @RequestMapping(value = "/{id}/content/{fieldName}", method = RequestMethod.GET, produces="application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public DownloadResponse getBlobDataBLOBContent(@PathVariable("id") Integer id, @PathVariable("fieldName") String fieldName, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, @RequestParam(value="download", defaultValue = "false") boolean download) {

        LOGGER.debug("Retrieves content for the given BLOB field {} in BlobData instance" , fieldName);

        if(!WMRuntimeUtils.isLob(BlobData.class, fieldName)) {
            throw new TypeMismatchException("Given field " + fieldName + " is not a valid BLOB type");
        }
        BlobData blobData = blobDataService.getById(id);

        return WMMultipartUtils.buildDownloadResponseForBlob(blobData, fieldName, httpServletRequest, download);
    }

    @ApiOperation(value = "Updates the BlobData instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public BlobData editBlobData(@PathVariable("id") Integer id, @RequestBody BlobData blobData) {
        LOGGER.debug("Editing BlobData with id: {}" , blobData.getId());

        blobData.setId(id);
        blobData = blobDataService.update(blobData);
        LOGGER.debug("BlobData details with id: {}" , blobData);

        return blobData;
    }
    
    @ApiOperation(value = "Partially updates the BlobData instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.PATCH)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public BlobData patchBlobData(@PathVariable("id") Integer id, @RequestBody @MapTo(BlobData.class) Map<String, Object> blobDataPatch) {
        LOGGER.debug("Partially updating BlobData with id: {}" , id);

        BlobData blobData = blobDataService.partialUpdate(id, blobDataPatch);
        LOGGER.debug("BlobData details after partial update: {}" , blobData);

        return blobData;
    }

    @ApiOperation(value = "Updates the BlobData instance associated with the given id.This API should be used when BlobData instance fields that require multipart data.") 
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.POST, consumes = {"multipart/form-data"})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public BlobData editBlobData(@PathVariable("id") Integer id, MultipartHttpServletRequest multipartHttpServletRequest) {
        BlobData newBlobData = WMMultipartUtils.toObject(multipartHttpServletRequest, BlobData.class, "BlobTest");
        newBlobData.setId(id);

        BlobData oldBlobData = blobDataService.getById(id);
        WMMultipartUtils.updateLobsContent(oldBlobData, newBlobData);
        LOGGER.debug("Updating BlobData with information: {}" , newBlobData);

        return blobDataService.update(newBlobData);
    }

    @ApiOperation(value = "Deletes the BlobData instance associated with the given id.")
    @RequestMapping(value = "/{id:.+}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public boolean deleteBlobData(@PathVariable("id") Integer id) {
        LOGGER.debug("Deleting BlobData with id: {}" , id);

        BlobData deletedBlobData = blobDataService.delete(id);

        return deletedBlobData != null;
    }

    /**
     * @deprecated Use {@link #findBlobDatas(String, Pageable)} instead.
     */
    @Deprecated
    @ApiOperation(value = "Returns the list of BlobData instances matching the search criteria.")
    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<BlobData> searchBlobDatasByQueryFilters( Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering BlobDatas list by query filter:{}", (Object) queryFilters);
        return blobDataService.findAll(queryFilters, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of BlobData instances matching the optional query (q) request param. If there is no query provided, it returns all the instances. Pagination & Sorting parameters such as page& size, sort can be sent as request parameters. The sort value should be a comma separated list of field names & optional sort order to sort the data on. eg: field1 asc, field2 desc etc ")
    @RequestMapping(method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    public Page<BlobData> findBlobDatas(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering BlobDatas list by filter:", query);
        return blobDataService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns the paginated list of BlobData instances matching the optional query (q) request param. This API should be used only if the query string is too big to fit in GET request with request param. The request has to made in application/x-www-form-urlencoded format.")
    @RequestMapping(value="/filter", method = RequestMethod.POST, consumes= "application/x-www-form-urlencoded")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Page<BlobData> filterBlobDatas(@ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
        LOGGER.debug("Rendering BlobDatas list by filter", query);
        return blobDataService.findAll(query, pageable);
    }

    @ApiOperation(value = "Returns downloadable file for the data matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
    @RequestMapping(value = "/export/{exportType}", method = {RequestMethod.GET,  RequestMethod.POST}, produces = "application/octet-stream")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public Downloadable exportBlobDatas(@PathVariable("exportType") ExportType exportType, @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query, Pageable pageable) {
         return blobDataService.export(exportType, query, pageable);
    }

    @ApiOperation(value = "Returns a URL to download a file for the data matching the optional query (q) request param and the required fields provided in the Export Options.") 
    @RequestMapping(value = "/export", method = {RequestMethod.POST}, consumes = "application/json")
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @XssDisable
    public StringWrapper exportBlobDatasAndGetURL(@RequestBody DataExportOptions exportOptions, Pageable pageable) {
        String exportedFileName = exportOptions.getFileName();
        if(exportedFileName == null || exportedFileName.isEmpty()) {
            exportedFileName = BlobData.class.getSimpleName();
        }
        exportedFileName += exportOptions.getExportType().getExtension();
        String exportedUrl = exportedFileManager.registerAndGetURL(exportedFileName, outputStream -> blobDataService.export(exportOptions, pageable, outputStream));
        return new StringWrapper(exportedUrl);
    }

	@ApiOperation(value = "Returns the total count of BlobData instances matching the optional query (q) request param. If query string is too big to fit in GET request's query param, use POST method with application/x-www-form-urlencoded format.")
	@RequestMapping(value = "/count", method = {RequestMethod.GET, RequestMethod.POST})
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Long countBlobDatas( @ApiParam("conditions to filter the results") @RequestParam(value = "q", required = false) String query) {
		LOGGER.debug("counting BlobDatas");
		return blobDataService.count(query);
	}

    @ApiOperation(value = "Returns aggregated result with given aggregation info")
	@RequestMapping(value = "/aggregations", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
	@XssDisable
	public Page<Map<String, Object>> getBlobDataAggregatedValues(@RequestBody AggregationInfo aggregationInfo, Pageable pageable) {
        LOGGER.debug("Fetching aggregated results for {}", aggregationInfo);
        return blobDataService.getAggregatedValues(aggregationInfo, pageable);
    }


    /**
	 * This setter method should only be used by unit tests
	 *
	 * @param service BlobDataService instance
	 */
	protected void setBlobDataService(BlobDataService service) {
		this.blobDataService = service;
	}

}