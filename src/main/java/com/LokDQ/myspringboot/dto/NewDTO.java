package com.LokDQ.myspringboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class NewDTO extends AbstractDTO<NewDTO> {
    private String title;
    private String content;
    private String shortDescription;
    private String categoryCode;
    private String thumbnail;


}
