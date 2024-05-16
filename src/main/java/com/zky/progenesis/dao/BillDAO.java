package com.zky.progenesis.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zky.progenesis.entity.Bill;
import com.zky.progenesis.mapper.BillMapper;

@Component
public class BillDAO {
    private BillMapper billMapper;

    public BillDAO(BillMapper billMapper) {
        this.billMapper = billMapper;
    }

    public void saveBills(List<Bill> bills) {
        bills.forEach(bill -> billMapper.insert(bill));
    }

    public List<Bill> findAll() {
        return billMapper.selectList(null);
    }
}
