package com.kpsec.test.infra;

import com.kpsec.test.model.entity.Account;
import com.kpsec.test.model.entity.Branch;
import com.kpsec.test.model.entity.TransactionHist;
import com.kpsec.test.model.entity.TransactionPk;
import com.kpsec.test.repository.AccountRepository;
import com.kpsec.test.repository.BranchRepository;
import com.kpsec.test.repository.TransactionHistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InitData {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    BranchRepository branchRepository;

    @Autowired
    TransactionHistRepository transactionHistRepository;

    @PostConstruct
    private void initAccount() throws IOException {
        if (accountRepository.count() == 0) {
            Resource resource = new ClassPathResource("계좌정보.csv");
            List<Account> accountList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8)
                    .stream().skip(1).map(line -> {
                        String[] split = line.split(",");
                        return Account.builder().accountNo(split[0]).accountName(split[1]).branchCode(split[2])
                                .build();
                    }).collect(Collectors.toList());
            accountRepository.saveAll(accountList);
        }
    }

    @PostConstruct
    private void initBranch() throws IOException {
        if (branchRepository.count() == 0) {
            Resource resource = new ClassPathResource("관리점정보.csv");
            List<Branch> branchList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8)
                    .stream().skip(1).map(line -> {
                        String[] split = line.split(",");
                        return Branch.builder().branchCode(split[0]).branchName(split[1]).build();
                    }).collect(Collectors.toList());
            branchRepository.saveAll(branchList);
        }
    }

@PostConstruct
private void initTrasactionHist() throws IOException {
    if (transactionHistRepository.count() == 0) {
        Resource resource = new ClassPathResource("거래내역.csv");
        List<TransactionHist> transactionHistList = Files.readAllLines(resource.getFile().toPath(), StandardCharsets.UTF_8)
                .stream().skip(1).map(line -> {
                    String[] split = line.split(",");
                    TransactionPk transactionPk = new TransactionPk(split[0],split[1],split[2]);
                    return TransactionHist.builder().transactionPk(transactionPk)
                            .trAmt(Integer.parseInt(split[3]))
                            .fee(Integer.parseInt(split[4])).cancelYn(Boolean.parseBoolean(split[5]))
                            .build();
                }).collect(Collectors.toList());
        transactionHistRepository.saveAll(transactionHistList);
    }
}
}
