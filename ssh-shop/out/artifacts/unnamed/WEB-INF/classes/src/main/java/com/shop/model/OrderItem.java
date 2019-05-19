package com.shop.model;

import lombok.Data;

import javax.persistence.*;

//order item entity
@Table(name="orderitem")
@Entity
@Data
public class OrderItem {
    @GeneratedValue(strategy = GenerationType.AUTO)  //generated:自增长  GenerationType.AUTO：默认
    @Id
    private Integer itemid;
    private Integer count;
    private Float subtotal;
    //commodity foreign key:entity
    @JoinColumn(name="pid")
    @ManyToOne
    private Product product;

    //order foreign key:entity
    @JoinColumn(name="oid")
    @ManyToOne(cascade = {CascadeType.ALL})
    private Order order;
}
