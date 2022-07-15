package com.explarity.test.Controller;

import com.explarity.test.entity.UserEntity;
import com.explarity.test.service.UserService;
import net.minidev.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/test/api")

public class UserController {


    Logger log =  LoggerFactory.getLogger(UserController.class);
//    Logger logger=LoggerFactory.getLogger(UserController.class);
//   logger.getStartedwithLogBackTesting();
    @Autowired
    public UserService userService;

    @PostMapping("/create/user")
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){

        UserEntity createdUser = this.userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("getAllUser")
    public ResponseEntity<List<UserEntity>>userList(){
        List<UserEntity> list = this.userService.getAllUser();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user,@PathVariable Long id){
        UserEntity updateUser=this.userService.updateUser(user,id);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }


    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<UserEntity> deleteUser(@PathVariable Long id){
        UserEntity deleteUser=this.userService.deleteUser(id);
        return new ResponseEntity<>(deleteUser,HttpStatus.OK);
    }

    @GetMapping("/user")
    public JSONObject create() {
        JSONObject obj = new JSONObject();
        obj.put("name", "nikkhat");
        obj.put("age", (27));
        obj.put("salary", (600000));
        System.out.print(obj);
        log.info(" log info :::::::::::::json object is created"+obj);
        return obj;
    }
}


