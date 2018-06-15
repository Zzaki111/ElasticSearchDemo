package com.zzaki.common;

import java.io.*;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/6/15
 * @Company: DeepWise
 */
public class FileKit {

    /**
     * @Author :Zzaki
     * @Description: 读取json文件返回String
     * @Date: 2018/6/15
     * @Params: [filePath]
     * @Return: java.lang.String
     * @Company: DeepWise
     */
    public static String jsonFile2String(String filePath) throws Exception {
        File file = new File(filePath);
        InputStream is = new FileInputStream(filePath);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuffer stringBuffer = new StringBuffer();
        String line = "";
        while ((line = br.readLine())!=null){
            stringBuffer.append(line);
        }
        return stringBuffer.toString();
    }
}
