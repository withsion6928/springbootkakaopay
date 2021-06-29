package com.kpsec.test.controller;

import com.kpsec.test.model.*;
import com.kpsec.test.service.AccountService;
import com.kpsec.test.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "TestSubmit")
@RestController
@RequestMapping("/test/")
public class TestSubmitController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping(value = "/ap1/accno")
    public List<Api1> getGroupByYearAccNo() {

        return transactionService.getGroupByYearAccNo();
    }


    @GetMapping(value = "/ap2/account/no")
    public List<Api2> getNoneTrAccount() {

        return transactionService.getNoneTrAccount();
    }

    @GetMapping(value = "/ap3/year/branch")
    public ResponseEntity<Map<String, Object>> getGroupByYearBr() {
        List<Api3> api3 = transactionService.getGroupByYearBr();

        Map<String, Object> parent = new HashMap<>();

        api3.forEach(d -> {
            String r = d.getYear();
            Map<String, String> child = new HashMap<>();
            child.put("brName", d.getBrName());
            child.put("brCode", d.getBrCode());
            child.put("sumAmt", d.getSumAmt());

            if (parent.containsKey(r)) {
                List<Map<String, String>> children = (List<Map<String, String>>) parent.get(r);
                children.add(child);
            }
             else {
                List<Map<String, String>> children = new ArrayList<>();
                children.add(child);
                parent.put(r, children);
            }
        });
        return ResponseEntity.ok().body(parent);
    }





    @GetMapping(value = "/ap4/branch", produces="application/json;charset=UTF-8")
    public List<Api4> getBranchSumAmt(@RequestParam String branchName) {
        List<Api4> api4 = transactionService.getBranchSumAmt(branchName);
        return api4 ;

    }
}
