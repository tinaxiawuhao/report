package com.ihrm.report.excel;

import lombok.SneakyThrows;

/**
 * 执行:不带参不带返回值的方法，补全 lambda 表达式不支持的部分
 *
 * @author 谢长春 2018-10-11
 */
public interface ICall {
    /**
     * 执行代码
     */
    @SneakyThrows
    void call();
}