package com.zzaki.main;

import com.zzaki.common.EsKit;
import com.zzaki.model.PaperBean;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/6/13
 * @Company: DeepWise
 */
public class TestMain {

    public static void main(String[] args) throws Exception {
        /*List<PaperBean> paperBeans = new ArrayList<>();
        for(long i = 0; i < 3; i++){
            PaperBean paperBean = new PaperBean(i,"zzaki"+i,"hahahahahaha"+i);
            paperBeans.add(paperBean);
        }
        EsKit.bulkIndex("deepwise","type",paperBeans);*/

        List returnList = EsKit.Query("zzaki1","deepwise","type");
        System.out.println(returnList.toString());
    }
}
