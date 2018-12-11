package TransferAccount2.Utils;

import java.sql.Connection;
import java.sql.SQLException;

public class ManagerThreadLocal {
    private static ThreadLocal<Connection> tl=new ThreadLocal<Connection>();


    //得到一个连接
    public static Connection getConnection(){

        Connection conn=tl.get();//从当前线程取到一个连接
        if(conn==null){
            conn=C3P0UTils.getConnection();//如果当前线程为空，则从池里取一个
            tl.set(conn);
        }
        return conn;

    }
    //开始事务
    public static void startTransaction(){
        try {
            getConnection().setAutoCommit(false);//从当前去除的线程对象中取出的连接，并开始事务

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //提交事务
    public static void commit(){
        try {
            getConnection().commit();//提交事务
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //回滚
    public static void rollback(){
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void release(){
        try {
            getConnection().close();//把连接放回池子里
            tl.remove();//把占用线程的连接移去
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}


