package TemplateWEB.serviceimpl;


import TemplateWEB.domain.Users;

public interface UserService {

    /**
     * 注册
     * @param user
     * @throws Exception
     */

    public void register(Users user)throws Exception;
    /**
     * 登录
     * @param user
     * @throws Exception
     */

    public Users login(Users user)throws Exception;



}
