package cn.kxind.mybatis.service.Impl;

import cn.kxind.mybatis.dao.EduInfoMapper;
import cn.kxind.mybatis.service.IEduInfoService;
import cn.kxind.mybatis.vo.CountInfo;
import com.github.abel533.echarts.axis.CategoryAxis;
import com.github.abel533.echarts.axis.ValueAxis;
import com.github.abel533.echarts.code.*;
import com.github.abel533.echarts.feature.MagicType;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Bar;
import com.github.abel533.echarts.series.Line;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/27.
 */
@Service("EduInfoService")
public class EduInfoServiceImpl implements IEduInfoService {
    @Autowired
    private EduInfoMapper eduInfoMapper;

    /**
     * 通过年份获得柱状图
     *
     * @return
     */
    @Override
    public String getPillarCountByYear() {
        List<CountInfo> list = eduInfoMapper.getCountByYear();
        String[] year2 = new String[list.size()];
        String[] count = new String[list.size()];
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
        return option.toString();
    }

    /***
     * 通过年份获得线性图
     * @return
     */
    @Override
    public String getLineCountByYear() {
        List<CountInfo> list = eduInfoMapper.getCountByYear();
        String[] year2 = new String[list.size()];
        String[] count = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            year2[i] = list.get(i).getYear();
            count[i] = list.get(i).getCount();
        }
        GsonOption option = new GsonOption();
        option.legend("时间（年）与数量（篇）变化关系");
        option.toolbox().show(true).feature(Tool.mark, Tool.dataView, new MagicType(Magic.line, Magic.bar), Tool.restore, Tool.saveAsImage);
        option.calculable(true);
        option.tooltip().trigger(Trigger.axis).formatter("Temperature : <br/>{b}年 : {c}篇");
        ValueAxis valueAxis = new ValueAxis();
        valueAxis.axisLabel().formatter("{value} 篇");
        option.xAxis(valueAxis);
        CategoryAxis categoryAxis = new CategoryAxis();
        categoryAxis.axisLine().onZero(false);
        categoryAxis.axisLabel().formatter("{value} 年");
        categoryAxis.boundaryGap(false);
        categoryAxis.data(year2);
        option.yAxis(categoryAxis);
        Line line = new Line();
        line.smooth(true).name("时间（年）与数量（篇）变化关系").data(count).itemStyle().normal().lineStyle().shadowColor("rgba(0,0,0,0.4)");
        option.series(line);
        return option.toString();
    }



}
