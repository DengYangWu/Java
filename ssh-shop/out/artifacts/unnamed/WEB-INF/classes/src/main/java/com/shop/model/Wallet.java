package com.shop.model;


import lombok.Data;

import javax.persistence.*;

//wallet:钱包
@Table(name="wallet")
@Entity
@Data
public class Wallet {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer wid;
    private  Float money;
    private Integer uid;

    //user:foreign key
    @OneToOne(optional = false)
    @JoinColumn(name = "uid", unique = true, nullable = false, updatable = false, insertable = false)
    private User user;

}
