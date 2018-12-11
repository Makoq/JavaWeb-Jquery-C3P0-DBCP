package DBUTils;

import TransferAccount.Utils.C3P0UTils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class testCRUD {

    /**
     * DBUTils的增、删、改、查方法测试
     */
    @Test
    public void testInsert(){

        //创建queryRunner对象
        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());
        try {
            qr.update("insert into login(name,password,email,birthday) values(?,?,?,?)","jackma","11","alli@qq.com","11-11");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDelete(){

        //创建queryRunner对象
        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());
        try {
            qr.update("delete from login where id=?","16");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){

        //创建queryRunner对象
        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());
        try {
            qr.update("update login set name=?,password=?,email=? where id=?","jayzhou","12","jay@163.com","12");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testSelect()throws Exception{

        //创建一个queryRunner对象
        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());

        //BeanListHandler完成了对ResultSetHandler的封装，所以直接调用，两行代码就很方便了
        List<Users> list =qr.query("select*from login WHERE ID=1",new BeanListHandler<>(Users.class));

        for (Users us: list){
            System.out.println(us);
        }
    }


    /**
     * 批量处理
     * @throws Exception
     */
    @Test
    public void testBatch()throws Exception{

        //创建一个queryRunner对象
        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());


       Object[][] params=new Object[10][];//第一个参数代表执行sql次数,第二个表示每一个“？”对应的值

        //执行10次sql,插入10个superhero
        for (int i = 0; i < params.length; i++) {
            params[i]=new Object[]{"superhero"+i,"123","131231@com",new Date()};
        }

        //批量执行sql
        qr.batch("insert into login(name,password,email,birthday) values(?,?,?,?)",params);


    }







}
