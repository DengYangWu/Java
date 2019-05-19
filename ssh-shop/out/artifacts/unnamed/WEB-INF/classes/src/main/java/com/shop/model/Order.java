package com.shop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

//order table
@Table(name="orders")
@Entity
@Data
public class Order {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer oid;
    private Float total;
    private Date ordertime;
    private Integer state;  //1:non-payment,2:account paid,3:In order to delivery,4:End of the order
    private String name;
    private String phone;
    private String addr;
    //user's foreign key:entity
    @JoinColumn(name="uid")
    @ManyToOne
    private User user;
    //configuration order item map
    //cascade级联操作级别,refresh:级联刷新,remove级联删除
    @OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER, mappedBy = "order")
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();


}
