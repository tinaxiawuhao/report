package com.ihrm.report.utils;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.*;


public class FileUtil {
    private static Logger logger = Logger.getLogger(FileUtil.class);
    /*
     * 创建文件目录
     * @Author wuhao
     * @Description //TODO
     * @Date 14:35 2019/8/6
     **/
    public static boolean createDir(String dirPath){
        File file = new File(dirPath);
        logger.debug("开始创建文件目录"+dirPath);
        if(!file.exists()){
            boolean isSuccess = file.mkdirs();
            logger.debug("创建文件目录"+dirPath+isSuccess(isSuccess));
            return isSuccess;
        }
        logger.debug("文件目录与存在，无须创建！");
        return true;
    }
    private static String isSuccess(boolean is){
        return is==true?"\t成功":"\t失败";
    }

     /*
      * 获取流文件，写入response
      * @Author wuhao
      * @Description //TODO
      * @Date 17:45 2019/8/6
      **/
    public static void downloadPdf(HttpServletResponse response,String fileDir){
        InputStream inputStream = null;
        OutputStream os = null;
        try {
            response.setContentType("application/octet-stream; CHARSET=utf8");
            response.addHeader("Content-transfer-Encoding", "binary");
            response.setHeader("Content-Disposition", "attachment; filename=test.pdf");
            inputStream = new FileInputStream(fileDir);
            os = response.getOutputStream();
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                os.write(b, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                os.close();
                inputStream.close();
                //将文件读取到流里面之后删除原文件
                File file=new File(fileDir);
                if(file.exists()){
                    file.delete();
                }
            } catch (IOException e) {
                os = null;
                inputStream = null;
                e.printStackTrace();
            }
        }
    }
}
