package com.ihrm.report.excel.excel.entity;


import com.ihrm.report.excel.IJson;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.regex.Matcher;

import static com.ihrm.report.excel.enums.Regs.EXCEL_ADDRESS;


/**
 * 定义excel 单元格坐标
 *
 * @author 谢长春 on 2017/10/13 .
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Accessors(chain = true)
@Slf4j
public class Position implements IJson {

    public static Position of(final String address) {
        final Matcher m = EXCEL_ADDRESS.matcher(address);
        return m.find() ? new Position(Integer.parseInt(m.group(2)), m.group(1)) : new Position();
    }

    public static Position ofRow(final String row) {
        return new Position(Integer.parseInt(row), null);
    }

    public static Position ofColumn(final String column) {
        return new Position(0, column);
    }

    /**
     * 索引从 0 开始
     *
     * @param index int 列索引
     * @return {@link Position}
     */
    public static Position ofColumn(int index) {
        String column = "";
        ++index;
        do {
            column = Objects.toString((char) (((index - 1) % 26) + 65)).concat(column);
            index = Double.valueOf(Math.floor((index - 1.0) / 26)).intValue();
        } while (index > 0);
        return new Position(0, column);
    }

    /**
     * 单元格 y 坐标 ：行 ： 0-9
     */
    private int row;
    /**
     * 单元格 x 坐标 ：列 ： A-Z
     */
    private String column;

    /**
     * 索引从 0 开始
     *
     * @param index int 列索引
     * @return {@link Position}
     */
    public Position column(int index) {
        String column = "";
        ++index;
        do {
            column = Objects.toString((char) (((index - 1) % 26) + 65)).concat(column);
            index = Double.valueOf(Math.floor((index - 1.0) / 26)).intValue();
        } while (index > 0);
        this.column = column;
        return this;
    }

    /**
     * 坐标位置文本：A11
     *
     * @return String
     */
    public String address() {
        return String.format("%s%d", column, row);
    }

    public int rowIndex() {
        return row - 1;
    }

    public int columnIndex() {
        int value = 0;
        for (Character c : column.toCharArray()) {
            value = 26 * value + c.hashCode() - 64;
        }
        return value - 1;
    }

    @Override
    public String toString() {
        return json();
    }

    public static void main(String[] args) {
        log.info("{}", Position.of("A1"));
        log.info("{}", Position.of("AB12"));
        System.out.println("*******************");
        for (int i = 0; i < 100; i++) {
            System.out.println(Position.ofColumn(i));
        }
    }
}
