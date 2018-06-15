package com.zzaki.main;

import com.zzaki.common.EsKit;
import com.zzaki.common.FileKit;
import com.zzaki.model.FileBean;
import com.zzaki.model.PaperBean;
import com.zzaki.model.SeriesBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/6/13
 * @Company: DeepWise
 */
public class TestMain {

    public static void main(String[] args) throws Exception {

        //创建index
        EsKit.createIndex("deepwise");


        // 创建mapping
        String source  = FileKit.jsonFile2String("src/main/resources/deepwise.json");
        System.out.println(source);
        EsKit.createIndexMapping("deepwise","series",source);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<FileBean> fileBeans = new ArrayList<>();
        long startTime = System.nanoTime();
        for (long i = 0;i<100;i++){
            Date date = new Date();
            String ds = df.format(date);
            date = df.parse(ds);
            //DateTime date = DateTime.parse(ds,format);
            FileBean fileBean = new FileBean(i,"patient"+i,"study"+i,
                    "instance"+i,i,"filePath"+i,50000+i,"fileMd5"+i,
                    date,date);
            fileBeans.add(fileBean);
        }
        SeriesBean seriesBean = new SeriesBean(1,fileBeans);
        EsKit.insert("deepwise","series",seriesBean);
        //EsKit.bulkIndex("deepwise","series",seriesBeans);
        long endTime = System.nanoTime();
        System.out.println("update 100 执行时间："+(endTime-startTime)+"ns");
        //System.out.println("bulk 100 执行时间："+(endTime-startTime)+"ns");
    }
}
