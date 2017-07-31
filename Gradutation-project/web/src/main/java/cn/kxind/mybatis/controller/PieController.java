package cn.kxind.mybatis.controller;

import cn.kxind.mybatis.dao.EduInfoMapper;
import cn.kxind.mybatis.service.IPieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/31.
 */
@RestController
@RequestMapping("/pie")
public class PieController {

    @Autowired
    private EduInfoMapper eduInfoMapper;
    @Autowired
    private IPieService pieService;

    /**
     *  访问统计/每年-圆饼图
     * @return
     */
    @PostMapping("/getPieCountByYear")
    public String getPieCountByYear(){
        String s=pieService.getPieCountByYear();

        return s;
    }

    /**
     *  访问统计/每月-圆饼图
     * @return
     */
    @GetMapping("/getVistorMonthByYear/{year}")
    public String getVistorMonthByYear(@PathVariable int year){
        String s=pieService.getVistorMonthByYear(year);
        return s;
    }

    /**
     *  编辑统计-圆饼图
     * @return
     */
    @PostMapping("/getPieCountByEditor")
    public String getPieCountByEditor(){
        return pieService.getPieCountByEditor();
    }

    /**
     *  编辑统计-圆饼图   title 及data
     * @return
     */
    @PostMapping("/getPieDataCountByEditor")
    public String getPieDataCountByEditor(){
        return pieService.getPieDataCountByEditor();
    }

    /**
     *  编辑统计-圆饼图
     * @return
     */
    @PostMapping("/getPieCountByProofead")
    public String getPieCountByProofead(){
        return pieService.getPieCountByProofead();
    }

    /**
     *  编辑统计-圆饼图   title 及data
     * @return
     */
    @PostMapping("/getPieDataCountByProofead")
    public String getPieDataCountByProofead(){
        return pieService.getPieDataCountByProofead();
    }

}
