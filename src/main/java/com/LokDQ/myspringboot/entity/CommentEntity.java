package com.LokDQ.myspringboot.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="comment")
@Data
public class CommentEntity extends BaseEntity{
    @Column(name = "content")
    private String content;
}
