package com.demo.dto.response.page;

import java.util.List;

/**
 * Created by Arthur on 2017/3/7 0007.
 */
public class PageListRespDTO<T> {

    private List<T> content;

    private PageInfoRespDTO pageInfo;

    public PageListRespDTO() {
    }

    public PageListRespDTO(List<T> content, PageInfoRespDTO pageInfo) {
        this.content = content;
        this.pageInfo = pageInfo;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public PageInfoRespDTO getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfoRespDTO pageInfo) {
        this.pageInfo = pageInfo;
    }
}
