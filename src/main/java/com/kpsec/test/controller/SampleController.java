package com.kpsec.test.controller;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.kpsec.test.model.*;
import com.kpsec.test.service.AccountService;
import com.kpsec.test.service.TransactionService;
import com.kpsec.test.user.UserNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Api(tags = "Sample")
@RestController
@RequestMapping("/test/")
public class SampleController {
    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionService transactionService;

    @ApiOperation(value = "sample")
    @GetMapping(value = "/acount")
    public List<AccountResult> getAccountInfo(String branchCode) {
        return accountService.getAccountByBranchCode(branchCode);
    }

    @GetMapping(value = "/yearmax")
    public List<Api1> getGroupByYearAccNo() {

        return transactionService.getGroupByYearAccNo();
    }


    @GetMapping(value = "/account/tr/none")
    public List<Api2> getNoneTrAccount() {

        return transactionService.getNoneTrAccount();
    }

    @GetMapping(value = "/year/branch/sum")
    public ResponseEntity<Map<String, Object>> getGroupByYearBr() {
        List<Api3> api3 = transactionService.getGroupByYearBr();

        Map<String, Object> parent = new HashMap<>();
        parent.put("year", api3.get(0).getYear());

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





    @GetMapping(value = "/branch/sum", produces="text/plain;charset=UTF-8")
    public List<Api4> getBranchSumAmt(@RequestBody String branchName) {
        List<Api4> api4 = transactionService.getBranchSumAmt(branchName);
        if(api4 == null){
            throw new UserNotFoundException(String.format("getBrName[%s] not found", ""));

        }


        return api4 ;


//        List<Api4> api4 = transactionService.getBranchSumAmt(branchName);
//        URI location = ServletUriComponentsBuilder.fromCurrentRequest();
//        return ResponseEntity.created(location).build();
    }
}
