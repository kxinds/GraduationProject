package cn.kxind.mybatis.controller;

import cn.kxind.mybatis.service.IDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/30.
 */
@RestController
@RequestMapping("/data")
public class DataController {
    @Autowired
    private IDataService dataService;

    @GetMapping("/list")
    public String findBookList(Integer pageSize, Integer pageNumber, HttpServletRequest request,
                               HttpServletResponse response){

        return dataService.getAllEduInfo(pageNumber, pageSize);
    }
    @PostMapping("/deleteDataById/{id}")
    public int deleteDataById(@PathVariable Integer id){

        return dataService.deleteByPrimaryKey(id);
    };

}
