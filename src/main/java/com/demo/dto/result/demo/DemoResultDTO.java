package com.demo.dto.result.demo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class DemoResultDTO {

    private long id;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private LocalDateTime publishTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }
}
