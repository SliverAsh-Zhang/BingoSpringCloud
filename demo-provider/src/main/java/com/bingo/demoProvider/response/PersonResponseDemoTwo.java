package com.bingo.demoProvider.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PersonResponseDemoTwo {

    @ApiModelProperty(value = "省份")
    private String provincial;
    @ApiModelProperty(value = "总人数")
    private int countSum;
    @ApiModelProperty(value = "男性人数")
    private int countMan;
    @ApiModelProperty(value = "女性任务")
    private int countWomen;
}
