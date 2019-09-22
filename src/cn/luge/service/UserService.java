package cn.luge.service;

import cn.luge.domain.User;

public interface UserService {
    User findByUsername(String username);
}
