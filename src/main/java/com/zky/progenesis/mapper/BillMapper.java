package com.zky.progenesis.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zky.progenesis.entity.Bill;

@Mapper
public interface BillMapper extends BaseMapper<Bill> {
   
}
