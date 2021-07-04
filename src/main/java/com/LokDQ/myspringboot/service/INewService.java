package com.LokDQ.myspringboot.service;

import com.LokDQ.myspringboot.dto.NewDTO;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

public interface INewService {
    NewDTO save(NewDTO newDTO);
//    NewDTO update(NewDTO newDTO);
    void delete(long[] ids);
    List<NewDTO> findAll(Pageable pageable);
    List<NewDTO> findAll();
    int totalItem();
}
