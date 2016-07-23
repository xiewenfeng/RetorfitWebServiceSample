package com.smilexie.retrofitsoapsample.webservice.request;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;

/**
 * 获取具体信息需要传的参数
 * Created by SmileXie on 16/7/15.
 */

public class RequestModel {
    @Attribute(name = "xmlns")
    public String cityNameAttribute;

    @Element(name = "theCityName", required = false)
    public String theCityName;     //城市名字

}
