package com.demo.bean.page;

import com.demo.dto.response.page.PageInfoRespDTO;

/**
 * Created by Arthur on 2016/12/30 0030.
 */
public class Pageable {

    private int pageNum=1;

    private int pageSize=10;

    public Pageable(int pageNum, int pageSize) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public long getStart(){
        return (pageNum-1)*pageSize;
    }

    public int getTotalPages(long totalCount){

        if(totalCount==0){
            return 1;
        }

        if(totalCount%pageSize==0){
            return (int) (totalCount/pageSize);
        }

        return (int) (totalCount/pageSize+1);
    }

    private int genPageSize(long totalPages, long totalCount) {
        if(totalPages==1){
            return (int) totalCount;
        }

        if(pageNum<totalPages){
            return pageSize;
        }

        return (int) (totalCount - (pageNum-1)*pageSize);

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

    public PageInfoRespDTO genPageInfo(long totalCount){
        int totalPages = getTotalPages(totalCount);
        int currentSize = genPageSize(totalPages,totalCount);

        return new PageInfoRespDTO(pageNum,currentSize,totalCount,totalPages);
    }




}
