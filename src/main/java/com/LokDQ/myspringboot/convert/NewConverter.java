package com.LokDQ.myspringboot.convert;

import com.LokDQ.myspringboot.dto.NewDTO;
import com.LokDQ.myspringboot.entity.NewsEntity;
import org.springframework.stereotype.Component;


//muốn nhúng vào service (DI)
//@Component ngang hàng vs @Service hay @Compository ,....
@Component
public class NewConverter {
    //convert DTO sang entity
    public NewsEntity toEntity(NewDTO dto){
        NewsEntity entity=new NewsEntity();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setShortDescription(dto.getShortDescription());
        entity.setThumbnail(dto.getThumbnail());
        return entity;
    }

    public NewDTO toDTO(NewsEntity entity){
        NewDTO dto=new NewDTO();
        if (entity.getId()!=null){
            dto.setId(entity.getId());
        }
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setShortDescription(entity.getShortDescription());
        dto.setThumbnail(entity.getThumbnail());
        dto.setCreatedDate(entity.getCreatedDate());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setModifiedDate(entity.getModifiedDate());
        dto.setModifiedBy(entity.getModifiedBy());
        return dto;
    }

    public NewsEntity toEntity(NewDTO dto,NewsEntity entity){
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setShortDescription(dto.getShortDescription());
        entity.setThumbnail(dto.getThumbnail());
        return entity;
    }

}
