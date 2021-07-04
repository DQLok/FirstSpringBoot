package com.LokDQ.myspringboot.repository;

import com.LokDQ.myspringboot.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    //find muốn lấy
    //one single
    //findby lấy list
    //lay trong sql
    CategoryEntity findOneByCode(String code);
}
