package org.happybean.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wgt
 * @date 2019-03-20
 * @description
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //@Transactional 表示这是一个事务方法
    @Override
    @Transactional
    public void insert() {
        String sql = "INSERT INTO `test`.`user`(`name`, `age`, `sex`, `create_time`) VALUES ('zhansan', 1, 'man', now());";
        jdbcTemplate.update(sql);
        //此处以演示异常情况
        int a = 10/0;
    }
}
