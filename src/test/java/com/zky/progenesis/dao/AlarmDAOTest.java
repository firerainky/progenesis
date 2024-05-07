package com.zky.progenesis.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zky.progenesis.entity.Alarm;

@SpringBootTest
public class AlarmDAOTest {

    @Autowired
    private AlarmDAO sut;

    @Test
    public void test_findAllSavedAlarms() {

        Alarm alarm1  = Alarm.builder().source("source1").content("content1").submitTime(new Date()).build();
        Alarm alarm2  = Alarm.builder().source("source2").content("content2").submitTime(new Date()).build();
        List<Alarm> alarms = Arrays.asList(alarm1, alarm2);

        // Act
        sut.saveAlarms(alarms);
        List<Alarm> result = sut.findAll();

        // Assert
        assertEquals(alarms, result);
    }
}