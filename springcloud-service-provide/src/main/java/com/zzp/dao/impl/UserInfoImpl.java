package com.zzp.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.zzp.dao.UserInfoMapper;
import com.zzp.pojo.UserInfo;

/**
 * Created by zhuzhengping on 2017/4/22.
 * JDBC连接数据库
 * 使用JdbcTemplate，需要自己完成SQL
 */
@Repository
public class UserInfoImpl implements UserInfoMapper {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void createUser(String tel,String pwd) {
        jdbcTemplate.update("INSERT INTO blog.tp_user(tel,password,nickname,secret) VALUES (?,md5(?),?,'')",tel,pwd,tel);
    }

    @Override
    public UserInfo getUser(Integer uid) {
        List<UserInfo> userList = jdbcTemplate.query("select ID, nickname, address password from p_users_detail where UID = ? ",new Object[]{uid},new BeanPropertyRowMapper(UserInfo.class));
        if(userList != null && userList.size() > 0){
            UserInfo user = userList.get(0);
            return user;
        }else {
            return null;
        }
    }

    @Override
    public void updateUser(String user_id, String nickName) {
        jdbcTemplate.update("UPDATE blog.tp_user SET nickname = ? WHERE user_id = ?",nickName,user_id);
    }

    @Override
    public void deleteUserByUserId(Integer id) {
        jdbcTemplate.update("DELETE FROM blog.tp_user WHERE user_id = ?",id);
    }
}
