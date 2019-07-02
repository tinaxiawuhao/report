package com.ihrm.report.controller;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.util.HashMap;

@RestController
public class JasperController {
    @GetMapping("/testJasper")
    public void createHtml(HttpServletResponse response, HttpServletRequest request) throws Exception {
        //引入jasper文件。由JRXML模板编译生成的二进制文件，用于代码填充数据
        Resource resource = new ClassPathResource("templates/reportDemo1.jasper");
        //加载jasper文件创建inputStream
        FileInputStream isRef = new FileInputStream(resource.getFile());
        ServletOutputStream sosRef = response.getOutputStream();
        try {
            //创建JasperPrint对象
            JasperPrint jasperPrint = JasperFillManager.fillReport(isRef, new HashMap<>
                    (), new JREmptyDataSource());
            //写入pdf数据
            JasperExportManager.exportReportToPdfStream(jasperPrint, sosRef);
        } finally {
            sosRef.flush();
            sosRef.close();
        }
    }
}