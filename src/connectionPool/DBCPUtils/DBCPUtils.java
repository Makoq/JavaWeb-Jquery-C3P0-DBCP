package connectionPool.DBCPUtils;

import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBCPUtils {

    static DataSource ds=null;

   static {
            Properties prop=new Properties();//hashtable的一个子类
       try {

           prop.load(DBCPUtils.class.getClassLoader().getResourceAsStream("dbcpconfig.properties"));

           // 得到一个数据源（数据源里有属性文件里定义好的若干个连接）相当于之前sourcedata里面for创建10个连接，
           // 然后定义getConnection和close()方法，再将close方法装饰，在这里这些内容全都封装在BasicDataSourceFactory.createDataSource()里了
           // 这是框架提供的，利用这个封装好的方法可以直接拿到含有在属性文件里定义好数目的若干Connection
           ds=BasicDataSourceFactory.createDataSource(prop);
       } catch (Exception e) {
           throw new ExceptionInInitializerError("初始化错误，检查配置");
       }

   }

   public static Connection getConnection(){
       try {
           return ds.getConnection();
       } catch (SQLException e) {
           throw new RuntimeException("服务器忙");
       }

   }


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
