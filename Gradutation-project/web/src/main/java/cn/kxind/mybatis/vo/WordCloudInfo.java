package cn.kxind.mybatis.vo;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/31.
 */
public class WordCloudInfo {
    public  String name;
    public  int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public WordCloudInfo(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public WordCloudInfo() {
    }
}
