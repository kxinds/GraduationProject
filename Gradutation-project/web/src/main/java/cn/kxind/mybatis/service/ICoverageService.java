package cn.kxind.mybatis.service;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/30.
 */
public interface ICoverageService {
    /**
     * 图片覆盖率
     * @return
     */
    public String getImgCoverage();

    /**
     * 编辑修改率
     * @return
     */
    public String getEditorCoverage();

    /**
     * 校稿修改率
     * @return
     */
    public String getProofeadCoverage();

    /**
     * 审核修改率
     * @return
     */
    public String getReviewerCoverage();

}
