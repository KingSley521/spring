package com.example.demo.flyway;

import org.flywaydb.core.Flyway;

public class FlywayTest {

    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/fly?useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&rewriteBatchedStatements=true&useSSL=false&serverTimezone=GMT%2B8";
        String username = "root";
        String pwd = "Luminary521@@";
        Flyway flyway = Flyway.configure().dataSource(url,username,pwd).load();
        // 删除 flyway_schema_history 表中失败的记录
        //flyway.repair();
        // 检查 sql 文件
        flyway.validate();
        int result = flyway.migrate();

    }
}
