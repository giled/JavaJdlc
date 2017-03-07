package com.kcs.first.example;

import com.kcs.first.example.com.kcs.utils.JdbsUtils;
import com.kcs.first.example.database.StudensQuerys;
import com.kcs.first.example.vo.Student;

import java.sql.*;
import java.util.List;

/**
 * Created by xeval on 2017-03-07.
 */
public class MyFirstconnectionExample {
    public static void main(String[] args) {
        try {
            Connection connection= DriverManager.getConnection("jdbc:mysql://127.0.0.1/kcs","root","");
            if (connection!=null){
                System.out.println("CONNECTED!");
                StudensQuerys studensQuerys=new StudensQuerys(connection);
             //  studensQuerys.getStudents();
              //  Student st=new Student("Kazys","Kaziolas","+4787471","asfergdfgdfs@ggf");
               // studensQuerys.insertStudent(st);
               // System.out.println("is table exists>>>>" + JdbsUtils.isTableExist(connection,"students"));
              //  studensQuerys.updateStudentName(3,"Obama");
              //  Student sc= new Student("Kazys","sef","8745148745148","sdfg");
              //  System.out.println("Test>>"+studensQuerys.isStudenExist("Evaldas","Gardas"));
                List<Student> studentList=studensQuerys.getStudents();
                System.out.println(studentList);
            }
        } catch (SQLException e) {
            System.out.println("Connection Fail!!"+e);
        }


    }

}




