package com.bingo.demoProvider.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("BDF2_USER_DEPT")
public class SimplePojo {
	@TableId("ID_")
	private String id;
	@TableField("DEPT_ID_")
	private String deptId;
	@TableField("USERNAME_")
	private String userName;
	@TableField("BANK_CODE")
	private String bankCode;
}
