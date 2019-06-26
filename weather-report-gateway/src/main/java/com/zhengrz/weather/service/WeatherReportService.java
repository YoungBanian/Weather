package com.zhengrz.weather.service;

import com.zhengrz.weather.vo.Weather;

public interface WeatherReportService {

    /**
     * 根据城市ID查询天气信息
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);

}
