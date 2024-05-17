package com.zky.progenesis.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.zky.progenesis.dao.BillDAO;
import com.zky.progenesis.entity.Bill;
import com.zky.progenesis.interceptor.NewInterceptor;
import com.zky.progenesis.mapper.BillMapper;

@AutoConfigureMockMvc
@SpringBootTest
public class BillControllerTest {

    @Autowired
    private BillMapper billMapper;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BillDAO billDAO;

    @BeforeEach
    public void setUp(WebApplicationContext wac) {
        billMapper.delete(null);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new BillController(billDAO)).addInterceptors(new NewInterceptor()).build();
    }

    @Test
    public void test_getBills() throws Exception {
        // Arrange
        Bill bill0 = Bill.builder().lvl1_org_id("1").build();
        Bill bill1 = Bill.builder().lvl1_org_id("2").build();
        billDAO.saveBills(List.of(bill0, bill1));

        // String content = "{\"tenantId\": \"2\"}";

        ResultActions actions = mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.GET, "/bills?tenantId=2"));

        actions.andExpect(MockMvcResultMatchers.status().isOk())
                // .andExpect(MockMvcResultMatchers.content().json("[{\"lvl1_org_id\":\"2\"}]"))
                .andDo(print());
    }
}