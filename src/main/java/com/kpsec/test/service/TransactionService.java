package com.kpsec.test.service;

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
        return transactionHistRepository.getNoneTrAccount();
    }

    public List<Api3> getGroupByYearBr(){
        return  transactionHistRepository.getGroupByYearBr();
    }


    public List<Api4_> getBranchSumAmt(String branchName){
        System.out.println("Service API4:::"+transactionHistRepository.getBranchSumAmt(branchName).toString());
        return transactionHistRepository.getBranchSumAmt(branchName);
    }
}
