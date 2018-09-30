package com.demo.dto.request.demo;

import com.demo.dto.request.page.PageInfoReqDTO;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class DemoListReqDTO extends PageInfoReqDTO {

    private long id;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }
}
