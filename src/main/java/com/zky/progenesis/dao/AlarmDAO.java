package com.zky.progenesis.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.zky.progenesis.entity.Alarm;
import com.zky.progenesis.entity.AlarmJsonQueryCondition;
import com.zky.progenesis.mapper.AlarmMapper;

@Component
public class AlarmDAO {
    
    private AlarmMapper alarmMapper;

    public AlarmDAO(AlarmMapper alarmMapper) {
        this.alarmMapper = alarmMapper;
    }

    public void saveAlarms(List<Alarm> alarms) {
        alarms.forEach(alarm -> alarmMapper.insert(alarm));
    }

    public List<Alarm> findAll() {
        return alarmMapper.selectList(null);
    }

    public List<Alarm> findByJsonValue(String key, String value) {
        return alarmMapper.selectByJsonValue(key, value);
    }

    public List<Alarm> findOrderedByJsonValue(String key) {
        return alarmMapper.selectOrderedByJsonValue(key);
    }

    public List<Alarm> findOrderedByJsonValueWithPagination(String key, int pageSize, int offset) {
        return alarmMapper.selectOrderedByJsonValueWithPagination(key, pageSize, offset);
    }

    public List<Alarm> findByConditionsWithPagination(List<AlarmJsonQueryCondition> queryConditions, String source, int pageSize, int offset) {
        StringBuilder conditions = new StringBuilder();
        List<String> orderByList = new ArrayList<>();

        queryConditions.forEach(queryCondition -> {
            switch (queryCondition.getConditionType()) {
                case orderByAsc:
                    orderByList.add("JSON_EXTRACT(content, CONCAT('$.', '" + queryCondition.getKey() + "'))" + " ASC");
                    break;
                case orderByDesc:
                    orderByList.add("JSON_EXTRACT(content, CONCAT('$.', '" + queryCondition.getKey() + "'))" + " DESC");
                    break;
                case like:
                    conditions.append(" AND JSON_EXTRACT(content, CONCAT('$.', '" + queryCondition.getKey() + "')) LIKE '%" + queryCondition.getValue() + "%'");
                    break;
                case equal:
                    conditions.append(" AND JSON_EXTRACT(content, CONCAT('$.', '" + queryCondition.getKey() + "')) = '" + queryCondition.getValue() + "'");
                    break;
                default:
                    break;
            }
        });

        if (orderByList.size() > 0) {
            conditions.append(" ORDER BY ");
            conditions.append(String.join(", ", orderByList));
        }

        System.out.println("Conditions: " + conditions.toString());

        return alarmMapper.selectByConditionsWithPagination(source, conditions.toString(), pageSize, offset);
    }
}
