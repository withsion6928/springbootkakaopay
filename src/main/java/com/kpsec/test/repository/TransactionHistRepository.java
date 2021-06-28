package com.kpsec.test.repository;

import com.kpsec.test.model.*;
import com.kpsec.test.model.entity.TransactionHist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionHistRepository extends JpaRepository<TransactionHist, String> {

    @Query(value = "SELECT SUBSTR(tr_Date,0,4) as year, (select distinct account_name from account where account_no = A.account_no)as accountName,account_no as accountNo, SUM(tr_Amt - fee) as sumAmt FROM transaction_Hist A WHERE  SUBSTR(tr_Date,0,4) = '2018' and CANCEL_YN  = 'N' Group by SUBSTR(tr_Date,0,4), account_no \n" +
            "UNION SELECT SUBSTR(tr_Date,0,4) as year, (select distinct account_name from account where account_no = A.account_no)as accountName, account_no as accountNo, SUM(tr_Amt - fee) as sumAmt FROM transaction_Hist A WHERE  SUBSTR(tr_Date,0,4) = '2019' and CANCEL_YN  = 'N'  Group by SUBSTR(tr_Date,0,4), account_no ORDER BY 4 DESC", nativeQuery = true)
    List<Api1> getGroupByYearAccNo();


    @Query(value = "SELECT '2018' as year,  account_name AS  accountName,account_no as accountNo FROM account A WHERE NOT EXISTS  (SELECT ACCOUNT_NO FROM TRANSACTION_HIST WHERE SUBSTR(tr_Date,0,4) = '2018' and CANCEL_YN  = 'N' AND ACCOUNT_NO = A.ACCOUNT_NO )\n" +
            "UNION SELECT '2019' as year,  account_name AS  accountName,account_no as accountNo FROM account A WHERE  NOT EXISTS  (SELECT ACCOUNT_NO FROM TRANSACTION_HIST WHERE SUBSTR(tr_Date,0,4) = '2019' and CANCEL_YN  = 'N' AND ACCOUNT_NO = A.ACCOUNT_NO ) ORDER BY 1", nativeQuery = true)
    List<Api2> getNoneTrAccount();


    @Query(value = " SELECT  SUBSTR(tr_Date,0,4) as year ,  BRANCH_NAME AS brName,C.BRANCH_CODE AS brCode, SUM(tr_Amt - fee) as sumAmt \n" +
            "             FROM TRANSACTION_HIST\n" +
            "            A LEFT JOIN ACCOUNT B ON A.ACCOUNT_NO = B.ACCOUNT_NO \n" +
            "            LEFT JOIN  BRANCH C ON B.BRANCH_CODE = C.BRANCH_CODE\n" +
            "            WHERE CANCEL_YN <> 'Y'\n" +
            "           GROUP BY SUBSTR(tr_Date,0,4) , BRANCH_NAME\n" +
            "            ORDER BY year, SUMAMT DESC", nativeQuery = true)
    List<Api3> getGroupByYearBr();


    @Query(value = "SELECT b.branch_name as brName, B.branch_code as brCode, SUM(tr_Amt - fee) as sumAmt \n" +
            "FROM account a \n" +
            "JOIN BRANCH B ON A.BRANCH_CODE = B.BRANCH_CODE \n" +
            "JOIN TRANSACTION_HIST C \n" +
            "ON A.ACCOUNT_NO = C.ACCOUNT_NO \n" +
            "WHERE B.branch_name =  :branchName " +
            "AND ROWNUM = 1 \n" +
            "GROUP BY  B.BRANCH_CODE", nativeQuery = true)
    List<Api4> getBranchSumAmt(@Param("branchName") String branchName);

}


