package com.bingo.demoProvider.mapper;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import com.bingo.demoProvider.entity.China;

public interface ChinaMapper{

    China selectOneById(@Param("id") Integer id);

    List<China> selectAllByType(@Param("type") Integer type);

    IPage<China> selectAllByType (Page<?> page, @Param("type") Integer type);



}




