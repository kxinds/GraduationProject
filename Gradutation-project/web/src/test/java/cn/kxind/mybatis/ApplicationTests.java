package cn.kxind.mybatis;

import cn.kxind.mybatis.dao.EduInfoMapper;
import cn.kxind.mybatis.dao.UserMapper;
import cn.kxind.mybatis.service.IEduInfoService;
import cn.kxind.mybatis.vo.CountInfo;
import cn.kxind.mybatis.vo.WordCloudInfo;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import com.hankcs.hanlp.corpus.occurrence.Occurrence;
import com.hankcs.hanlp.corpus.occurrence.TermFrequency;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

/**
 * Created by kxinds on 2017/3/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private IEduInfoService eduInfoService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private EduInfoMapper eduInfoMapper;

    @Test
    public void testCountByYear() {
        List<CountInfo> list = eduInfoMapper.getCountByYear();
        String[] year2 = new String[list.size()];
        String[] count=new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            year2[i] = list.get(i).getYear();
            count[i] = list.get(i).getCount();
        }

        GsonOption option = new GsonOption();
        option.title().text("文章统计").subtext("湖南师范大学树达学院")
                .link("https://kxind.cn").x(X.center);
        option.tooltip().trigger(Trigger.item);
        option.calculable(true);
        option.grid().borderWidth(0).y(80).y2(60);
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar).show(true), Tool.restore, Tool.saveAsImage);
        option.xAxis(new CategoryAxis().data(year2));
        option.yAxis(new ValueAxis().show(false));

        Bar bar = new Bar("文章统计");
        bar.itemStyle().normal().color("function(params) {" +
                "                        var colorList = [" +
                "                          '#C1232B','#B5C334','#FCCE10','#E87C25','#27727B'," +
                "                           '#FE8463','#9BCA63','#FAD860','#F3A43B','#60C0DD'," +
                "                           '#D7504B','#C6E579','#F4E001','#F0805A','#26C0C0','#26C0C0'" +
                "                        ];" +
                "                        return colorList[params.dataIndex]" +
                "                    }")
                .label().show(true).position(Position.top).formatter("{b}\n{c}");
        bar.data(count);
        option.series(bar);



        GsonOption option2 = new GsonOption();


        option2.legend("年份与文章数变化关系");

        option2.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar), Tool.restore, Tool.saveAsImage);

        option2.calculable(true);
        option2.tooltip().trigger(Trigger.axis).formatter("Temperature : <br/>{b}年 : {c}文章数");

        ValueAxis valueAxis = new ValueAxis();
        valueAxis.axisLabel().formatter("{value} 文章数");
        option2.xAxis(valueAxis);

        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.axisLine().onZero(false);
        categoryAxis.axisLabel().formatter("{value} 年");
        categoryAxis.boundaryGap(false);
        categoryAxis.data(year2);
        option2.yAxis(categoryAxis);

        Line line = new Line();
        line.smooth(true).name("年份与文章数变化关系").data(count).itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
        option2.series(line);

       System.out.println(option2);
    }
    @Test
    public void testImg(){
        double ab=eduInfoMapper.getImgNumber();
        double c=eduInfoMapper.getAllNumber();

        System.out.println((int)(ab/c*100));
        //System.out.println(ab/c*100);
    }

    @Test
    public void test3() {
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
        for (int i =list1.size()-1; i >list1.size()-21 ; i--) {
            System.out.println(list1.get(i).getName()+"---"+list1.get(i).getValue());
        }
    }

    @Test
    public void testWord() {
        System.out.println(userMapper.selectFunctionById(1).get(0).getName());

    }


        class TComparator implements Comparator<WordCloudInfo>{
    public int compare(WordCloudInfo o1, WordCloudInfo o2) {
        Integer field1 =o1.getValue() ;//要比较的T得字段
        Integer field2 = o2.getValue();//要比较的字段
        //return field1 > field2 ? 1: -1;//根据字段比较结果返回1(>)或者-1(<)
        return field1.compareTo(field2);
    }
}}

