package cn.kxind.mybatis.service;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/4/2.
 */
public interface IPieService {
    /**
     * 访问数量/每年-圆饼图
     * @return
     */
    public String getPieCountByYear();

    /**
     * 访问数量/每月-圆饼图
     * @return
     */
    public String getVistorMonthByYear(int year);


    /**
     * 编辑校稿统计/编辑-圆饼图
     * @return
     */
    public String getPieCountByEditor();
    /**
     * 编辑校稿统计/编辑-圆饼图  其他数据
     * @return
     */
    public String getPieDataCountByEditor();

    /**
     * 编辑校稿统计/校稿-圆饼图
     * @return
     */
    public String getPieCountByProofead();

    /**
     *通编辑校稿统计/校稿-圆饼图 其他数据
     * @return
     */
    public String getPieDataCountByProofead();


}
