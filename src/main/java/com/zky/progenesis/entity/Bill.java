package com.zky.progenesis.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("bills")
public class Bill {
    private Long id;
    private String userName;
    private String lvl1_org_id;
    private String lvl2_org_id;
    private String lvl3_org_id;
}
