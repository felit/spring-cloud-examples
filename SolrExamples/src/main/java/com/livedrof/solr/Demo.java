package com.livedrof.solr;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrInputDocument;

import java.io.IOException;
import java.util.*;

public class Demo {
    private static SolrClient solr;

    public static void main(String args[]) throws IOException, SolrServerException {
//        String urlString = "http://localhost:8983/solr/data";
        String urlString = "http://192.168.26.20:8984/data";
        String id = "北京-报纸-电动车-资讯快报.pdf";
        Init(urlString);
//        addIndex();
        searchData();
    }

    /**
     * @Author：sks
     * @Description：初始化solr客户端
     * @Date：
     */
    public static void Init(String urlString) {
        solr = new HttpSolrClient.Builder(urlString).build();
    }

    /**
     * @Author：sks
     * @Description：添加索引
     * @Date：
     */
    public static void addIndex() throws SolrServerException, IOException {

        SolrInputDocument document = new SolrInputDocument();
        document.addField("point", "9527");
        document.addField("vip", "啦啦");
        document.addField("content", "solr是个好东西");
        document.addField("add_time", new Date());
        solr.add(document);
        solr.commit();
    }

    /**
     * @Author：sks
     * @Description：更新索引中多个属性数据
     * @Date：
     * @id：索引ID
     * @maps：属性名称，属性值键值对
     */
    public static void updateMultiData(String id, Map<String, String> maps) throws SolrServerException, IOException {

        Set<String> keys = maps.keySet();
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", id);
        for (String key : keys) {
            HashMap<String, Object> oper = new HashMap<String, Object>();
            oper.put("set", maps.get(key));
            doc.addField(key, oper);
        }

        UpdateResponse rsp = solr.add(doc);
        System.out.println("update doc id:" + id + " result:" + rsp.getStatus() + " Qtime:" + rsp.getQTime());
        UpdateResponse rspCommit = solr.commit();
        System.out.println("commit doc to index" + " result:" + rspCommit.getStatus() + " Qtime:" + rspCommit.getQTime());

    }

    /**
     * @Author：sks
     * @Description：更新索引中单个属性数据
     * @Date：
     * @id：索引ID
     * @fieldName：属性名称
     * @fieldValue：属性值
     */
    public static void updateSingleData(String id, String fieldName, Object fieldValue) throws SolrServerException, IOException {

        HashMap<String, Object> oper = new HashMap<String, Object>();
        oper.put("set", fieldValue);
        SolrInputDocument doc = new SolrInputDocument();
        doc.addField("id", id);
        doc.addField(fieldName, oper);
        UpdateResponse rsp = solr.add(doc);
        System.out.println("update doc id:" + id + " result:" + rsp.getStatus() + " Qtime:" + rsp.getQTime());
        UpdateResponse rspCommit = solr.commit();
        System.out.println("commit doc to index" + " result:" + rspCommit.getStatus() + " Qtime:" + rspCommit.getQTime());

    }

    /**
     * @Author：sks
     * @Description：删除指定ID的索引
     * @Date：
     * @id：索引ID
     */
    public static void delIndexByID(String id) throws SolrServerException, IOException {

        UpdateResponse ur = solr.deleteById(id);
        System.out.println(ur);

        UpdateResponse c = solr.commit();
        System.out.println(c);

    }

    /**
     * @Author：sks
     * @Description：查询数据
     * @Date：
     */
    public static void searchData() throws SolrServerException, IOException {
        //使用这个对象做查询
        SolrQuery params = new SolrQuery();
        //查询所有数据
//        params.setQuery("*:*");
        params.setQuery("id:广州-杂志-汽车-电台资讯快报-2015年2月.docx");
        //分页，默认是分页从0开始，每页显示10行
        params.setStart(0);
        params.setRows(30);

        QueryResponse queryResponse = solr.query(params);
        //拿到数据集合,返回查询结果
        List<SolrDocument> list = queryResponse.getResults();

        //循环打印数据集合
        for (SolrDocument solrDocument : list) {
            Object id = solrDocument.get("id");
            System.out.println(id.toString());

            Object fileSize = solrDocument.get("fileSize");
            System.out.println(fileSize.toString());

            Object fileLastModified = solrDocument.get("fileLastModified");
            System.out.println(fileLastModified.toString());

            Object fileAbsolutePath = solrDocument.get("fileAbsolutePath");
            System.out.println(fileAbsolutePath.toString());

            Object author = solrDocument.get("author");
            System.out.println(author.toString());

//            Object text = solrDocument.get("text");
//            System.out.println(text.toString());
            Object title = solrDocument.get("title");
            System.out.println(title.toString());

            Object author_area_keywor = solrDocument.get("author_area_keyword");
            System.out.println(author_area_keywor.toString());


        }
    }


}
