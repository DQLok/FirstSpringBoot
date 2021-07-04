package com.LokDQ.myspringboot.api.output;

import com.LokDQ.myspringboot.dto.NewDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//totalpage tong so trang
//page số trang
//List<NewDTO>
@Data
public class NewOutput {
    private int page;
    private int totalPage;
    private List<NewDTO> listResult=new ArrayList<>();
}
