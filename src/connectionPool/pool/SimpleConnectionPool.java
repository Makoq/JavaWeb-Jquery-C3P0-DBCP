package connectionPool.pool;

import connectionPool.utils.DButils;

import java.sql.Connection;
import java.util.Collections;
import java.util.LinkedList;

public class SimpleConnectionPool {

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
    public Connection gETConnectionFromPool(){
        Connection conn=null;
        if(pool.size()>0){
            conn=pool.removeFirst();
            return conn;
        }else{
            //所有连接都出台了，就抛出等待异常或者新建连接
           throw  new RuntimeException("服务器忙.....");
        }

    }
    //释放资源
    public void release(Connection conn){

        pool.addLast(conn);

    }




}
