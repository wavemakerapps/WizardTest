/*Copyright (c) 2015-2016 gmail.com All Rights Reserved.
 This software is the confidential and proprietary information of gmail.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with gmail.com*/
package com.wizardtest.myjavaservice.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;
import com.wizardtest.myjavaservice.MyJavaService;
import com.wordnik.swagger.annotations.Api;

/**
 * Controller object for domain model class {@link MyJavaService}.
 * @see MyJavaService
 */
@RestController
@Api(value = "MyJavaController", description = "controller class for java service execution")
@RequestMapping("/myJava")
public class MyJavaController {

    @Autowired
    private MyJavaService myJavaService;

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public int add(@RequestParam(value = "x", required = false) int x, @RequestParam(value = "y", required = false) int y) {
        return myJavaService.add(x, y);
    }

    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @RequestMapping(value = "/sampleJavaOperation", method = RequestMethod.GET)
    public String sampleJavaOperation(@RequestParam(value = "name", required = false) String name,  HttpServletRequest request) {
        return myJavaService.sampleJavaOperation(name, request);
    }
}