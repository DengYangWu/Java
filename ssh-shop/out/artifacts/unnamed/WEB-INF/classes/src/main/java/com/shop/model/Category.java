package com.shop.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Table(name="category")
@Entity
@Data
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer cid;
    private String cname;
    private float discount;
    private Date privilegeTime;   //the preferential time

    //one category deposit second category map
    @OrderBy(value="csid")
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "category")
    private Set<CategorySecond> categorySeconds=new HashSet<CategorySecond>();
}
