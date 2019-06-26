package com.zhengrz.weather.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import java.io.Reader;
import java.io.StringReader;

public class XmlBuilder {

    /**
     * 将XML转为指定的POJO
     * @param clazz
     * @param xmlStr
     * @return
     * @throws Exception
     */
    public static Object xmlStrToOject(Class<?> clazz, String xmlStr) throws Exception {
        Object xmlObject = null;
        try(Reader reader = new StringReader(xmlStr)) {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            xmlObject = unmarshaller.unmarshal(reader);
        }
        return xmlObject;
    }
}
