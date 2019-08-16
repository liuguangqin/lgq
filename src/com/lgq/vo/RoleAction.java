package com.lgq.vo;

import java.io.Serializable;

public class RoleAction implements Serializable {
    private Integer actid;
    private Integer rid;

    public Integer getActid() {
        return actid;
    }

    public void setActid(Integer actid) {
        this.actid = actid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }
}
