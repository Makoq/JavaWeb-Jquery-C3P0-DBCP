package JDBC;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class demon1 {

    //驱动类名，必须是静态的
    private static String className = "com.mysql.jdbc.Driver";

    @Test
    public static void main(String[] args) throws Exception {
        //注册驱动
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());

        //加载驱动
        Class.forName(className);
        //获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webdb", "lan", "123456");

        //得到执行sql的statement对象
        Statement state = conn.createStatement();

        //执行sql语句是，并返回结果
        //ResultSet rs=state.executeQuery("select *from login");

        int i = state.executeUpdate("insert into login values(4,'wang','123','123@gmail','1996-5-5')");
        if (i > 0) {
            System.out.println("success");
        }
        //处理结果集


        //输出
      /*  while(rs.next()){

            System.out.println(rs.getObject(1));
            System.out.println(rs.getObject(2));
            System.out.println(rs.getObject(3));
            System.out.println(rs.getObject(4));
            System.out.println(rs.getObject(5));
            System.out.println("---------");


        }*/

        //关闭资源
        conn.close();
        state.close();
        //rs.close();

    }

    @Test
    public void test1() {

        System.out.println("aaa");

    }


}
