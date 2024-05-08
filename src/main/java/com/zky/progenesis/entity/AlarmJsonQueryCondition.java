package com.zky.progenesis.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlarmJsonQueryCondition {
    private String key;
    private String value;

    public enum ConditonType {
        like, equal, orderByAsc, orderByDesc
    }

    private ConditonType conditionType;
}