package com.LokDQ.myspringboot.repository;

import com.LokDQ.myspringboot.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


//JpaRepository<table thao tac', kieu du lieu cua primarykey>
//toàn bộ xử lý được có sẵn trong JpaRepository
//thực thi các câu lệnh sql
@Repository
public interface NewRepository extends JpaRepository<NewsEntity,Long> {
     NewsEntity findNewsEntityByIdIs(Long id);

}
