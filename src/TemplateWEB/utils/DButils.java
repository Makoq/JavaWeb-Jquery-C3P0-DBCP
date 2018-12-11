package TemplateWEB.utils;


import java.sql.*;

public class DButils {

    //驱动类名，必须是静态的


/*
    static {
        //加载propertites
        ResourceBundle rb=ResourceBundle.getBundle("connection.dbinfo");//专门用于加载propertites
        className=rb.getString("className");
        url=rb.getString("url");
        username=rb.getString("username");
        password=rb.getString("password");

    }*/


    //创建连接
    public static  Connection getConnection() {

        String className = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/webdb";
        String username = "lan";
        String password = "123456";

        //注册驱动
        try {

            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //创建连接
        Connection conn = null;
        try {

            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;

    }
    //关闭资源
    public static void closeAll(ResultSet rs, Statement state,Connection conn){

        try {
            rs.close();
            state.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
