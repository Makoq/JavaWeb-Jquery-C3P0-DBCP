package DBUTils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class C3P0UTils {




    //得到数据源
    private static ComboPooledDataSource cpds = new ComboPooledDataSource();

    public static ComboPooledDataSource getDataSource() {

        return cpds;
    }

    //从池子里取得一个连接
    public static Connection getConnection(){


        try {
            return  cpds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException("服务器忙");
        }


    }

    //释放资源
    public static void release(Connection conn, Statement state, ResultSet rs){
        try {
            rs.close();
            state.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }



}
