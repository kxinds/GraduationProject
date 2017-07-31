package cn.kxind.mybatis.service;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/31.
 */
public interface IWordCloudService {
    /**
     * 分析所有文章 出现的前20个热词
     * @return
     */
    public String getWordCloud();
}
