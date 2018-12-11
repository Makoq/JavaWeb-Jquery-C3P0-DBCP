package connectionPool.C3P0;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TestC3P0 {
    @Test
    public void test2(){
        Connection conn=null;
        PreparedStatement ps=null;


        try {
            conn=C3P0UTils.getConnection();
            ps=conn.prepareStatement("insert into login(name,password) values('grils','123')");
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            C3P0UTils.release(conn,ps,null);
        }


    }

}
