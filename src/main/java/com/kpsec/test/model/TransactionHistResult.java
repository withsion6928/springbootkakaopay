package com.kpsec.test.model;

import com.kpsec.test.model.entity.TransactionPk;

import javax.persistence.Id;

public interface TransactionHistResult {

    TransactionPk getTransactionPk();
    int getTrAmt();
    int getFee();
    boolean getCancelYn();

}
