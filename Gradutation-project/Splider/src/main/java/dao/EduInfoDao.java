package dao;


import model.EduInfo;

import java.util.List;

/**
 * Created by kexin on 2017/3/13.
 */
public interface EduInfoDao {
    public int saveUser(EduInfo eduInfo);

    public List<EduInfo> selectWords() throws Exception;

}