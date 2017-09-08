package com.netcar.dataModle;

import java.util.ArrayList;
import java.util.List;

/**
 * bootstrapTable数据表格模型
 *
 * @param <E>
 * @author Mander
 */
public class BaseTable<E> {

  private Integer total=0;// 总记录数

  private List<E> rows=new ArrayList<>();// 结果集


  public BaseTable() {
    super();
  }

  public BaseTable(Integer total, List<E> rows) {
    super();
    this.total = total;
    this.rows = rows;
  }

  public Integer getTotal() {
    return total;
  }

  public void setTotal(Integer total) {
    this.total = total;
  }

  public List<E> getRows() {
    return rows;
  }

  public void setRows(List<E> rows) {
    this.rows = rows;
  }

}
