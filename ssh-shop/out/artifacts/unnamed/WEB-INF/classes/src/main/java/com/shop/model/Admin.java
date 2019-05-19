package com.shop.model;

import lombok.Data;
import org.hibernate.annotations.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="adminuser")
@Entity  //此java类是实体类
@Data
public class Admin {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Integer id;
    private String username;
    private String password;
    private Integer minventory;
}
