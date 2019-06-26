package com.zhengrz.weather.service.impl;

import com.zhengrz.weather.service.CityDataService;
import com.zhengrz.weather.util.XmlBuilder;
import com.zhengrz.weather.vo.City;
import com.zhengrz.weather.vo.CityList;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class CityDataServiceImpl implements CityDataService {
    @Override
    public List<City> listCity() throws Exception {
        Resource resource = new ClassPathResource("citylist.xml");
        StringBuffer sb = new StringBuffer();
        try (BufferedReader buf = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"))) {
            String line = "";
            while ((line = buf.readLine()) != null)
                sb.append(line);
        }
        CityList cityList = (CityList) XmlBuilder.xmlStrToOject(CityList.class, sb.toString());
        return cityList.getCityList();
    }
}
