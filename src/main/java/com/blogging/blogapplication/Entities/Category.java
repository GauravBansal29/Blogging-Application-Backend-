package com.blogging.blogapplication.Entities;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

// this entity will tell the type of blog and we will make several blog pages in accordance with it
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "category_desc")
    private String desc;

    @OneToMany(mappedBy = "category" , cascade=CascadeType.ALL , fetch= FetchType.LAZY)
    private List<Post> posts;

}
