package com.kpsec.test.repository;

import com.kpsec.test.model.BranchResult;
import com.kpsec.test.model.entity.Branch;
import com.kpsec.test.model.entity.TransactionHist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.Id;
import java.util.List;

public interface TransactionHistRepository extends JpaRepository<TransactionHist, String> {

//    @Query(value = "SELECT branch_code as branchCode, branch_name as branchName FROM TransactionHist WHERE branch_code = :branchCode", nativeQuery = true)
//    List<BranchResult> getAccountByBranchCode(@Param("branchCode") String branchCode);

}


