package com.kpsec.test.service;

import com.kpsec.test.model.Api1;
import com.kpsec.test.model.Api2;
import com.kpsec.test.repository.TransactionHistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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


}
