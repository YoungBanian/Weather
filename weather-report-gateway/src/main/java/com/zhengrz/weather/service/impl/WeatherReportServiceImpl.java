package com.zhengrz.weather.service.impl;

import com.zhengrz.weather.service.WeatherDataServiceClient;
import com.zhengrz.weather.service.WeatherReportService;
import com.zhengrz.weather.vo.Weather;
import com.zhengrz.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataServiceClient weatherDataServiceClient;

    @Override
    public Weather getDataByCityId(String cityId) {

        // 由天气数据API微服务来提供
        WeatherResponse resp = weatherDataServiceClient.getDataByCityId(cityId);
        Weather data = null;
        if (resp != null ) {
            return resp.getData();
        }
        return data;
    }

}
