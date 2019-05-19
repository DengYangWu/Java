package com.shop.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


//The Second Category entity
@Table(name="categorysecond")
@Entity
@Data
public class CategorySecond implements Serializable {
    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer csid;
    private String csname;

    //The one category,foreign key entity
    @JoinColumn(name="cid")
    @ManyToOne
    private Category category;

    //configuration commodity map
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "categorySecond")
    private Set<Product> products=new HashSet<Product>();
}
