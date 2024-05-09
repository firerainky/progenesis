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
import com.zky.progenesis.entity.AlarmJsonQueryCondition;
import com.zky.progenesis.entity.AlarmJsonQueryCondition.ConditonType;
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
        String jsonStr1 = "{\"key\": \"value1\"}";
        String jsonStr2 = "{\"key\": \"value2\"}";

        Alarm alarm1 = Alarm.builder().source("source1").content(jsonStr1).submitTime(submitTime).build();
        Alarm alarm2 = Alarm.builder().source("source2").content(jsonStr2).submitTime(submitTime).build();
        List<Alarm> alarms = Arrays.asList(alarm1, alarm2);

        // Act
        sut.saveAlarms(alarms);
        List<Alarm> result = sut.findAll();

        // Assert
        assertEquals(alarms, result);
    }

    @Test
    public void test_findAllSavedAlarmsWithKeyValueInJsonColumn() throws ParseException {

        Date submitTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2022/01/01 00:00:00");
        String jsonStr1 = "{\"key\": \"value1\"}";
        String jsonStr2 = "{\"key\": \"value2\"}";

        Alarm alarm1 = Alarm.builder().source("source1").content(jsonStr1).submitTime(submitTime).build();
        Alarm alarm2 = Alarm.builder().source("source2").content(jsonStr2).submitTime(submitTime).build();
        List<Alarm> alarms = Arrays.asList(alarm1, alarm2);
        List<Alarm> expected = Arrays.asList(alarm1);

        // Act
        sut.saveAlarms(alarms);
        List<Alarm> result = sut.findByJsonValue("key", "value1");

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void test_findAllSavedAlarmsOrderedByValueInJsonColumn() throws ParseException {

        Date submitTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2022/01/01 00:00:00");
        String jsonStr1 = "{\"key\": \"value1\"}";
        String jsonStr2 = "{\"key\": \"value2\"}";

        Alarm alarm1 = Alarm.builder().source("source1").content(jsonStr1).submitTime(submitTime).build();
        Alarm alarm2 = Alarm.builder().source("source2").content(jsonStr2).submitTime(submitTime).build();
        List<Alarm> alarms = Arrays.asList(alarm2, alarm1);
        List<Alarm> expected = Arrays.asList(alarm1, alarm2);

        // Act
        sut.saveAlarms(alarms);
        List<Alarm> result = sut.findOrderedByJsonValue("key");

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void test_findAllSavedAlarmsOrderedByValueInJsonColumnWithPagination() throws ParseException {

        Date submitTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2022/01/01 00:00:00");
        String jsonStr1 = "{\"key\": \"value1\"}";
        String jsonStr2 = "{\"key\": \"value2\"}";
        String jsonStr3 = "{\"key\": \"value3\"}";

        Alarm alarm1 = Alarm.builder().source("source1").content(jsonStr1).submitTime(submitTime).build();
        Alarm alarm2 = Alarm.builder().source("source2").content(jsonStr2).submitTime(submitTime).build();
        Alarm alarm3 = Alarm.builder().source("source3").content(jsonStr3).submitTime(submitTime).build();
        List<Alarm> alarms = Arrays.asList(alarm3, alarm2, alarm1);
        List<Alarm> expected = Arrays.asList(alarm1, alarm2);

        // Act
        sut.saveAlarms(alarms);
        List<Alarm> result = sut.findOrderedByJsonValueWithPagination("key", 2, 0);

        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void test_findAllSavedAlarmsByConditionsWithPagination() throws ParseException {

        Date submitTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse("2022/01/01 00:00:00");
        String jsonStr1 = "{\"key\": \"value1\", \"level\": 3, \"description\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"}";
        String jsonStr2 = "{\"key\": \"value1\", \"level\": 2, \"description\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"}";
        String jsonStr3 = "{\"key\": \"value1\", \"level\": 2, \"description\": \"Lorem ipsum dolor sit amat, consectetur adipiscing elit. \"}";
        String jsonStr4 = "{\"key\": \"value1\", \"level\": 1, \"description\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"}";
        String jsonStr5 = "{\"key\": \"value2\", \"level\": 3, \"description\": \"Lorem ipsum dolor sit amet, consectetur adipiscing elit. \"}";

        Alarm alarm1 = Alarm.builder().source("source").content(jsonStr1).submitTime(submitTime).build();
        Alarm alarm2 = Alarm.builder().source("source").content(jsonStr2).submitTime(submitTime).build();
        Alarm alarm3 = Alarm.builder().source("source").content(jsonStr3).submitTime(submitTime).build();
        Alarm alarm4 = Alarm.builder().source("source").content(jsonStr4).submitTime(submitTime).build();
        Alarm alarm5 = Alarm.builder().source("source").content(jsonStr5).submitTime(submitTime).build();
        List<Alarm> alarms = Arrays.asList(alarm1, alarm2, alarm3, alarm4, alarm5);
        List<Alarm> expected = Arrays.asList(alarm4, alarm2);

        AlarmJsonQueryCondition conditionEqual = AlarmJsonQueryCondition.builder().key("key").value("value1").conditionType(ConditonType.equal).build();
        AlarmJsonQueryCondition conditionLike = AlarmJsonQueryCondition.builder().key("description").value("amet").conditionType(ConditonType.like).build();
        AlarmJsonQueryCondition conditionOrderByAsc = AlarmJsonQueryCondition.builder().key("level").conditionType(ConditonType.orderByAsc).build();
        List<AlarmJsonQueryCondition> queryConditions = Arrays.asList(conditionEqual, conditionLike, conditionOrderByAsc);

        // Act
        sut.saveAlarms(alarms);
        List<Alarm> result = sut.findByConditionsWithPagination(queryConditions, "source", 2, 0);

        // Assert
        assertEquals(expected, result);
    }
}