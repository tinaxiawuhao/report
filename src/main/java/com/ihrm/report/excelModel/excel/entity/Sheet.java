package com.ihrm.report.excelModel.excel.entity;

import com.alibaba.fastjson.annotation.JSONType;
import com.ihrm.report.excelModel.IJson;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Excel sheet 实体对象
 * @author 谢长春 on 2017/10/15 .
 */
@NoArgsConstructor
@Data
@Accessors(chain = true)
@JSONType(orders = {"index","name","table"})
public class Sheet implements IJson {
    /**
     * excelModel sheet 标签页索引
     */
    private int index;
    /**
     * excelModel sheet 标签页名称
     */
    private String name;
    /**
     * excelModel sheet 标签页内容
     */
    private Table table;

    @Override
    public String toString() {
        return json();
    }
}
