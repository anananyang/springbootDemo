package com.anyang.demo.domain.base;

import lombok.Data;


public class BaseEntity {
    private Long id;
    private Long creator;
    private Data gmtCreate;
    private Long modifier;
    private Data gmtModified;
}
