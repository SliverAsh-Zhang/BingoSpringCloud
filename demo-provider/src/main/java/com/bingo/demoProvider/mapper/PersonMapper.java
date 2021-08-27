package com.bingo.demoProvider.mapper;
import org.apache.ibatis.annotations.Param;

import com.bingo.demoProvider.entity.Person;

public interface PersonMapper {
    Person selectOneByCity(@Param("city") String city);
}




