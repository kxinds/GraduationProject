package cn.kxind.mybatis.service.Impl;

import cn.kxind.mybatis.dao.EduInfoMapper;
import cn.kxind.mybatis.service.ICoverageService;
import com.github.abel533.echarts.code.Tool;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.data.Data;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.series.Gauge;
import com.github.abel533.echarts.series.gauge.Detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/30.
 */
@Service("coverageService")
public class CoverageServiceImpl implements ICoverageService {
    @Autowired
    private EduInfoMapper eduInfoMapper;

    @Override
    public String getImgCoverage() {
        double one = eduInfoMapper.getImgNumber();
        double all = eduInfoMapper.getAllNumber();
        int result = (int) (one / all * 100);
        GsonOption option = new GsonOption();
        option.title().text("文章图片覆盖率").subtext("湖南师范大学树达学院")
                .link("https://kxind.cn").x(X.center);
        option.tooltip().trigger(Trigger.item);
        option.calculable(true);
        option.tooltip().formatter("{a} <br/>{b} : {c}%");
        option.toolbox().show(true).feature(Tool.mark, Tool.restore, Tool.saveAsImage);
        option.series(new Gauge("图片覆盖率").detail(new Detail().formatter("{value}%")).data(new Data("图片覆盖率", result)));

        return option.toString();
    }

    @Override
    public String getEditorCoverage() {
        double one = eduInfoMapper.getEditorNumber();
        double all = eduInfoMapper.getAllNumber();
        int result = (int) (one / all * 100);
        GsonOption option = new GsonOption();
        option.title().text("编辑修改率").subtext("湖南师范大学树达学院")
                .link("https://kxind.cn").x(X.center);
        option.tooltip().trigger(Trigger.item);
        option.calculable(true);
        option.tooltip().formatter("{a} <br/>{b} : {c}%");
        option.toolbox().show(true).feature(Tool.mark, Tool.restore, Tool.saveAsImage);
        option.series(new Gauge("一次修改率").detail(new Detail().formatter("{value}%")).data(new Data("一次修改率", result)));
        return option.toString();
    }



    @Override
    public String getProofeadCoverage() {
        double one = eduInfoMapper.getProofreadNumber();
        double all = eduInfoMapper.getAllNumber();
        int result = (int) (one / all * 100);
        GsonOption option = new GsonOption();
        option.title().text("校稿修改率").subtext("湖南师范大学树达学院")
                .link("https://kxind.cn").x(X.center);
        option.tooltip().trigger(Trigger.item);
        option.calculable(true);
        option.tooltip().formatter("{a} <br/>{b} : {c}%");
        option.toolbox().show(true).feature(Tool.mark, Tool.restore, Tool.saveAsImage);
        option.series(new Gauge("二次修改率").detail(new Detail().formatter("{value}%")).data(new Data("二次修改率", result)));
        return option.toString();
    }

    @Override
    public String getReviewerCoverage() {
        double one = eduInfoMapper.getReviewerNumber();
        double all = eduInfoMapper.getAllNumber();
        int result = (int) (one / all * 100);
        GsonOption option = new GsonOption();
        option.title().text("审核修改率").subtext("湖南师范大学树达学院")
                .link("https://kxind.cn").x(X.center);
        option.tooltip().trigger(Trigger.item);
        option.calculable(true);
        option.tooltip().formatter("{a} <br/>{b} : {c}%");
        option.toolbox().show(true).feature(Tool.mark, Tool.restore, Tool.saveAsImage);
        option.series(new Gauge("三次修改率").detail(new Detail().formatter("{value}%")).data(new Data("三次修改率", result)));
        return option.toString();
    }
}
