package com.kpsec.test.model.entity;

import com.kpsec.test.user.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account {

    @Id
    private String accountNo;

    private String accountName;
    private String branchCode;

    @OneToMany(mappedBy = "transactionPk",fetch=FetchType.LAZY)
    private List<TransactionHist> transactionHists;

}
