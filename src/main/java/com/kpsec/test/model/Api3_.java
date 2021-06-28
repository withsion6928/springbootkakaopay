package com.kpsec.test.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Api3_ {
    @Id
    private String year;


    @OneToMany(mappedBy = "year")
    private List<Api3_sub_> Api3_sub_;



}
