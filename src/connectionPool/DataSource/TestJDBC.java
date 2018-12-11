package connectionPool.DataSource;

import connectionPool.pool.MyDataSource;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBC {

    Connection conn=null;
    PreparedStatement ps=null;




    @Test
    public void test(){

        DataSource ds=new MyDataSource();
        try {

            conn=ds.getConnection();
            ps=conn.prepareStatement("..");//增删改查，这里还没有写.....


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }






}
