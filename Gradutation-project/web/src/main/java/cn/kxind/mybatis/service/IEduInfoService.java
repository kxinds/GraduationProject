package cn.kxind.mybatis.service;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/27.
 */
public interface IEduInfoService {
    /**
     * 统计每年文章数量，并返回柱状图
     * @return
     */
    public String getPillarCountByYear();

    /**
     * 统计每年文章数量，并返回折线关系
     * @return
     */
    public String getLineCountByYear();





}
