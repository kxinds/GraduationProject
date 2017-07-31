package cn.kxind.mybatis.service;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/30.
 */
public interface IDataService {
    /**
     * 分页获取爬取信息
     * @return
     */
   String getAllEduInfo(Integer pageNum, Integer pageSize);

    /**
     * 数据详情 删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Integer id);
}
