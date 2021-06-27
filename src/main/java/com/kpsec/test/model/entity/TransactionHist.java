package com.kpsec.test.model.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(TransactionHist.TransactionHistPk.class)
public class TransactionHist implements Serializable {
//    거래일자,계좌번호,거래번호,금액,수수료,취소여부

    @Id
    private String trDate;

    @Id
    private String accountNo;

    @Id
    private String trSn;

    private int trAmt;//거래금액
    private int fee;//계좌번호
    private boolean cancelYn;//취소여부

    @EqualsAndHashCode
    @Embeddable
    static class TransactionHistPk implements Serializable {

        @Column(columnDefinition = "varchar(8)")
        private String trDate;

        @Column(name = "ACCOUNT_NO", nullable = false)
        private String accountNo;

        @Column(columnDefinition = "varchar(10)")
        private String trSn;


    }
}
