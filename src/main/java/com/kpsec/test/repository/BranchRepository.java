package com.kpsec.test.repository;

import com.kpsec.test.model.AccountResult;
import com.kpsec.test.model.BranchResult;
import com.kpsec.test.model.entity.Account;
import com.kpsec.test.model.entity.Branch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BranchRepository extends JpaRepository<Branch, String> {

    @Query(value = "SELECT branch_code as branchCode, branch_name as branchName FROM branch WHERE branch_code = :branchCode", nativeQuery = true)
    List<BranchResult> getAccountByBranchCode(@Param("branchCode") String branchCode);

}
