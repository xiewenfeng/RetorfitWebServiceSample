package com.smilexie.retrofitsoapsample.webservice.response;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * 用户角色返回body
 * Created by SmileXie on 16/7/15.
 */
@Root(name = "Body")
public class WeatherResponseBody {

    @Element(name = "getWeatherbyCityNameResponse", required = false)
    public WeatherResponseModel getWeatherbyCityNameResponse;

}
