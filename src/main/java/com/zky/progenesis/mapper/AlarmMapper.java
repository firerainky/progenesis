package com.zky.progenesis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zky.progenesis.entity.Alarm;

@Mapper
public interface AlarmMapper extends BaseMapper<Alarm> {

    @Select("SELECT * FROM ic_alarms WHERE JSON_EXTRACT(content, CONCAT('$.', #{key})) = #{value}")
    List<Alarm> selectByJsonValue(@Param("key") String key, @Param("value") String value);

    @Select("SELECT * FROM ic_alarms ORDER BY JSON_EXTRACT(content, CONCAT('$.', #{key}))")
    List<Alarm> selectOrderedByJsonValue(String key);

    @Select("SELECT * FROM ic_alarms ORDER BY JSON_EXTRACT(content, CONCAT('$.', #{key})) LIMIT #{pageSize} OFFSET #{offset}")
    List<Alarm> selectOrderedByJsonValueWithPagination(String key, int pageSize, int offset);

    List<Alarm> selectByConditionsWithPagination(@Param("source") String source,
                                                         @Param("conditions") String conditions,
                                                         @Param("pageSize") int pageSize,
                                                         @Param("offset") int offset);
}
