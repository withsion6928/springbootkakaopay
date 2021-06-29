package com.kpsec.test.model;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Api4_ {


    private String BrName;
    @Id
    private String BrCode;
    private String SumAmt;
}
