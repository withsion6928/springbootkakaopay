package com.kpsec.test.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TransactionHist implements Serializable {
//    거래일자,계좌번호,거래번호,금액,수수료,취소여부

    @Id
    private TransactionPk transactionPk;

    private int trAmt;//거래금액
    private int fee;//계좌번호
    private boolean cancelYn;//취소여부


}
