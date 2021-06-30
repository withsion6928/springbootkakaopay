package com.kpsec.test.controller;

import com.kpsec.test.AbstractControllerTest;
import org.junit.jupiter.api.Test;	// {1}
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


public class TestSubmitControllerTest extends AbstractControllerTest {

    @Autowired
    private TestSubmitController testSubmitController;

    @Override
    protected Object controller() {
        return testSubmitController;
    }

    @Test
    public void getGroupByYearAccNo() throws Exception {
        mockMvc.perform(get("/test/ap1/accno"))
                .andExpect(status().isOk());
    }
    @Test
    public void getNoneTrAccount() throws Exception {
        mockMvc.perform(get("/test/ap2/account/no"))
                .andExpect(status().isOk());
    }
    @Test
    public void getGroupByYearBr() throws Exception {

        mockMvc.perform(get("/test/ap3/year/branch"))
                .andExpect(status().isOk());

    }
    @Test
    public void getBranchSumAmt() throws Exception {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("branchName", "분당점");

        mockMvc.perform(get("/test/ap4/branch")
                .params(params))
               ;


    }


}