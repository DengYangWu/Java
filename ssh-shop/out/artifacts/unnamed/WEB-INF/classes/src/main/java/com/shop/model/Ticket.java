package com.shop.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//ticket:票
@Table(name = "ticket")
@Entity
@Data
public class Ticket {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer tid;
    private Float privilege;
    private Float consume;
    private Date useTime;

    //user:foreign key
    @OneToOne(optional=false)
    @JoinColumn(name = "cid", unique = true, nullable = false, updatable = false, insertable = false)
    private Category category;

}
