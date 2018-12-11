package DBUTils;

import TransferAccount.Utils.C3P0UTils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;
import org.junit.Test;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class testResultSetHandler {

    /**
     * ResultHandler的9种结果处理器
     */
    @Test//ArrrayHandler:适合取得1条记录。把该条记录的每列值封装到一个数组中Object[]
    public void test1(){

        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());
        try {
            Object[] arr=qr.query("select*from login where id=?",new ArrayHandler(),19);

            for (Object o: arr) {
                System.out.println(o);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test//ArrayListHandler：适合取多条记录，把每条记录的每列存在Object数组里，吧数组放在LIST里
    public void test2(){

        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());
        try {
            List<Object[]> arr=qr.query("select*from login",new ArrayListHandler());

            for (Object[] li: arr) {
                for (Object o: li) {
                    System.out.println(o);
                }
                System.out.println("<><><><><><><><>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Test//CloumnListHandler:取得某一列的数据，封装在List中
    public void test3(){

        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());

        try {
            List<Object> arr=qr.query("select *from login",new ColumnListHandler(2));

            for (Object o:arr) {
                System.out.println(o);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Test//KeyedHandler:取得多条记录，每一条记录封装在一个Map中，再把这个Map封装到另一个Mao里，key就是字段名
    public void test4(){

        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());

        try {
            //大Map的KEY是表中的某列（object）,小Map里是列名，或字段名，所以大Map为Object,小Map为String
            Map<Object,Map<String,Object>> arr=qr.query("select*from login",new KeyedHandler(1));

            for (Map.Entry<Object,Map<String,Object>> m: arr.entrySet()) {
                System.out.println(m.getKey());

                for (Map.Entry<String,Object> mm:m.getValue().entrySet()) {

                    System.out.println(mm.getKey()+"\t"+mm.getValue());
                }
                System.out.println("------------------");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Test//MapHandler:适合去一条记录。把当前的列名和列值放在一个Map里面
    public void test5(){

        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());

        try {
            Map<String,Object> arr=qr.query("select *from login where id=?",new MapHandler(),10);
            for (Map.Entry<String,Object> m:arr.entrySet()) {
                System.out.println(m.getKey()+"\t"+m.getValue());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test//MapListHandler:适合去多条记录。把每条记录封装在Map里，再把Map封装在List里
    public void test6(){

        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());

        try {
            List<Map<String,Object>> arr=qr.query("select *from login ",new MapListHandler());
            for (Map<String,Object> m:arr) {
                for (Map.Entry<String,Object> mm:m.entrySet()){
                    System.out.println(mm.getKey()+"\t"+mm.getValue());
                }
                System.out.println("<><><><><><><><");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Test//ScalarHandler:适合取单行单列数据
    public void test7(){

        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());

        try {
            Object o=qr.query("select name  from login where id=?",new ScalarHandler(1),"2");//列数，从1开始

            System.out.println(o);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test//BeanHandler:适合取单行单列数据
    public void test8(){

        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());

        try {
            Users US=qr.query("select * from login",new BeanHandler<Users>(Users.class));//列数，从1开始

            System.out.println(US);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test//BeanListHandler:适合取单行单列数据
    public void test0(){

        QueryRunner qr=new QueryRunner(C3P0UTils.getDataSource());

        try {
            List<Users> list=qr.query("select *from login",new BeanListHandler<Users>(Users.class));//列数，从1开始

            Iterator iter=list.iterator();
            while (iter.hasNext()) {
                System.out.println(iter.next());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }























}
