package com.anyang.demo.domain.user;

import com.anyang.demo.domain.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class User extends BaseEntity {
    private String name;
    private String nickName;
    private String mobile;
    private String sex;
    private Integer age;
}
