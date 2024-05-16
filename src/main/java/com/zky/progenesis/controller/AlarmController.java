package com.zky.progenesis.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zky.progenesis.dao.AlarmDAO;
import com.zky.progenesis.entity.Alarm;


@RestController
public class AlarmController {

    private AlarmDAO alarmDAO;

    public AlarmController(AlarmDAO alarmDAO) {
        this.alarmDAO = alarmDAO;
    }

    @GetMapping("/alarms")
    public List<Alarm> getAlarms() throws ParseException {
        Date submitTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2022/01/01 00:00:00");
        String jsonStr1 = "{\"key\": \"value1\"}";
        String jsonStr2 = "{\"key\": \"value2\"}";

        Alarm alarm1 = Alarm.builder().source("source1").content(jsonStr1).submitTime(submitTime).build();
        Alarm alarm2 = Alarm.builder().source("source2").content(jsonStr2).submitTime(submitTime).build();
        List<Alarm> alarms = Arrays.asList(alarm1, alarm2);
        
        alarmDAO.saveAlarms(alarms);
        return alarmDAO.findAll();
    }
}
