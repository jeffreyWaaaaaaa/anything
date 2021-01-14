package com.jw9j.elasticsearch;


import com.alibaba.fastjson.JSON;
import com.jw9j.elasticsearch.model.BillingDetail;
import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchScrollRequest;
import org.elasticsearch.client.Request;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.Scroll;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.joda.time.DateTime;

import java.io.IOException;
import java.util.ArrayList;

public class _1 {
    public static void main(String[] args) throws IOException {
        //        es client
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("10.126.21.98", 9200, "http")));
        Request request = new Request(
                "GET",
                "/"
        );
        SearchRequestDemo(client);
        client.close();
    }

    //    Es query demo
    public static void SearchRequestDemo(RestHighLevelClient restHighLevelClient) throws IOException {
        int scollerSize = 10000;
        final Scroll scroll = new Scroll(TimeValue.timeValueMinutes(1L));
        //        string builder the query string
        SearchRequest searchRequest = new SearchRequest("billingdetail");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.size(scollerSize);
        searchSourceBuilder.query(QueryBuilders.matchQuery("TenantId", "e7061fa294b44ffcb76957d6dfee3956"));
        searchRequest.source(searchSourceBuilder);

//        SearchAPIDemo(restHighLevelClient, searchRequest);
        SearchScrollAPIDemo(restHighLevelClient, searchRequest);
    }

    //    Get the max 10000 records
    public static void SearchAPIDemo(RestHighLevelClient restHighLevelClient, SearchRequest searchRequest) throws IOException {
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHit[] searchHits = searchResponse.getHits().getHits();
        int i = 0;
        for (SearchHit searchHit : searchHits) {
            System.out.println(searchHit.toString());
            i++;
        }
        System.out.println("Record counts：" + i);
    }

    //    Use ScrollAPI to get all Records;
    public static void SearchScrollAPIDemo(RestHighLevelClient restHighLevelClient, SearchRequest searchRequest) throws IOException {
        final Scroll scroll = new Scroll(TimeValue.timeValueMinutes(1L));
        searchRequest.scroll(scroll);

        // 获取启动时间：
        long startESTime = System.currentTimeMillis();
        SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
        String scrollId = searchResponse.getScrollId();
        SearchHit[] searchHits = searchResponse.getHits().getHits();
        ArrayList<BillingDetail> billingDetails = new ArrayList<>();
        int i = 0;
        while (searchHits != null && searchHits.length > 0) {
            SearchScrollRequest scrollRequest = new SearchScrollRequest(scrollId);
            scrollRequest.scroll(scroll);
            searchResponse = restHighLevelClient.scroll(scrollRequest, RequestOptions.DEFAULT);
            scrollId = searchResponse.getScrollId();
            searchHits = searchResponse.getHits().getHits();
            for (SearchHit searchHit : searchHits) {
//                System.out.println(searchHit);
                BillingDetail billingDetail = JSON.parseObject(searchHit.getSourceAsString(),BillingDetail.class);
                billingDetails.add(billingDetail);
                i++;
            }
        }
        long endESTime = System.currentTimeMillis();
        System.out.println("查询时间："+ (endESTime -startESTime) + "ms");
        System.out.println("record counts:" + billingDetails.size());
    }
}
