package cn.kxind.mybatis.vo;

import java.util.List;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/4/2.
 */
public class PieDataTitle {
    List<String>  datatitle;
    String       TitleText;

    public PieDataTitle() {
    }

    public PieDataTitle(List<String> datatitle, String titleText) {
        this.datatitle = datatitle;
        TitleText = titleText;
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
}
