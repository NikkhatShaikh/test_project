package com.explarity.test.service.impl;

import com.explarity.test.entity.UserEntity;
import com.explarity.test.repository.UserEntityRepository;
import com.explarity.test.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    UserEntityRepository userEntityRepository;

    @Override
    public UserEntity createUser(UserEntity User) {
        UserEntity createdUser=this.userEntityRepository.save(User);
        return createdUser;
    }

    @Override
    public List<UserEntity> getAllUser() {

        List<UserEntity>userList=this.userEntityRepository.findAll();
        List<UserEntity>getUserList=userList.stream().collect(Collectors.toList());
        return getUserList;
    }

    @Override
    public UserEntity updateUser(UserEntity user, Long id) {
        UserEntity updateUser =this.userEntityRepository.findById(id).orElseThrow(()-> new RuntimeException());

        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setUserName(user.getUserName());
        updateUser.setMobileNumber(user.getMobileNumber());
        updateUser.setUserEmail(user.getUserEmail());
        updateUser.setPassword(user.getPassword());
        updateUser.setCreatedDate(user.getCreatedDate());
        updateUser.setUpdatedDate(user.getUpdatedDate());

        UserEntity updatedUser =this.userEntityRepository.save(updateUser);

        return updatedUser;
    }

    @Override
    public UserEntity deleteUser(Long id) {
        UserEntity deleteUser=this.userEntityRepository.findById(id).orElseThrow(()-> new RuntimeException());
         this.userEntityRepository.delete(deleteUser);
        return deleteUser;
    }
}
