package com.LokDQ.myspringboot.service.impl;

import com.LokDQ.myspringboot.convert.NewConverter;
import com.LokDQ.myspringboot.dto.NewDTO;
import com.LokDQ.myspringboot.entity.CategoryEntity;
import com.LokDQ.myspringboot.entity.NewsEntity;
import com.LokDQ.myspringboot.repository.CategoryRepository;
import com.LokDQ.myspringboot.repository.NewRepository;
import com.LokDQ.myspringboot.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


// nếu class implement interface thì cần @Reponsitory đầu class
@Service
public class NewService implements INewService {
    // muốn sử dụng reponsitory thì phải Autowired
    //cơ chế dependency injection @Autowired
    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;

    @Override
    public NewDTO save(NewDTO newDTO) {
        NewsEntity newEntity=new NewsEntity();
        if (newDTO.getId()!=null){
            NewsEntity oldNewsEntity = newRepository.findNewsEntityByIdIs(newDTO.getId());
            newEntity=newConverter.toEntity(newDTO,oldNewsEntity);
        } else{
            newEntity=newConverter.toEntity(newDTO);
        }
        // từ catory code thành catoryentity
        CategoryEntity categoryEntity=categoryRepository.findOneByCode(newDTO.getCategoryCode());
        newEntity.setCategory(categoryEntity);
        newEntity=newRepository.save(newEntity);
        return newConverter.toDTO(newEntity);
    }

    @Override
    public void delete(long[] ids) {
        for(long item:ids){
            newRepository.deleteById(item);
        }
    }

    //phan trang
    @Override
    public List<NewDTO> findAll(Pageable pageable) {
        List<NewDTO> results=new ArrayList<>();
        List<NewsEntity> entities=newRepository.findAll(pageable).getContent();
        for (NewsEntity item:entities){
            NewDTO newDTO=newConverter.toDTO(item);
            results.add(newDTO);
        }
        return results;
    }

    @Override
    public List<NewDTO> findAll() {
        List<NewDTO> results=new ArrayList<>();
        List<NewsEntity> entities=newRepository.findAll();
        for (NewsEntity item:entities){
            NewDTO newDTO=newConverter.toDTO(item);
            results.add(newDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int)newRepository.count();
    }

    // hàm này được tích hợp với hàm save
//    @Override
//    public NewDTO update(NewDTO newDTO) {
//        NewsEntity oldNew=newRepository.findOne(newDTO.getId());
//        NewsEntity newEntity=newConverter.toEntity(newDTO,oldNew);
//        CategoryEntity categoryEntity=categoryRepository.findOneByCode(newDTO.getCategoryCode());
//        newEntity=newRepository.save(newEntity);
//        return newConverter.toDTO(newEntity);
//    }
}
