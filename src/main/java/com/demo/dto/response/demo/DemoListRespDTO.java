package com.demo.dto.response.demo;

import com.demo.dto.request.page.PageInfoReqDTO;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public class DemoListRespDTO extends PageInfoReqDTO {

    private long id;

    private String demoName;

    private String demoKey;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createDate;

    private DemoAddr demoAddr;

    private List<DemoItem> demoItemList;

    public static class DemoAddr {

        private long addrId;

        private String fullAddress;

        public long getAddrId() {
            return addrId;
        }

        public void setAddrId(long addrId) {
            this.addrId = addrId;
        }

        public String getFullAddress() {
            return fullAddress;
        }

        public void setFullAddress(String fullAddress) {
            this.fullAddress = fullAddress;
        }
    }

    public static class DemoItem {

        private long itemId;

        private String itemName;

        public long getItemId() {
            return itemId;
        }

        public void setItemId(long itemId) {
            this.itemId = itemId;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDemoName() {
        return demoName;
    }

    public void setDemoName(String demoName) {
        this.demoName = demoName;
    }

    public String getDemoKey() {
        return demoKey;
    }

    public void setDemoKey(String demoKey) {
        this.demoKey = demoKey;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public DemoAddr getDemoAddr() {
        return demoAddr;
    }

    public void setDemoAddr(DemoAddr demoAddr) {
        this.demoAddr = demoAddr;
    }

    public List<DemoItem> getDemoItemList() {
        return demoItemList;
    }

    public void setDemoItemList(List<DemoItem> demoItemList) {
        this.demoItemList = demoItemList;
    }
}
