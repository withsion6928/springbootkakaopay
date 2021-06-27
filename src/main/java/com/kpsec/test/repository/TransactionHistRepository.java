package com.kpsec.test.repository;

import com.kpsec.test.model.Api1;
import com.kpsec.test.model.Api2;
import com.kpsec.test.model.entity.TransactionHist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TransactionHistRepository extends JpaRepository<TransactionHist, String> {

    @Query(value = "SELECT SUBSTR(tr_Date,0,4) as year, (select distinct account_name from account where account_no = A.account_no)as accountName,account_no as accountNo, Max(tr_Amt - fee) as sumAmt FROM transaction_Hist A WHERE  SUBSTR(tr_Date,0,4) = '2018' and CANCEL_YN  = 'N' Group by SUBSTR(tr_Date,0,4), account_no \n" +
            "UNION SELECT SUBSTR(tr_Date,0,4) as year, (select distinct account_name from account where account_no = A.account_no)as accountName, account_no as accountNo, Max(tr_Amt - fee) as sumAmt FROM transaction_Hist A WHERE  SUBSTR(tr_Date,0,4) = '2019' and CANCEL_YN  = 'N'  Group by SUBSTR(tr_Date,0,4), account_no ORDER BY 4 DESC", nativeQuery = true)
    List<Api1> getGroupByYearAccNo();


    @Query(value = "SELECT '2018' as year,  account_name AS  accountName,account_no as accountNo FROM account A WHERE NOT EXISTS  (SELECT ACCOUNT_NO FROM TRANSACTION_HIST WHERE SUBSTR(tr_Date,0,4) = '2018' and CANCEL_YN  = 'N' AND ACCOUNT_NO = A.ACCOUNT_NO )\n" +
            "UNION SELECT '2019' as year,  account_name AS  accountName,account_no as accountNo FROM account A WHERE  NOT EXISTS  (SELECT ACCOUNT_NO FROM TRANSACTION_HIST WHERE SUBSTR(tr_Date,0,4) = '2019' and CANCEL_YN  = 'N' AND ACCOUNT_NO = A.ACCOUNT_NO ) ORDER BY 1", nativeQuery = true)
    List<Api2> getNoneTrAccount();
}


