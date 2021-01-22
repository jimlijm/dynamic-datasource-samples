package com.baomidou.samples.mybatisplus3.service.impl;


import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.annotation.Slave;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.samples.mybatisplus3.entity.User;
import com.baomidou.samples.mybatisplus3.mapper.UserMapper;
import com.baomidou.samples.mybatisplus3.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    @DS("master")
    public List<User> selectMasterUsers() {
        return baseMapper.selectList(null);
    }

    @Override
    @DS("master")
    public List<User> selectSlaveUsers() {
        return baseMapper.selectList(null);
    }

    @Override
    @DS("master")
    public List<User> selectLambdaMasterUsers() {
        return this.lambdaQuery().list();
    }

    @Override
    @DS("master")
    public List<User> selectLambdaSlaveUsers() {
        return this.lambdaQuery().list();
    }

    @Override
    @Slave
    public List<User> selectSlaveAnnotationUsers() {
        return this.lambdaQuery().list();
    }

    @Override
    @DS("master")
    @Transactional
    public void addUser(User user)  {
        
         baseMapper.insert(user);
         int i = 10 / 0;
        
    }

    @Override
    @DS("master")
    public void deleteUserById(Long id) {
        baseMapper.deleteById(id);
    }
}
