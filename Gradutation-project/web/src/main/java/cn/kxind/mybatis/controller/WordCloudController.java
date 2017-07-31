package cn.kxind.mybatis.controller;

import cn.kxind.mybatis.service.IWordCloudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/31.
 */
@RestController
@RequestMapping("/word")
public class WordCloudController {
   @Autowired
   private IWordCloudService wordCloudService;

    @PostMapping("/getWordCloud")
public String getWordCloud(){

        return wordCloudService.getWordCloud();
}
}
