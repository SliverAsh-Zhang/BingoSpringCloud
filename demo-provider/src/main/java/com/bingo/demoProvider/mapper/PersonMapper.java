package com.bingo.demoProvider.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bingo.demoProvider.entity.China;
import com.bingo.demoProvider.request.PersonRequestDemoTwo;
import com.bingo.demoProvider.response.PersonResponseDemoTwo;
import org.apache.ibatis.annotations.Param;

import com.bingo.demoProvider.entity.Person;

import java.util.List;

public interface PersonMapper extends BaseMapper<PersonMapper> {

    IPage<Person> selectAllByCity (Page<?> page, @Param("city") String city);

    List<PersonResponseDemoTwo> selectAllDemoTwo (@Param("requestParams")PersonRequestDemoTwo requestParams);
}




