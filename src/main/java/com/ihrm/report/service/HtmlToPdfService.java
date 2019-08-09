package com.ihrm.report.service;

import com.ihrm.report.function.FileUtil;
import com.ihrm.report.function.HtmlToPdfInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class HtmlToPdfService {

    private static Logger logger = LoggerFactory.getLogger(HtmlToPdfService.class);
    //tomcat根目录下创建缓存文件夹
    public final  String pdfGeneratePath = this.getClass().getClassLoader().getResource("").getPath()+ File.separator+"cache"+File.separator;


    // wkhtmltopdf在系统中的路径
   @Value("${pathConfig.toPdfTool}")
    private  String toPdfTool ;

    /**
     * 容器 请求 头 http://127.0.0.1:808
     */
    @Value("${pathConfig.pdfHttpHeader}")
    private String pdfHttpHeader;

    /**
     * html转pdf
     *
     * @param srcPath  html路径，可以是硬盘上的路径，也可以是网络路径
     * @param applyCode pdf保存路径
     * @return 转换成功返回true
     */
    public  String convert(String srcPath, String applyCode) {
        String fileDir = pdfGeneratePath+applyCode+File.separator;
        FileUtil.createDir(fileDir);
        //得到 文件夹的 绝对路径
        fileDir = new File(fileDir).getAbsolutePath()+File.separator+applyCode+".pdf";
        StringBuilder cmd = new StringBuilder();
        if (System.getProperty("os.name").indexOf("Windows") == -1) {
            // 非windows 系统
            //toPdfTool = FileUtil.convertSystemFilePath("/home/ubuntu/wkhtmltox/bin/wkhtmltopdf");
        }
        cmd.append(toPdfTool);
        cmd.append(" ");
        /*if(flag){
            cmd.append(" --page-height 550 ");//  --page-height <unitreal>  页面高度 (default unit millimeter)
        }else{
            cmd.append(" --page-height 400 ");//  --page-height <unitreal>  页面高度 (default unit millimeter)
        }*/
        cmd.append(" --page-width 300 ");// --page-width <unitreal>  页面宽度 (default unit millimeter)
        cmd.append(" --javascript-delay 500 ");//延迟加载(单位 毫秒)
        cmd.append(" --page-size A3"); // 设置纸张大小: A4, Letter, etc.
        cmd.append(" --enable-javascript ");//允许js加载
        cmd.append(" --no-stop-slow-scripts ");//允许慢js加载
        //cmd.append(" --no-background "); //不打印背景
        cmd.append(pdfHttpHeader+srcPath);
        cmd.append(" ");
        cmd.append(fileDir);

        try {
            Process proc = Runtime.getRuntime().exec(cmd.toString());
            HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(proc.getErrorStream());
            HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(proc.getInputStream());
            error.start();
            output.start();
            // 等待程序执行结束并输出状态
            int exitCode =  proc.waitFor();
        } catch (Exception e) {
            fileDir=null;
            e.printStackTrace();
        }

        return fileDir;
    }


}
