package com.bingo.demoProvider.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PersonRequestDemoOne {

    @ApiModelProperty(value = "手机号", required = true)
    private String mobile;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private Byte sex;

    @ApiModelProperty(value = "所属国家")
    private String nation;

    @ApiModelProperty(value = "所属省份")
    private String provincial;

    @ApiModelProperty(value = "所属城市")
    private String city;

    @ApiModelProperty(value = "所属区县")
    private String area;

    @ApiModelProperty(value = "工资")
    private Integer salary;

}
