package com.zky.progenesis.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zky.progenesis.entity.Alarm;
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
}
