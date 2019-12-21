package com.pri.entity;

import java.util.List;

 /**
  * @ClassName:      ResultEntity
  * @Description:    分页的返回实体
  * @author:         ChenQi
  * @CreateDate:     2019/5/6 11:45
  */
public class ResultEntity {
    private int total;
    private List<?> rows;

    public ResultEntity() {
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
