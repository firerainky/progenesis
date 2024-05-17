package com.zky.progenesis.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zky.progenesis.dao.BillDAO;
import com.zky.progenesis.entity.Bill;


@RestController
public class BillController {

    private BillDAO billDAO;

    public BillController(BillDAO billDAO) {
        this.billDAO = billDAO;
    }

    @GetMapping("/bills")
    public List<Bill> getBills() throws ParseException {
        return billDAO.findAll();
    }
}
