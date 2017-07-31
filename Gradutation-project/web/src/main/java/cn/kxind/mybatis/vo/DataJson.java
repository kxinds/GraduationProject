package cn.kxind.mybatis.vo;

import cn.kxind.mybatis.bean.EduInfo;

import java.util.List;

/**
 * @Author: kxind
 * @Version: V1.0
 * @Description:
 * @Date: 2017/3/30.
 */
public class DataJson {
    private long total;
    private List<EduInfo> rows;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<EduInfo> getRows() {
        return rows;
    }

    public void setRows(List<EduInfo> rows) {
        this.rows = rows;
    }

    public DataJson(long total, List<EduInfo> rows) {
        this.total = total;
        this.rows = rows;
    }

    public DataJson() {
    }

}
