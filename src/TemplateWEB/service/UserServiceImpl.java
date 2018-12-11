package TemplateWEB.service;

import TemplateWEB.dao.UserDao;
import TemplateWEB.daoimpl.UserDaoImpl;
import TemplateWEB.domain.Users;
import TemplateWEB.serviceimpl.UserService;


public class UserServiceImpl implements UserService {

    UserDao userDao=new UserDaoImpl();

    @Override
    public void register(Users user) throws Exception {

        userDao.addUser(user);
    }

    public Users login(Users users) throws Exception {
        Users u=null;

        try {
            u=userDao.selectUser(users);


        } catch (Exception e) {
            e.printStackTrace();

        }

        return u;
    }


}
