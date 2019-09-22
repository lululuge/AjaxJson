package cn.luge.dao;

import cn.luge.domain.User;
import cn.luge.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserDaoImpl implements UserDao {
    @Override
    public User findByUsername(String username) {
        try {
            String sql = "select * from user where username = ?";
            JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), username);
            return user;
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 查不到返回null
        return null;
    }
}
