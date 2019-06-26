package com.zhengrz.weather.service;


import com.zhengrz.weather.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("weather-city-service")
public interface CityServiceClient {
    @GetMapping("/cities")
    List<City> listCity() throws Exception;

}
