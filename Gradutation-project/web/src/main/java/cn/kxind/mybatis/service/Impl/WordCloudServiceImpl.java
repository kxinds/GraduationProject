package cn.kxind.mybatis.service.Impl;

import cn.kxind.mybatis.dao.EduInfoMapper;
import cn.kxind.mybatis.service.IWordCloudService;
import cn.kxind.mybatis.vo.WordCloudInfo;
import com.google.gson.Gson;
import com.hankcs.hanlp.corpus.occurrence.Occurrence;
import com.hankcs.hanlp.corpus.occurrence.TermFrequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/31.
 */
@Service("wordCloudService")
public class WordCloudServiceImpl implements IWordCloudService {
    @Autowired
    private EduInfoMapper eduInfoMapper;

    @Override
    public String getWordCloud() {
        List<String> list = eduInfoMapper.getWordCount();
        Occurrence occurrence = new Occurrence();
        for (String s:list
                ) {
            occurrence.addAll(s);
        }
        occurrence.compute();
        Set<Map.Entry<String, TermFrequency>> uniGram = occurrence.getUniGram();
        List<WordCloudInfo> list1=new ArrayList<>();
        for (Map.Entry<String, TermFrequency> entry : uniGram)
        {
            TermFrequency termFrequency = entry.getValue();
            String name=termFrequency.toString().split("=")[0];
            Integer value=Integer.valueOf(termFrequency.toString().split("=")[1]);
            WordCloudInfo w=new WordCloudInfo();
            w.setName(name);
            w.setValue(value);
            list1.add(w);
        }
        TComparator TtComparator=new TComparator();
        Collections.sort(list1,TtComparator);
        Gson gson=new Gson() ;
        return gson.toJson(list1.subList(0,31));
    }



    class TComparator implements Comparator<WordCloudInfo>{
        public int compare(WordCloudInfo o1, WordCloudInfo o2) {
            Integer field1 =o1.getValue() ;//要比较的T得字段
            Integer field2 = o2.getValue();//要比较的字段
            //return field1 > field2 ? 1: -1;//根据字段比较结果返回1(>)或者-1(<)
            return field2.compareTo(field1);//倒序
        }
    }
}
