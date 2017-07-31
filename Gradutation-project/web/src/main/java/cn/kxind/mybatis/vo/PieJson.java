package cn.kxind.mybatis.vo;

import java.util.List;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/4/2.
 */
public class PieJson {
    List<String> datatitle;
    String       TitleText;
    List<WordCloudInfo> data;

    public List<WordCloudInfo> getData() {
        return data;
    }

    public void setData(List<WordCloudInfo> data) {
        this.data = data;
    }

    public List<String> getDatatitle() {
        return datatitle;
    }

    public void setDatatitle(List<String> datatitle) {
        this.datatitle = datatitle;
    }

    public String getTitleText() {
        return TitleText;
    }

    public void setTitleText(String titleText) {
        TitleText = titleText;
    }

    public PieJson() {
    }

    public PieJson(List<String> datatitle, String titleText, List<WordCloudInfo> data) {
        this.datatitle = datatitle;
        TitleText = titleText;
        this.data = data;
    }
}
