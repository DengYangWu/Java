package com.shop.model;


import lombok.Data;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

//User entity
@Table(name="user")
@Entity
@Data
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer uid;
    private String username;
    private String password;
    private String name;
    @Email(message = "邮箱格式错误")
    private String email;
    private String phone;
    private Integer age;
    private String addr;
    private Integer state;
    private String code;
    //wallet:foreign key
    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER, mappedBy = "user")
    private Wallet wallet;
}
