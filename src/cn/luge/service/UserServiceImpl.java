package cn.luge.service;

import cn.luge.dao.UserDao;
import cn.luge.dao.UserDaoImpl;
import cn.luge.domain.User;

public class UserServiceImpl implements UserService{
    UserDao dao = new UserDaoImpl();
    @Override
    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }
}
