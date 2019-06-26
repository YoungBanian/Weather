package com.zhengrz.weather.service;

import com.zhengrz.weather.vo.City;
import com.zhengrz.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "weather-client-zuul", fallback=DataClientFallback.class)
public interface WeatherDataServiceClient {

    /**
     * 获取城市列表
     * @return
     * @throws Exception
     */
    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;

    /**
     * 根据城市ID查询天气数据
     */
    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);

}
