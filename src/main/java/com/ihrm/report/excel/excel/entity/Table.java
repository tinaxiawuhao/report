package com.ihrm.report.excel.excel.entity;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONType;
import com.ihrm.report.excel.IJson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Excel sheet 表格实体对象
 *
 * @author 谢长春 on 2017/10/15 .
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Accessors(chain = true)
@JSONType(orders = {"index", "name", "header", "body", "footer", "extras"})
public class Table implements IJson {
//    public static Result<Table> valueOf(final String jsonText) {
//        Objects.requireNonNull(jsonText, "参数【jsonText】是必须的");
//        return JSON.parseObject(jsonText, new TypeReference<Result<Table>>() {});
//    }
    /**
     * excel sheet 标签页索引
     */
    private int index;
    /**
     * excel sheet 标签页名称
     */
    private String name;
    /**
     * <pre>
     * 表头集合 =>
     * [
     * {index: 0, label: '房租', type: 'NUMBER', group: "固定成本",tag:"标签"},
     * {index: 1, label: '工资', type: 'NUMBER', group: "固定成本",tag:"标签"}
     * ]
     */
    private List<Cell> header;
    /**
     * <pre>
     * 表格行集合, （0.1.....）表示表头中的index，取值时，可以通过遍历表头的index字段获取值
     * [
     * {
     * 0: {type: 'NUMBER', text: "$1000", value: 1000},
     * 1: {type: 'NUMBER', text: "$1000", value: 1000}
     * }
     * ]
     */
    private List<Row> body;
    /**
     * <pre>
     * 表格底部合计行,（0.1.....）表示表头中的index，取值时，可以通过遍历表头的index字段获取值
     * {
     * 0: {type: 'NUMBER', text: "$2000", value: 2000},
     * 1: {type: 'NUMBER', text: "$2000", value: 2000}
     * }
     */
    private Row footer;
    /**
     * 表格附加字段（扩展属性）
     */
    private JSONObject extras;

    @Override
    public String toString() {
        return json();
    }

    /**
     * 将 header + body 转换为 map 对象；优先使用别名
     *
     * @return {@link List}{@link List<Map<String, String>>}
     */
    public List<Map<String, String>> toObjects() {
        return body.stream().map(row -> row.toMapString(header)).collect(Collectors.toList());
    }

}
