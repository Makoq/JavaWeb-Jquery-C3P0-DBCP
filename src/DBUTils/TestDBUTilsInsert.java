package DBUTils;

import TransferAccount.Utils.C3P0UTils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDBUTilsInsert {

    /**
     * DBUTils的插入方法测试
     * @throws Exception
     */
    @Test
    public void testInsert()throws Exception{

        //创建QueryRunner对象，拿到数据源
        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());


        List<Users> li=qr.query("select * from login", new ResultSetHandler<List<Users>>() {
            @Override

           //当Query执行SQL以后将结果集以参数形式传过来
            public List<Users> handle(ResultSet resultSet) throws SQLException {
                List<Users> us=new ArrayList<Users>();

                while (resultSet.next()){
                    Users u=new Users();
                    //切记数据库表格从1开始，而不是0

                    u.setPassword(resultSet.getString(3));

                    us.add(u);
                }
                return us;
            }
        });

        for (Users us:li){
            System.out.println(us);



        }
    }
    @Test
    public void testInsert2()throws Exception{

            //创建一个queryRunner对象
            QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());

            //BeanListHandler完成了对ResultSetHandler的封装，所以直接调用，两行代码就很方便了
            List<Users> list =qr.query("select*from login WHERE ID=1",new BeanListHandler<>(Users.class));

            for (Users us: list){
                System.out.println(us);
            }
    }














}
