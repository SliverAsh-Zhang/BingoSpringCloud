package com.bingo.demoProvider.mapper;
import org.apache.ibatis.annotations.Param;

import com.bingo.demoProvider.entity.China;

public interface ChinaMapper {
    China selectOneById(@Param("id") Integer id);
}




