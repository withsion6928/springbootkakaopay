package com.kpsec.test.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Date;
import java.util.List;

//devlop branch test
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "사용자 상세정보를 위한 도메인 객체")
@Entity
//@JsonIgnoreProperties(value = {"password"})
//@JsonFilter("UserInfo")
public class User {
    @Id
    @GeneratedValue
    private Integer id;

    @ApiModelProperty(notes = "사용자 이름을 입력해 주세요")
    private String name;
    @ApiModelProperty(notes = "등록일을 입력해 주세요")
    private Date joinDate;
    @ApiModelProperty(notes = "사용자 패스워드를 입력해 주세요")
    private String password;
    @ApiModelProperty(notes = "주민번호를 입력해 주세요")
    private String ssn;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    public User(int i, String name, Date joinDate, String password, String ssn) {
        this.id = id;
        this.name = name;
        this.joinDate = joinDate;
        this.password = password;
        this.ssn = ssn;
    }
}
