package TemplateWEB.dao;


import TemplateWEB.domain.Users;

public interface UserDao {
    /**
     * 操作类
     * @param user
     * @throws Exception
     */

    public void addUser(Users user)throws Exception;
    public Users selectUser(Users user);



}
