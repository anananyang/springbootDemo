package com.anyang.demo.domain.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity extends IdEntity {
    protected Long creator;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date gmtCreate;
    protected Long modifier;
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    protected Date gmtModified;
    protected String isDeleted;


    public void setDefaultBiz(Long userId) {
        if (userId == null) {
            userId = 1l;
        }
        Date now = new Date();
        if (id == null) {
            this.gmtCreate = now;
            this.creator = userId;
            this.isDeleted = "N";
        }
        this.modifier = userId;
        this.gmtModified = now;
    }

}
