package com.kpsec.test.controller;

import com.kpsec.test.model.AccountResult;
import com.kpsec.test.model.Api1;
import com.kpsec.test.model.Api2;
import com.kpsec.test.model.TransactionHistResult;
import com.kpsec.test.service.AccountService;
import com.kpsec.test.service.TransactionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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


    @GetMapping(value = "/none_tr_account")
    public List<Api2> getNoneTrAccount() {

        return transactionService.getNoneTrAccount();
    }
}
