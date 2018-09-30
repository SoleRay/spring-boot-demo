package com.demo.dto.response.page;

/**
 * Created by Arthur on 2016/12/30 0030.
 */
public class PageInfoRespDTO {

    private int pageNum;

    private int pageSize;

    private long totalNum;

    private int totalPages;

    public PageInfoRespDTO(){

    }

    public PageInfoRespDTO(int pageNum, int pageSize, long totalNum, int totalPages) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPages = totalPages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(long totalNum) {
        this.totalNum = totalNum;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
