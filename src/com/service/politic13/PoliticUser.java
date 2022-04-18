package com.service.politic13;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.2
 * 2022-04-17T10:29:10.043+02:00
 * Generated source version: 2.4.2
 * 
 */
@WebService(targetNamespace = "http://politic13.service.com/", name = "PoliticUser")
@XmlSeeAlso({net.java.dev.jaxb.array.ObjectFactory.class, ObjectFactory.class})
public interface PoliticUser {

    @WebMethod(action = "urn:ClearList")
    @RequestWrapper(localName = "clearList", targetNamespace = "http://politic13.service.com/", className = "com.service.politic13.ClearList")
    @ResponseWrapper(localName = "clearListResponse", targetNamespace = "http://politic13.service.com/", className = "com.service.politic13.ClearListResponse")
    @WebResult(name = "return", targetNamespace = "")
    public int clearList();

    @WebMethod(action = "urn:AddPolitician")
    @RequestWrapper(localName = "addPolitician", targetNamespace = "http://politic13.service.com/", className = "com.service.politic13.AddPolitician")
    @ResponseWrapper(localName = "addPoliticianResponse", targetNamespace = "http://politic13.service.com/", className = "com.service.politic13.AddPoliticianResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String addPolitician(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod(action = "urn:DisplayPoliticList")
    @RequestWrapper(localName = "displayPoliticList", targetNamespace = "http://politic13.service.com/", className = "com.service.politic13.DisplayPoliticList")
    @ResponseWrapper(localName = "displayPoliticListResponse", targetNamespace = "http://politic13.service.com/", className = "com.service.politic13.DisplayPoliticListResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String displayPoliticList();

    @WebMethod(action = "urn:GetTweetPolitic")
    @RequestWrapper(localName = "getTweetPolitic", targetNamespace = "http://politic13.service.com/", className = "com.service.politic13.GetTweetPolitic")
    @ResponseWrapper(localName = "getTweetPoliticResponse", targetNamespace = "http://politic13.service.com/", className = "com.service.politic13.GetTweetPoliticResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.util.List<net.java.dev.jaxb.array.StringArray> getTweetPolitic(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod(action = "urn:PoliticInList")
    @RequestWrapper(localName = "politicInList", targetNamespace = "http://politic13.service.com/", className = "com.service.politic13.PoliticInList")
    @ResponseWrapper(localName = "politicInListResponse", targetNamespace = "http://politic13.service.com/", className = "com.service.politic13.PoliticInListResponse")
    @WebResult(name = "return", targetNamespace = "")
    public boolean politicInList(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod(action = "urn:GetPoliticDescription")
    @RequestWrapper(localName = "getPoliticDescription", targetNamespace = "http://politic13.service.com/", className = "com.service.politic13.GetPoliticDescription")
    @ResponseWrapper(localName = "getPoliticDescriptionResponse", targetNamespace = "http://politic13.service.com/", className = "com.service.politic13.GetPoliticDescriptionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String getPoliticDescription(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}