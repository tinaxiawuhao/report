package com.ihrm.report.controller;

import com.ihrm.report.service.HtmlToPdfService;
import com.ihrm.report.function.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
public class WkhtmltopdfController {

    @Autowired
    private HtmlToPdfService htmlToPdfService;

    /**
     * 导出PDF，将文件放入流内
     *
     * @param reportCoded
     */
    @GetMapping(value = "downloadPDF/{reportCoded}")
    public void downloadPDF(HttpServletResponse response, @PathVariable String reportCoded) {
        String fileDir = htmlToPdfService.convert("/reportor/interfaceView/" + reportCoded, reportCoded);
        if(Objects.nonNull(fileDir)){
            FileUtil.downloadPdf(response,fileDir);
        }

    }
}
