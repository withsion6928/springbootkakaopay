package com.kpsec.test.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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


}
