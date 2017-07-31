package cn.kxind.mybatis.service.Impl;

import cn.kxind.mybatis.dao.EduInfoMapper;
import cn.kxind.mybatis.service.IPieService;
import cn.kxind.mybatis.vo.PieDataTitle;
import cn.kxind.mybatis.vo.PieJson;
import cn.kxind.mybatis.vo.WordCloudInfo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/4/2.
 */
@Service("pieService")
public class PieServiceImpl implements IPieService {

    @Autowired
    private EduInfoMapper eduInfoMapper;

    @Override
    public String getPieCountByYear() {
        List<WordCloudInfo> data=eduInfoMapper.getPieCountByYear();
        List<WordCloudInfo> data2=new ArrayList<>();
        Gson gson=new Gson();
        PieJson pie=new PieJson();
        List<String> datatitle=eduInfoMapper.getPieCountDataByYear();
        List<String> datatitle2=new ArrayList<>();
        String   TitleText="年度访问量及占比";

        List<WordCloudInfo> list2=new ArrayList<>();
        for (WordCloudInfo c:data
                ) {
            WordCloudInfo w=new WordCloudInfo();
            w.setName(c.getName()+"年");
            w.setValue(c.getValue());
            data2.add(w);
        }
        for (String s:datatitle){
            s=s+"年";
            datatitle2.add(s);
        }
        pie.setDatatitle(datatitle2);
        pie.setTitleText(TitleText);
        pie.setData(data2);
        return gson.toJson(pie);
    }

    @Override
    public String getVistorMonthByYear(int year) {
        List<WordCloudInfo> data=eduInfoMapper.getVistorMonthByYear(year);
        List<String>   datatile=eduInfoMapper.getVistorMonthDataByYear(year);
        PieJson pie=new PieJson();
        pie.setData(data);
        pie.setDatatitle(datatile);
        pie.setTitleText(year+"年各月访问量占比");
        Gson gson=new Gson();
        return  gson.toJson(pie);
    }

    @Override
    public String getPieCountByEditor() {
        List<WordCloudInfo> list=eduInfoMapper.getPieCountByEditor();
        List<WordCloudInfo> list2=new ArrayList<>();
        for (WordCloudInfo w:list
                ) {
            if(w.getName()!=null){
                list2.add(w);
            }
        }
        Gson gson=new Gson();
        return  gson.toJson(list2);
    }

    @Override
    public String getPieDataCountByEditor() {
        List<String> list=eduInfoMapper.getPieDataCountByEditor();
        List<String> list2=new ArrayList<>();
        Gson gson=new Gson();
        PieDataTitle pieDataTitle=new PieDataTitle();
        for (String s:list
                ) {
            if(s!=null){
                list2.add(s);
            }

        }
        pieDataTitle.setDatatitle(list2);
        pieDataTitle.setTitleText("编辑发稿数量分布及占比");
        return  gson.toJson(pieDataTitle);
    }

    @Override
    public String getPieCountByProofead() {
        List<WordCloudInfo> list=eduInfoMapper.getPieCountByProofead();
        List<WordCloudInfo> list2=new ArrayList<>();
        for (WordCloudInfo w:list
                ) {
            if(w.getName()!=null){
                list2.add(w);
            }else {
                w.setName("未校稿");
                list2.add(w);
            }
        }
        Gson gson=new Gson();
        return  gson.toJson(list2);
    }

    @Override
    public String getPieDataCountByProofead() {
        List<String> list=eduInfoMapper.getPieDataCountByProofead();
        List<String> list2=new ArrayList<>();
        Gson gson=new Gson();
        PieDataTitle pieDataTitle=new PieDataTitle();
        for (String s:list
                ) {
            if(s!=null){
                list2.add(s);
            }else{
                list2.add("未校稿");

            }

        }
        pieDataTitle.setDatatitle(list2);
        pieDataTitle.setTitleText("校稿人占比");
        return  gson.toJson(pieDataTitle);
    }
}
