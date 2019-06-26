package com.zhengrz.weather.controller;

import com.zhengrz.weather.service.WeatherDataServiceClient;
import com.zhengrz.weather.service.WeatherReportService;
import com.zhengrz.weather.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/report")
public class WeatherReportController {
    private final static Logger log = LoggerFactory.getLogger(WeatherReportController.class);

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private WeatherDataServiceClient weatherDataServiceClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        // 获取城市ID列表
        List<City> cityList = null;

        try {
            // 由城市数据API微服务提供数据
            cityList = weatherDataServiceClient.listCity();

        } catch (Exception e) {
            log.error("Exception!", e);
        }

        model.addAttribute("title", "基于SpringCloud的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityList);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }

}

