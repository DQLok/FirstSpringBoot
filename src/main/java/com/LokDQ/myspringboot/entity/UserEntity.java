package com.LokDQ.myspringboot.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


// entity se generay ra table
@Entity
//mapping vs DB
@Table(name = "user")
@Data
public class UserEntity extends BaseEntity{
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;
    @Column(name = "fullname")
    private String fullname;
    @Column(name = "status")
    private String status;

    @ManyToMany
    // name table trung gian
    @JoinTable(name = "user_role",
            //dang o user nen joincolum la user
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleEntity> roles = new ArrayList<>();
}
