package com.zhengrz.weather.job;

import com.zhengrz.weather.service.CityServiceClient;
import com.zhengrz.weather.service.WeatherDataCollectionService;
import com.zhengrz.weather.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;
import java.util.stream.Collectors;

public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger log = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityServiceClient cityServiceClient;

    @Override
    public void executeInternal(JobExecutionContext context) throws JobExecutionException {
        collectWeatherData();
    }

    public void collectWeatherData() {
        log.info("Weather Data Sync Job is starting...");
        // 获取城市ID列表
        List<City> cities = null;
        try {
            // 由城市数据API微服务提供数据
            cities = cityServiceClient.listCity();
        } catch (Exception e) {
            log.error("Get City List Fail: ", e);
        }
        if (null != cities) {
            List<String> cityIds = cities.parallelStream().map(c -> {
                String cityId = c.getCityId();
                log.info("City("+ cityId +")'s Weather Data Sync Job is starting...");
                weatherDataCollectionService.syncDateByCityId(cityId);
                return cityId;
            }).collect(Collectors.toList());
            log.info("Weather Data were successfully collected in ("+ cityIds.size() +") cities.");
        }
    }

}
