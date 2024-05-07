package com.zky.progenesis.entity;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("ic_alarms")
public class Alarm {
    private Integer id;
    private String source;
    private String content;
    private Date submitTime;
}
