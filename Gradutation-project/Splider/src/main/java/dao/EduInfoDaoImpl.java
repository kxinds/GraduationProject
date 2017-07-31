package dao;

import model.EduInfo;
import util.DbHelper;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kexin on 2017/3/15.
 */
public class EduInfoDaoImpl implements EduInfoDao{
    @Override
    public int saveUser(EduInfo eduInfo){
        DbHelper dbhelper = new DbHelper();
        StringBuffer sql = new StringBuffer();
        sql.append("INSERT INTO eduinfo(title,source,number,date,imglist,mainText,provider,editor,proofread,reviewer)")
             .append("VALUES (? ,? , ? , ? , ? , ? , ? , ?, ? ,?) ");
        //设置 sql values 的值
        List<String> sqlValues = new ArrayList<String>();
        sqlValues.add(eduInfo.getTitle());
        sqlValues.add(eduInfo.getSource());
        sqlValues.add(eduInfo.getNumber()+"");
        sqlValues.add(eduInfo.getDate());
        sqlValues.add(eduInfo.getImgList().toString());
        sqlValues.add(eduInfo.getMainText());
        sqlValues.add(eduInfo.getProvider());
        sqlValues.add(eduInfo.getEditor());
        sqlValues.add(eduInfo.getProofread());
        sqlValues.add(eduInfo.getReviewer());
        int result = dbhelper.executeUpdate(sql.toString(), sqlValues);
        return result;
    }

    @Override
    public List<EduInfo> selectWords()throws Exception {
        DbHelper dbhelper = new DbHelper();
        StringBuffer sql = new StringBuffer();
        sql.append("select mainText from eduinfo where date like '2017%' ");
        ResultSet rs=dbhelper.executeQuery(sql.toString(),null);
       EduInfo eduInfo=new EduInfo();
        List<EduInfo> list =new ArrayList<EduInfo>();
        while(rs.next()){
            eduInfo.setMainText(rs.getString("mainText"));
       }
        list.add(eduInfo);

        return list;
    }

}
