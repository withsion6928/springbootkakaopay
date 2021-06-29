package com.kpsec.test.controller;

import org.junit.jupiter.api.Test;	// {1}
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = TestSubmitController.class)
public class TestSubmitControllerTest {

    @Autowired
    private MockMvc mvc;



    @Test
    public void getGroupByYearAccNo() throws Exception {
        mvc.perform(get("/ap1/accno"))
                .andExpect(status().isOk());
    }

    @org.junit.Test
    public void getNoneTrAccount() throws Exception {
        mvc.perform(get("/ap2/account/no"))
                .andExpect(status().isOk());
    }

    @org.junit.Test
    public void getGroupByYearBr() throws Exception {

        mvc.perform(get("/ap3/year/branch"))
                .andExpect(status().isOk());

    }

    @org.junit.Test
    public void getBranchSumAmt() throws Exception {
        mvc.perform(get("/ap4/branch"))
                .andExpect(status().isOk())
                .andExpect(content().json("\"branchName\" : \"분당점\"" ));


    }
}