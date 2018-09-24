package com.livedrof.solr;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.request.ContentStreamUpdateRequest;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrInputDocument;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Date;

public class SolrTest {

    private HttpSolrClient solr;
    private String urlString = "http://192.168.26.20:8984/solr/started2";

    @BeforeClass
    public void setUp() {
        this.solr = new HttpSolrClient.Builder(urlString).build();
        ContentStreamUpdateRequest up = new ContentStreamUpdateRequest("/update/extract");
//        this.solr.setRequestWriter();
    }

    @Test
    public void test() throws IOException, SolrServerException {
        SolrInputDocument document = new SolrInputDocument();
//        document.addField("id", "9527");
        document.addField("point", "9527");
        document.addField("vip", "IndexTokenizer.segment");
        document.addField("content", "solr是个好东西");
        document.addField("add_time", new Date());
        solr.add(document);
        solr.commit();
    }

    @Test
    public void test2() throws IOException, SolrServerException {
        SolrQuery query = new SolrQuery("*:*");
        query.setStart(0);
        query.setRows(10);
        QueryResponse response = this.solr.query(query);
        System.out.println(response);
    }
}
