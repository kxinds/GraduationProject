package cn.kxind.mybatis.controller;

import cn.kxind.mybatis.service.IEduInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/27.
 */
@RestController
@RequestMapping("/info")
public class EduInfoController {
    @Autowired
    private IEduInfoService eduInfoService;

    /**
     * 文章统计
     * @return
     */
    @PostMapping("/getPillarCountByYear")
    public String getPillarCountByYear(){
        return eduInfoService.getPillarCountByYear();

    }

    /**
     * 文章走势
     * @return
     */
    @PostMapping("/getLineCountByYear")
    public String getLineCountByYear(){
        return eduInfoService.getLineCountByYear();
    }


}
