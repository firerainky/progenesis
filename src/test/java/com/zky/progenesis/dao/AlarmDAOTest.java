package com.zky.progenesis.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zky.progenesis.entity.Alarm;
import com.zky.progenesis.mapper.AlarmMapper;

@SpringBootTest
public class AlarmDAOTest {

    @Autowired
    private AlarmMapper alarmMapper;

    @Autowired
    private AlarmDAO sut;

    @BeforeEach
    public void setUp() {
        alarmMapper.delete(null);
    }

    @Test
    public void test_findAllSavedAlarms() throws ParseException {

        Date submitTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2022/01/01 00:00:00");
        Alarm alarm1  = Alarm.builder().source("source1").content("content1").submitTime(submitTime).build();
        Alarm alarm2  = Alarm.builder().source("source2").content("content2").submitTime(submitTime).build();
        List<Alarm> alarms = Arrays.asList(alarm1, alarm2);

        // Act
        sut.saveAlarms(alarms);
        List<Alarm> result = sut.findAll();

        // Assert
        assertEquals(alarms, result);
    }
}