package cn.luge.dao;

import cn.luge.domain.User;

public interface UserDao {
    User findByUsername(String username);
}
