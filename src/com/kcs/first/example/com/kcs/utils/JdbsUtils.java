package com.kcs.first.example.com.kcs.utils;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by xeval on 2017-03-07.
 */
public class JdbsUtils {
    public static boolean isTableExist(Connection connection,String tableName){
        boolean isTExist=false;


        try {
            DatabaseMetaData metaData= connection.getMetaData();
           ResultSet resultSet=  metaData.getTables(null,null,tableName,null);
            isTExist=resultSet.next();



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isTExist;
    }

}
