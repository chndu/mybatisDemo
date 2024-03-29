package com.corre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbc {

    public static void main(String[] args) throws Exception{
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://xx.xx.xx.xx:3306/leecx";
            String user = "root";
            String password = "root";
            connection = DriverManager.getConnection(url,user,password);
            String sql = "select * from tb_user where id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1,1l);
            rs = preparedStatement.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString("user_name"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
                System.out.println(rs.getDate("birthday"));

            }
        }finally {
            if(rs != null){
                rs.close();
            }
            if(preparedStatement != null){
                preparedStatement.close();
            }
            if(connection != null){
                connection.close();
            }
        }
    }
}
