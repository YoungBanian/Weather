package com.zhengrz.weather.service;

import com.zhengrz.weather.vo.City;
import com.zhengrz.weather.vo.WeatherResponse;

import java.util.List;

public class DataClientFallback  implements WeatherDataServiceClient{


    @Override
    public List<City> listCity() throws Exception {
        return null;
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return null;
    }

}
