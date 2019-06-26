package com.zhengrz.weather.vo;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class CityList {
    @XmlElement(name = "d")
    List<City> cityList;

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public List<City> getCityList() {
        return this.cityList;
    }

}
