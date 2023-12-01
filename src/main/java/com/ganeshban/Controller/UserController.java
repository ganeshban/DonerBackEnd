package com.ganeshban.Controller;

import com.ganeshban.Model.UserModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController{

    public UserModel getOneUser(Long id){

        return new UserModel();
    }
}