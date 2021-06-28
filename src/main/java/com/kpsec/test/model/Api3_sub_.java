package com.kpsec.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Api3_sub_ {
    @Id
    @JsonIgnore
    private String year;

    private String brName;
    private String brCode;
    private Long sumAmt;



    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Api3_ api3_;
}
