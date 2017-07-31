package cn.kxind.mybatis.vo;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/29.
 */
public class CountInfo {
   private String infoYear;

   private String infoCount;

    public String getYear() {
        return infoYear;
    }

    public void setYear(String infoYear) {
        this.infoYear = infoYear;
    }

    public String getCount() {
        return infoCount;
    }

    public void setCount(String infoCount) {
        this.infoCount = infoCount;
    }

    public CountInfo(String infoYear, String infoCount) {
        this.infoYear = infoYear;
        this.infoCount = infoCount;
    }

    public CountInfo() {
    }
}
