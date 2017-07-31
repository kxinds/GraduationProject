package cn.kxind.mybatis.vo;

import java.util.List;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/4/1.
 */
public class PieInfo {

    private  WordCloudInfo wordCloudInfo;

    private List<String> dataCount;

    public WordCloudInfo getCountInfo() {
        return wordCloudInfo;
    }

    public void setCountInfo(WordCloudInfo wordCloudInfo) {
        this.wordCloudInfo = wordCloudInfo;
    }

    public List<String> getList() {
        return dataCount;
    }

    public void setList(List<String> dataCount) {
        this.dataCount = dataCount;
    }

    public PieInfo(WordCloudInfo wordCloudInfo, List<String> dataCount) {
        this.wordCloudInfo = wordCloudInfo;
        this.dataCount = dataCount;
    }

    public PieInfo() {
    }
}
