package com.kcs.first.example.database;

import com.kcs.first.example.vo.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by xeval on 2017-03-07.
 */
public class StudensQuerys {

    private Connection connection;
    public StudensQuerys(Connection connection){
        this.connection=connection;
    }


    public List<Student> getStudents() {
        List<Student> students=new ArrayList<>();


        try {
            Statement st = connection.createStatement();


            ResultSet resultSet = st.executeQuery("SELECT * From students");
            //TODO sukurti lista


            while (resultSet.next()) {
                //TODO sudeti i lista add(new Student(....));;
                students.add(new Student(resultSet.getInt("id"), resultSet.getString("name"),
                        resultSet.getString("surname"), resultSet.getString("phone"),
                        resultSet.getString("email")));
                System.out.println(resultSet);




               System.out.println("id>>>" + resultSet.getInt(1)//stulpelio indeksas
                        + "userName>>>" + resultSet.getString("name")
                        + resultSet.getString("surname")
                        + "phone>>>" + resultSet.getString("phone")
                        + "email>>>" + resultSet.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
return students;

    }
    public void updateStudentName(int studenid,String name){



        try {
            Statement statement=connection.createStatement();
            statement.executeUpdate("UPDATE students SET name='" +name+ "' WHERE id ="+studenid);


        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

        public void insertStudent(Student student){
            try {
                Statement statement=connection.createStatement();

                statement.execute("INSERT INTO students(name,surname,phone,email) VALUES('"+student.getName()+"','"+student.getSurname()+"','"
                        +student.getPhone()+"','"+student.getEmail()+"')");
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        public  boolean isStudenExist(String name,String surName){
            boolean exist=true;
            try {
                Statement statement=connection.createStatement();
                ResultSet resultSet=statement.executeQuery("SELECT FROM students");
                resultSet.getString("name");
                resultSet.getString("surname");
                while (resultSet.next()){
                    resultSet.getString("surname");
                    if (name.contentEquals(resultSet.getString("name"))&& surName.contentEquals(resultSet.getString("surname")))
                    {

                    }
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

                return  exist;
        }

/*public  boolean isStudentExist(String name,String surName){
            boolean exists=false;
            try {
                PreparedStatement st= null;


                    st = connection.prepareStatement("SELECT*FROM students WHERE name=? AND surname=?");
                    st.setString(1,name);
                    st.setString(2,surName);
                    ResultSet resultSet=st.executeQuery();
                    exists=resultSet.next();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
               return  exists;
            }
}
*/



}