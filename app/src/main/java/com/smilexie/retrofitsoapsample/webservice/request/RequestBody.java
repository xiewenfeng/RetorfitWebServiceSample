package com.smilexie.retrofitsoapsample.webservice.request;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 用户角色返回body
 * Created by SmileXie on 16/7/15.
 */
@Root(name = "soapenv:Body", strict = false)
public class RequestBody {

    @Element(name = "getWeatherbyCityName", required = false)
    public RequestModel getWeatherbyCityName;
}
