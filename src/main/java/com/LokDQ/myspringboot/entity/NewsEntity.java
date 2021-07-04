package com.LokDQ.myspringboot.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "new")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsEntity extends BaseEntity{
    @Column(name = "title")
    private String title;
    @Column(name = "thumbnail")
    private String thumbnail;
    @Column(name = "shortdescription")
    private String shortDescription;
    @Column(name = "content")
    private String content;

    //joincolumn hien khoa ngoai ten la gi
    @ManyToOne
    @JoinColumn(name="category_id")
    private CategoryEntity category;
}
