package com.zzaki.common;

import io.searchbox.client.JestResult;
import io.searchbox.client.http.JestHttpClient;
import io.searchbox.core.Bulk;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.indices.ClearCache;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;
import io.searchbox.indices.IndicesExists;
import io.searchbox.indices.mapping.PutMapping;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.source.FetchSourceContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Zzaki
 * @Description:
 * @Date: Created on 2018/6/13
 * @Company: DeepWise
 */
@Service
public class EsKit {

    private static JestHttpClient jestClient = ESFactory.getClient();
    /**
     * @Author :Zzaki
     * @Description: 创建索引
     * @Date: 2018/6/13
     * @Params: [indexName]
     * @Return: void
     * @Company: DeepWise
     */
    public static boolean createIndex(String indexName) throws Exception {
        CreateIndex createIndex = new CreateIndex.Builder(indexName).build();
        JestResult jestResult = jestClient.execute(createIndex);
        //jestClient.shutdownClient();
        return jestResult.isSucceeded();
    }

    /**
     * @Author :Zzaki
     * @Description: Put映射
     * @Date: 2018/6/13
     * @Params: [indexName, type, source]
     * @Return: void
     * @Company: DeepWise
     */
    public static boolean createIndexMapping(String indexName,String type,String source) throws Exception {
        PutMapping putMapping = new PutMapping.Builder(indexName,type,source).build();
        JestResult jestResult = jestClient.execute(putMapping);
        //jestClient.shutdownClient();
        return jestResult.isSucceeded();
    }

    /**
     * @Author :Zzaki
     * @Description: 插入document
     * @Date: 2018/6/13
     * @Params: [indexName, type, document]
     * @Return: void
     * @Company: DeepWise
     */
    public static <T>boolean insert(String indexName,String type,T document) throws Exception{
        Index index = new Index.Builder(document).index(indexName).type(type).build();
        JestResult jestResult = jestClient.execute(index);
        //jestClient.shutdownClient();
        return jestResult.isSucceeded();
    }

    /**
     * @Author :Zzaki
     * @Description: 批量插入documents
     * @Date: 2018/6/13
     * @Params: [indexName, type, documents]
     * @Return: void
     * @Company: DeepWise
     */
    public static <T>boolean bulkIndex(String indexName, String type, List<T> documents)throws Exception{

        Bulk.Builder bulkBuilder = new Bulk.Builder();
        documents.stream().forEach(d->{
            Index index  = new Index.Builder(d).index(indexName).type(type).build();
            bulkBuilder.addAction(index);
        });
        JestResult jestResult = jestClient.execute(bulkBuilder.build());
        //jestClient.shutdownClient();
        return jestResult.isSucceeded();
    }

    /**
     * @Author :Zzaki
     * @Description: 通过keyword查询
     * @Date: 2018/6/13
     * @Params: [keyword, index, type]
     * @Return: java.util.List
     * @Company: DeepWise
     */
    public static List Query(String keyword,String index,String type) throws Exception {
        // files 指定返回的字段
        final String[] fields = new String[]{"paperAuthor","paperContent"};
        QueryBuilder queryBuilder = QueryBuilders.queryStringQuery(keyword);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder()
                .query(queryBuilder)
                .fetchSource(new FetchSourceContext(fields))
                .from(0)
                .size(10);

        Search search = new Search.Builder(searchSourceBuilder.toString())
                .addIndex(index).addType(type).build();
        SearchResult searchResult = jestClient.execute(search);

        List<SearchResult.Hit<Object, Void>> hits = searchResult.getHits(Object.class);
        List returnSource = new ArrayList();
        hits.stream().forEach(h->{
            returnSource.add(h.source);
        });
        //jestClient.shutdownClient();
        return returnSource;
    }

    /**
     * @Author :Zzaki
     * @Description: 删除索引
     * @Date: 2018/6/13
     * @Params: [indexName]
     * @Return: boolean
     * @Company: DeepWise
     */
    public boolean deleteIndex(String indexName)throws Exception{
        DeleteIndex deleteIndex = new DeleteIndex.Builder(indexName).build();
        JestResult jestResult  = jestClient.execute(deleteIndex);
        //jestClient.shutdownClient();
        return jestResult.isSucceeded();
    }

    /**
     * @Author :Zzaki
     * @Description: 判断索引是否存在
     * @Date: 2018/6/13
     * @Params: [indexName]
     * @Return: boolean
     * @Company: DeepWise
     */
    public boolean indicesExists(String indexName)throws Exception{
        IndicesExists indicesExists = new IndicesExists.Builder(indexName).build();
        JestResult result  = jestClient.execute(indicesExists);
        //jestClient.shutdownClient();
        if (result.getResponseCode() == 200)
            return true;
        else
            return false;
    }

    /**
     * @Author :Zzaki
     * @Description: 清理缓存
     * @Date: 2018/6/13
     * @Params: []
     * @Return: void
     * @Company: DeepWise
     */
    public void clearCache() throws Exception{
        ClearCache clearCache = new ClearCache.Builder().build();
        jestClient.execute(clearCache);
        //jestClient.shutdownClient();
    }
}
