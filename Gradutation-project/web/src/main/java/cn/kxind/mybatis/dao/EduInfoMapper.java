package cn.kxind.mybatis.dao;

import cn.kxind.mybatis.bean.EduInfo;
import cn.kxind.mybatis.vo.CountInfo;
import cn.kxind.mybatis.vo.WordCloudInfo;

import java.util.List;

public interface EduInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EduInfo record);

    int insertSelective(EduInfo record);

    EduInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(EduInfo record);

    int updateByPrimaryKeyWithBLOBs(EduInfo record);

    int updateByPrimaryKey(EduInfo record);

    //根据年份统计数据数量
    List<CountInfo> getCountByYear();

    //有图片的数量
    int getImgNumber();
    //编辑修改
    int getEditorNumber();
    //校稿修改率
    int getProofreadNumber();
    //最终审稿率
    int getReviewerNumber();
    //所有文章数量
    int getAllNumber();
    //获得info
    List<EduInfo> getAllEduInfo();
    //获得词组
    List<String> getWordCount();
    //访问量 圆图
     List<WordCloudInfo> getPieCountByYear();

    //访问量 圆图 title
    List<String> getPieCountDataByYear();

    //获得编辑  圆饼图
    List<WordCloudInfo> getPieCountByEditor();
    //获得编辑原图 title
    List<String> getPieDataCountByEditor();

    //获得编辑 圆饼图
    List<WordCloudInfo> getPieCountByProofead();
    //获得编辑 圆饼图 title
    List<String> getPieDataCountByProofead();

    //根据月份 获得每月访客分布
    List<WordCloudInfo> getVistorMonthByYear(int year);

    List<String> getVistorMonthDataByYear(int year);

}