package com.lgq.vo;

import java.io.Serializable;

public class TravelEmp implements Serializable {
    private Integer teid;
    private Long tid;
    private Long eid;

    public Integer getTeid() {
        return teid;
    }

    public void setTeid(Integer teid) {
        this.teid = teid;
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getEid() {
        return eid;
    }

    public void setEid(Long eid) {
        this.eid = eid;
    }
}
