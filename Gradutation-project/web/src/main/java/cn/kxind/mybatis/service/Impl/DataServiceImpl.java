package cn.kxind.mybatis.service.Impl;

import cn.kxind.mybatis.bean.EduInfo;
import cn.kxind.mybatis.dao.EduInfoMapper;
import cn.kxind.mybatis.service.IDataService;
import cn.kxind.mybatis.vo.DataJson;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/30.
 */
@Service("dataService")
public class DataServiceImpl implements IDataService {
    @Autowired
    private EduInfoMapper eduInfoMapper;

    @Override
    public String getAllEduInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<EduInfo> list = eduInfoMapper.getAllEduInfo();
        PageInfo<EduInfo> pageInfo = new PageInfo<>(list);
        Gson gson=new Gson();
        String result=gson.toJson(pageInfo.getList());
        DataJson dataJson=new DataJson();
        dataJson.setTotal(pageInfo.getTotal());
        dataJson.setRows(pageInfo.getList());
        return gson.toJson(dataJson);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {

        return eduInfoMapper.deleteByPrimaryKey(id);
    }
}
