package com.explarity.test.service;

import com.explarity.test.entity.UserEntity;

import java.util.List;

public interface UserService {


    UserEntity createUser(UserEntity createUser);

    List<UserEntity> getAllUser();

    UserEntity updateUser(UserEntity updateUser,Long id);

    UserEntity deleteUser(Long id);
}
