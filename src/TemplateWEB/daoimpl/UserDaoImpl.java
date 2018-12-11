package TemplateWEB.daoimpl;

import TemplateWEB.dao.UserDao;
import TemplateWEB.domain.Users;
import TemplateWEB.utils.C3P0UTils;
import TemplateWEB.utils.DButils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    /**
     * 添加数据
     */
    public void addUser(Users user) throws Exception {

        Connection conn=null;
        PreparedStatement ps=null;

        try {
            conn=C3P0UTils.getConnection();
            ps=conn.prepareStatement("insert into login(name,password,email,birthday) values(?,?,?,?)");
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getEmail());
            ps.setString(4,user.getBirthday());

            ///SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
            //String date=sdf.format(user.getBirthday());
            //ps.setString(4,date);

            int i=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("添加失败");
        }finally {
            DButils.closeAll(null,ps,conn);
        }


    }


    Users u;
    @Override
    public Users selectUser(Users users){
        Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            conn=C3P0UTils.getConnection();


            ps=conn.prepareStatement("select *from login where  name=? and password=?");
            ps.setString(1,users.getUsername());
            ps.setString(2,users.getPassword());
            rs=ps.executeQuery();


            if (rs.next()){
                u=new Users();
                u.setUsername(rs.getString(1));
                u.setPassword(rs.getString(2));

            }else{
                return null;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            DButils.closeAll(rs,ps,conn);
        }
        return u;


    }






}
