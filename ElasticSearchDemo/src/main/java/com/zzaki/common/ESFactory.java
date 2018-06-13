package com.zzaki.common;

import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.client.http.JestHttpClient;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/6/13
 * @Company: DeepWise
 */
public class ESFactory {

    private static JestHttpClient client;

    private ESFactory(){

    }

    public synchronized static JestHttpClient getClient(){
        if (client == null){
            JestClientFactory factory = new JestClientFactory();
            factory.setHttpClientConfig(new HttpClientConfig.
                    Builder("http://47.93.27.148:9200")
                    .multiThreaded(true)
                    .build()
            );
            client = (JestHttpClient)factory.getObject();
        }
        return client;
    }
}
