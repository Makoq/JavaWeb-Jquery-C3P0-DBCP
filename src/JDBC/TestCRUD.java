package JDBC;

import TemplateWEB.utils.DButils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Statement;

public class TestCRUD {
    private Connection conn= null;
    private Statement state=null;

@Test
//insertDB operation
    public void testSelect(){

        try {
            conn=DButils.getConnection();
            state=conn.createStatement();
            //SQL语句
            int i = state.executeUpdate("insert into login values(3,'wang','123','123@gmail','1996-5-5')");
            if (i > 0) {
                System.out.println("success");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //DButils.closeAll(rs,state,conn);
        }
    }



    /*

    //利用lambda迭代hashmap
        public void test(){

        Map<String,Integer> scores=new HashMap<String,Integer>();

        scores.put("1",90);
        scores.put("2",98);
        scores.put("3",80);
        scores.put("4",30);

        scores.forEach((k,v) ->
        System.out.println("id="+k+",sco="+v));

        }

    */



}
