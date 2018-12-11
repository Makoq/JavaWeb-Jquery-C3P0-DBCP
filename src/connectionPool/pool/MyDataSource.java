package connectionPool.pool;


import connectionPool.DataSource.MyConnection;
import connectionPool.utils.DButils;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MyDataSource implements DataSource {


    //自己的模拟连接池
    private static LinkedList<Connection> pool=(LinkedList<Connection>) Collections.synchronizedList(new LinkedList<Connection>()) ;

    static {

        try {

            for (int i = 0; i < 10; i++) {
               Connection conn=DButils.getConnection();
                pool.add(conn);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("数据库初始化失败，请检查配置文件");
        }

    }

    //从连接池取得一个连接对象

    @Override
    public Connection getConnection() throws SQLException {

        Connection conn=null;
        if(pool.size()>0){
            conn=pool.removeFirst();
            MyConnection myConn=new MyConnection(conn,pool);

            return myConn;
        }else{
            //所有连接都出台了，就抛出等待异常或者新建连接
            throw  new RuntimeException("服务器忙.....");
        }
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}
