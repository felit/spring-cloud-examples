package com.livedrof.es;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.Properties;

public class JDBCTest {
    private String driver = "org.elasticsearch.xpack.sql.jdbc.jdbc.JdbcDriver";
    private String elasticsearchAddress = "10.36.4.47:9200";
    private String address = "jdbc:es://http://" + elasticsearchAddress;

    @Before
    public void init() {

    }

    @Test
    public void testJdbc() throws SQLException {
        System.out.println("hello");
        Properties connectionProperties = new Properties();
        Connection connection = DriverManager.getConnection(address, connectionProperties);
        Statement statement = connection.createStatement();
        String sql = "SELECT spu FROM goods_info_betaa_v3 ORDER BY has_stock DESC LIMIT 5";
        System.out.println(sql);
        Assert.assertEquals(1l, 1l);
        ResultSet results = statement.executeQuery(sql);
        while (results.next()) {
            System.out.println(results.getString("spu"));
        }
    }

    @Test
    public void testjj() {

    }
}
