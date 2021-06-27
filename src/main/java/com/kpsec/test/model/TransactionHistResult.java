package com.kpsec.test.model;


public interface TransactionHistResult {

    String  getTrDate();
    String getAccountNo();
    String getTrsn();
    long getTrAmt();
    long getFee();
    boolean getCancelYn();

}
