package cn.kxind.mybatis.controller;

import cn.kxind.mybatis.service.ICoverageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/30.
 */
@RestController
@RequestMapping(value = "/coverage")
public class CoverageController {
    @Autowired
    private ICoverageService coverageService;

    /**
     * 图片覆盖率
     * @return
     */
    @PostMapping("/getImgCoverage")
    public String getImgCoverage(){
        return coverageService.getImgCoverage();
    }
    /**
     * 编辑覆盖率
     * @return
     */
    @PostMapping("/getEditorCoverage")
    public String getEditorCoverage(){
        return coverageService.getEditorCoverage();
    }
    /**
     * 校稿覆盖率
     * @return
     */
    @PostMapping("/getProofeadCoverage")
    public String getProofeadCoverage(){
        return coverageService.getProofeadCoverage();
    }

    /**
     * 审核覆盖率
     * @return
     */
    @PostMapping("/getReviewerCoverage")
    public String getReviewerCoverage(){
        return coverageService.getReviewerCoverage();
    }

}
