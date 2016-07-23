package com.smilexie.retrofitsoapsample.webservice.response;



import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.NamespaceList;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * 用户角色返回
 * Created by SmileXie on 16/7/15.
 */

@Root(name = "getWeatherbyCityNameResponse")
@Namespace(reference = "http://WebXml.com.cn/")
public class WeatherResponseModel {

    @ElementList(name = "getWeatherbyCityNameResult")
    public List<String> result;

}
