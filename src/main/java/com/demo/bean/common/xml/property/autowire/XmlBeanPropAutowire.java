package com.demo.bean.common.xml.property.autowire;

import com.demo.bean.common.base.PlainBean;

import java.util.List;
import java.util.Properties;

public class XmlBeanPropAutowire {


    private int age;

    private PlainBean plainBean;


    private Properties properties;


    private List<String> strList;

    public List<String> getStrList() {
        return strList;
    }

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public PlainBean getPlainBean() {
        return plainBean;
    }

    public void setPlainBean(PlainBean plainBean) {
        this.plainBean = plainBean;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
