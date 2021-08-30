package com.bingo.demoProvider.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PersonRequestDemoTwo {
    @ApiModelProperty(value = "工资基线")
    private int salary;
}
