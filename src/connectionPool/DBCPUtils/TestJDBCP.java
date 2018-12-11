package connectionPool.DBCPUtils;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestJDBCP {

    @Test
    public void test1(){

        Connection conn=null;
        PreparedStatement ps=null;

        conn=DBCPUtils.getConnection();

        try {
            ps=conn.prepareStatement("INSERT INTO login(name,password)values('jay','z')");
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBCPUtils.release(conn,ps,null);
        }

    }

}


