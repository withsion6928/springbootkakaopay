package com.kpsec.test.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Branch {
    @Id
    private String branchCode;//관리점코드


    private String branchName;//관리점명


}
