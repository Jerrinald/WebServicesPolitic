
package com.service.politic13;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.service.politic13 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ClearList_QNAME = new QName("http://politic13.service.com/", "clearList");
    private final static QName _AddPolitician_QNAME = new QName("http://politic13.service.com/", "addPolitician");
    private final static QName _DisplayPoliticList_QNAME = new QName("http://politic13.service.com/", "displayPoliticList");
    private final static QName _ClearListResponse_QNAME = new QName("http://politic13.service.com/", "clearListResponse");
    private final static QName _GetPoliticDescriptionResponse_QNAME = new QName("http://politic13.service.com/", "getPoliticDescriptionResponse");
    private final static QName _GetTweetPolitic_QNAME = new QName("http://politic13.service.com/", "getTweetPolitic");
    private final static QName _PoliticInListResponse_QNAME = new QName("http://politic13.service.com/", "politicInListResponse");
    private final static QName _PoliticInList_QNAME = new QName("http://politic13.service.com/", "politicInList");
    private final static QName _AddPoliticianResponse_QNAME = new QName("http://politic13.service.com/", "addPoliticianResponse");
    private final static QName _GetPoliticDescription_QNAME = new QName("http://politic13.service.com/", "getPoliticDescription");
    private final static QName _DisplayPoliticListResponse_QNAME = new QName("http://politic13.service.com/", "displayPoliticListResponse");
    private final static QName _GetTweetPoliticResponse_QNAME = new QName("http://politic13.service.com/", "getTweetPoliticResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.service.politic13
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClearList }
     * 
     */
    public ClearList createClearList() {
        return new ClearList();
    }

    /**
     * Create an instance of {@link AddPolitician }
     * 
     */
    public AddPolitician createAddPolitician() {
        return new AddPolitician();
    }

    /**
     * Create an instance of {@link DisplayPoliticList }
     * 
     */
    public DisplayPoliticList createDisplayPoliticList() {
        return new DisplayPoliticList();
    }

    /**
     * Create an instance of {@link ClearListResponse }
     * 
     */
    public ClearListResponse createClearListResponse() {
        return new ClearListResponse();
    }

    /**
     * Create an instance of {@link GetPoliticDescriptionResponse }
     * 
     */
    public GetPoliticDescriptionResponse createGetPoliticDescriptionResponse() {
        return new GetPoliticDescriptionResponse();
    }

    /**
     * Create an instance of {@link GetTweetPolitic }
     * 
     */
    public GetTweetPolitic createGetTweetPolitic() {
        return new GetTweetPolitic();
    }

    /**
     * Create an instance of {@link PoliticInListResponse }
     * 
     */
    public PoliticInListResponse createPoliticInListResponse() {
        return new PoliticInListResponse();
    }

    /**
     * Create an instance of {@link PoliticInList }
     * 
     */
    public PoliticInList createPoliticInList() {
        return new PoliticInList();
    }

    /**
     * Create an instance of {@link AddPoliticianResponse }
     * 
     */
    public AddPoliticianResponse createAddPoliticianResponse() {
        return new AddPoliticianResponse();
    }

    /**
     * Create an instance of {@link GetPoliticDescription }
     * 
     */
    public GetPoliticDescription createGetPoliticDescription() {
        return new GetPoliticDescription();
    }

    /**
     * Create an instance of {@link DisplayPoliticListResponse }
     * 
     */
    public DisplayPoliticListResponse createDisplayPoliticListResponse() {
        return new DisplayPoliticListResponse();
    }

    /**
     * Create an instance of {@link GetTweetPoliticResponse }
     * 
     */
    public GetTweetPoliticResponse createGetTweetPoliticResponse() {
        return new GetTweetPoliticResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://politic13.service.com/", name = "clearList")
    public JAXBElement<ClearList> createClearList(ClearList value) {
        return new JAXBElement<ClearList>(_ClearList_QNAME, ClearList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPolitician }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://politic13.service.com/", name = "addPolitician")
    public JAXBElement<AddPolitician> createAddPolitician(AddPolitician value) {
        return new JAXBElement<AddPolitician>(_AddPolitician_QNAME, AddPolitician.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayPoliticList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://politic13.service.com/", name = "displayPoliticList")
    public JAXBElement<DisplayPoliticList> createDisplayPoliticList(DisplayPoliticList value) {
        return new JAXBElement<DisplayPoliticList>(_DisplayPoliticList_QNAME, DisplayPoliticList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://politic13.service.com/", name = "clearListResponse")
    public JAXBElement<ClearListResponse> createClearListResponse(ClearListResponse value) {
        return new JAXBElement<ClearListResponse>(_ClearListResponse_QNAME, ClearListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPoliticDescriptionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://politic13.service.com/", name = "getPoliticDescriptionResponse")
    public JAXBElement<GetPoliticDescriptionResponse> createGetPoliticDescriptionResponse(GetPoliticDescriptionResponse value) {
        return new JAXBElement<GetPoliticDescriptionResponse>(_GetPoliticDescriptionResponse_QNAME, GetPoliticDescriptionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTweetPolitic }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://politic13.service.com/", name = "getTweetPolitic")
    public JAXBElement<GetTweetPolitic> createGetTweetPolitic(GetTweetPolitic value) {
        return new JAXBElement<GetTweetPolitic>(_GetTweetPolitic_QNAME, GetTweetPolitic.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PoliticInListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://politic13.service.com/", name = "politicInListResponse")
    public JAXBElement<PoliticInListResponse> createPoliticInListResponse(PoliticInListResponse value) {
        return new JAXBElement<PoliticInListResponse>(_PoliticInListResponse_QNAME, PoliticInListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PoliticInList }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://politic13.service.com/", name = "politicInList")
    public JAXBElement<PoliticInList> createPoliticInList(PoliticInList value) {
        return new JAXBElement<PoliticInList>(_PoliticInList_QNAME, PoliticInList.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddPoliticianResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://politic13.service.com/", name = "addPoliticianResponse")
    public JAXBElement<AddPoliticianResponse> createAddPoliticianResponse(AddPoliticianResponse value) {
        return new JAXBElement<AddPoliticianResponse>(_AddPoliticianResponse_QNAME, AddPoliticianResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetPoliticDescription }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://politic13.service.com/", name = "getPoliticDescription")
    public JAXBElement<GetPoliticDescription> createGetPoliticDescription(GetPoliticDescription value) {
        return new JAXBElement<GetPoliticDescription>(_GetPoliticDescription_QNAME, GetPoliticDescription.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayPoliticListResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://politic13.service.com/", name = "displayPoliticListResponse")
    public JAXBElement<DisplayPoliticListResponse> createDisplayPoliticListResponse(DisplayPoliticListResponse value) {
        return new JAXBElement<DisplayPoliticListResponse>(_DisplayPoliticListResponse_QNAME, DisplayPoliticListResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetTweetPoliticResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://politic13.service.com/", name = "getTweetPoliticResponse")
    public JAXBElement<GetTweetPoliticResponse> createGetTweetPoliticResponse(GetTweetPoliticResponse value) {
        return new JAXBElement<GetTweetPoliticResponse>(_GetTweetPoliticResponse_QNAME, GetTweetPoliticResponse.class, null, value);
    }

}
