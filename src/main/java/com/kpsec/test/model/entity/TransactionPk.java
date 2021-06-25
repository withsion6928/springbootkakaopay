package com.kpsec.test.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.io.Serializable;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionPk implements Serializable {
    private String trDate;
    @ManyToOne(fetch = FetchType.LAZY)
    private String accountNo;
    private String    trSn;
}
