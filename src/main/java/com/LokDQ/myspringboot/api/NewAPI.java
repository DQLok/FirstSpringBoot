package com.LokDQ.myspringboot.api;

import com.LokDQ.myspringboot.api.output.NewOutput;
import com.LokDQ.myspringboot.dto.NewDTO;
import com.LokDQ.myspringboot.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;



//@CrossOrigin báo với api bik về config security spring
@CrossOrigin
// định nghĩa controller và cả responsebody
@RestController
public class NewAPI {

    @Autowired
    private INewService newService;

    //phan trang va ko phan trang cach 1
    //required = false khong phan trang thi co' the co or ko 2 param tren
    @GetMapping(value = "/new")
    public NewOutput showNew(@RequestParam(value = "page",required = false) Integer page,
                             @RequestParam(value = "limit",required = false) Integer limit){
        NewOutput result=new NewOutput();
        if (page!=null && limit!=null){
            result.setPage(page);
            //offset bắt đầu từ 0 => offset=page-1
            Pageable pageable=PageRequest.of(page-1,limit);
            result.setListResult(newService.findAll(pageable));
            result.setTotalPage((int) Math.ceil((double) (newService.totalItem())/ limit));
        }else {
            result.setListResult(newService.findAll());
        }
        return result;
    }
    // phan trang va khong phan trang cach 2
    //defaultValue chi dung cho chuoi String
//    @GetMapping(value = "/new")
//    public NewOutput showNew2(@RequestParam(value = "page", defaultValue = "NONE") String pageStr,
//                             @RequestParam(value = "limit",defaultValue = "NONE") String limitStr){
//        NewOutput result=new NewOutput();
//        if (!pageStr.equals("NONE") && !limitStr.equals("NONE")){
//            int page=Integer.parseInt(pageStr);
//            int limit=Integer.parseInt(limitStr);
//            result.setPage(page);
//            //offset bắt đầu từ 0 => offset=page-1
//            Pageable pageable=PageRequest.of(page-1,limit);
//            result.setListResult(newService.findAll(pageable));
//            result.setTotalPage((int) Math.ceil((double) (newService.totalItem())/ limit));
//        }else {
//            result.setListResult(newService.findAll());
//        }
//        return result;
//    }

    @PostMapping(value = "/new")
    public NewDTO createNew(@RequestBody NewDTO model){
        return newService.save(model);
    }

//    @GetMapping("/new")
//    public ResponseEntity<String> testSpringBoot() {
//        return ResponseEntity.ok("Success");
//    }
    
    //@PathVariable dua id vao url
    @PutMapping(value = "/new/{id}")
    public NewDTO updateNew(@RequestBody NewDTO model,@PathVariable("id") Long id) {
        model.setId(id);
        return newService.save(model);
    }

    @DeleteMapping(value = "/new")
    public void deleteNew(@RequestBody long[] ids) {
        newService.delete(ids);
    }
}

//-------------------------------------------
//CÔNG NGHỆ CŨ
/*//trở thành API
@Controller
public class NewAPI {

	 ĐÂY LÀ NHỮNG ĐỐI TƯỢNG CŨ
	//requestmapping để nhận request url (danh từ)
	//phải xác nhận method cần xài put(update) post(thêm) get(hiển thị) delete(xóa)
	@RequestMapping(value = "/new", method = RequestMethod.POST)

	//@requestbody nhận request json map vs key là field của new DTO để nhận value từ client => model có data
	//trả về client @responbody convert tất cả thành json trả về client
	@ResponseBody
	 public NewDTO createNew(@RequestBody NewDTO model) {
		return model;
	}

}*/