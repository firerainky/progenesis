package com.zky.progenesis.dao;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.zky.progenesis.entity.Bill;
import com.zky.progenesis.mapper.BillMapper;

@SpringBootTest
public class BillDAOTest {
    @Autowired
    private BillMapper billMapper;

    @Autowired
    private BillDAO billDAO;

    @BeforeEach
    public void setUp() {
        billMapper.delete(null);
    }

    @Test
    public void test_selectBillsWithMatchedTenantId() {
        Bill bill0 = Bill.builder().lvl1_org_id("1").build();
        Bill bill1 = Bill.builder().lvl1_org_id("2").build();
        billDAO.saveBills(List.of(bill0, bill1));

        List<Bill> expectedBills = List.of(bill0);

        // Act
        List<Bill> bills = billDAO.findAll();

        Assertions.assertEquals(expectedBills, bills);
    }
}
