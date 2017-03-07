package com.kcs.first.example;

import java.sql.*;

/**
 * Created by xeval on 2017-03-07.
 */
public class MyFirstconnectionExample {
    public static void main(String[] args) {
        try {
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/kcs","root","");
            if (connection!=null){
                System.out.println("CONNECTED!");
                getStudents(connection);
            }
        } catch (SQLException e) {
            System.out.println("Connection Fail!!"+e);
        }


    }
private static void getStudents(Connection connection){
    try {
        Statement st= connection.createStatement();
       ResultSet resultSet= st.executeQuery("SELECT * From students");
       while (resultSet.next()){

           System.out.println("id>>>"+resultSet.getInt(1)//stulpelio indeksas
                   +"userName>>>"+resultSet.getString("name")
                   +resultSet.getString("surname")
           +"phone>>>"+resultSet.getString("phone")
           +"email>>>"+resultSet.getString("email"));
       }
    } catch (SQLException e) {
        e.printStackTrace();
    }


}



}
