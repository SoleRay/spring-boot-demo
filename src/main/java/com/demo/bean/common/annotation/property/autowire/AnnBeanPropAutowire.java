package com.demo.bean.common.annotation.property.autowire;

import com.demo.bean.common.base.PlainBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Component
@Lazy
public class AnnBeanPropAutowire {

    @Value("6")
    private int age;

    @Autowired
    private PlainBean plainBean;

    @Autowired
    private List<PlainBean> annList;

    @Autowired
    private Set<PlainBean> annSet;

    @Autowired
    private Map<String,PlainBean> annMap;

    @Autowired
    private List<? extends PlainBean> apbList;

    @Autowired
    private PlainBean[] plainBeans;

    @Value("#{{'one':'Monday','two':'Tuesday','three':'Wednesday'}}")
    private Map<String,String> strMap;

    @Value("#{'box,john,mike'.split(',')}")
    private List<String> strList;

    @Value("#{'apple,banana,pear'.split(',')}")
    private String[] strArray;

    @Lazy
    private String name;



    public PlainBean getPlainBean() {
        return plainBean;
    }

    public void setPlainBean(PlainBean plainBean) {
        this.plainBean = plainBean;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<PlainBean> getAnnList() {
        return annList;
    }

    public void setAnnList(List<PlainBean> annList) {
        this.annList = annList;
    }

    public Set<PlainBean> getAnnSet() {
        return annSet;
    }

    public void setAnnSet(Set<PlainBean> annSet) {
        this.annSet = annSet;
    }

    public Map<String, PlainBean> getAnnMap() {
        return annMap;
    }

    public void setAnnMap(Map<String, PlainBean> annMap) {
        this.annMap = annMap;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AnnBeanPropAutowire{" +
                "plainBean=" + plainBean +
                ", age=" + age +
                '}';
    }
}
