package com.demo.entity.demo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Table(name = "tb_demo")
public class Demo {

    @Id
    private Long id;

    @Column(name = "demo_key")
    private String demoKey;

    @Column(name = "demo_name")
    private String demoName;

    @Column(name = "create_date")
    private LocalDate createDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDemoKey() {
        return demoKey;
    }

    public void setDemoKey(String demoKey) {
        this.demoKey = demoKey;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
