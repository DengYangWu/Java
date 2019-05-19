package com.shop.model;


import lombok.Data;

import javax.persistence.*;

//user packet:用户卡包
@Table(name="packet")
@Entity
@Data
public class Packet {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer pacid;
    private Integer uid;

    //foreign key
    @OneToOne
    @JoinColumn(name = "uid", unique = true, nullable = false, updatable = false, insertable = false)
    private User user;

}
