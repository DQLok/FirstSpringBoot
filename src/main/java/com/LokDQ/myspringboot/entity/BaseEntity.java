package com.LokDQ.myspringboot.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

//để các entity các kế thừa nhận dc thì cần phải @MappedSuperclass
// khi tạo table từ entity thì sẽ dc apply từ tk cha này
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)//
@Data
public class BaseEntity {
    //long = bigint tang trong sql.
    //@id là primary key và not null
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    // tự tăng giá trị ko có setter chỉ có getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //bắt buộc toàn bộ phải có @Column
    //default 2 từ đơn chữ cái thứ 2 ghi hoa genery thành 2 chữ thường có dấu gạch dưới vd created_by
    //name trong mysql giống java class @Column
    @Column (name = "createdBy")
    @CreatedBy
    private String createdBy;

    @Column(name = "createdDate")
    @CreatedDate
    private Date createdDate;

    @Column(name = "modifiedBy")
    @LastModifiedBy
    private String modifiedBy;

    @Column(name = "modifiedDate")
    @LastModifiedDate
    private Date modifiedDate;
}
