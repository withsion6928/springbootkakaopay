package com.kpsec.test.service;

import com.kpsec.test.exception.UserNotFoundException;
import com.kpsec.test.model.*;
import com.kpsec.test.repository.TransactionHistRepository;
import org.hibernate.mapping.Array;
import org.hibernate.mapping.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class TransactionService {

    @Autowired
    private TransactionHistRepository transactionHistRepository;

    public List<Api1> getGroupByYearAccNo(){
        List<Api1> api1= transactionHistRepository.getGroupByYearAccNo();
        if(api1 == null || api1.size() == 0 ){
            throw new UserNotFoundException(String.format("account no not found error", ""));
        }

        List<Api1> resultList = new ArrayList<>();
        String prev = "0000";
        int idx =0 ;
        for(Api1 ap1 : api1){
           idx++;
           if(idx == 1) {
               resultList.add(ap1);
           }
           else if (!prev.equals(ap1.getYear())) {
               resultList.add(ap1);
               break;
           }
           prev = ap1.getYear();
        }

        return resultList;
    }

    public List<Api2> getNoneTrAccount(){
        List<Api2> api2 = transactionHistRepository.getNoneTrAccount();
        if(api2 == null || api2.size() == 0 ){
            throw new UserNotFoundException(String.format("account not found error", ""));
        }

        return transactionHistRepository.getNoneTrAccount();
    }

    public List<Api3> getGroupByYearBr(){
        List<Api3> api3 = transactionHistRepository.getGroupByYearBr();
        if(api3 == null || api3.size() == 0 ){
            throw new UserNotFoundException(String.format("br code not found error", ""));
        }

        return  api3;
    }


    public List<Api4> getBranchSumAmt(String branchName){
        List<Api4> api4 = transactionHistRepository.getBranchSumAmt(branchName);
        List<String> closeBranchList = new ArrayList<>();
        closeBranchList.add("분당점");


        if(api4 == null || api4.size() == 0 || closeBranchList.contains(api4.get(0).getBrName())){
            throw new UserNotFoundException(String.format("br code not found error", ""));
        }
        return api4;
    }
}
