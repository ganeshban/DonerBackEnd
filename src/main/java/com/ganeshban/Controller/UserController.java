package com.ganeshban.Controller;

import com.ganeshban.Core.NotFound;
import com.ganeshban.DTO.LoginDTO;
import com.ganeshban.Model.UserModel;
import com.ganeshban.Service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController{

    @Autowired
    private UserServiceImpl service;

    @GetMapping("/{id}")
    public UserModel getOneUser(@PathVariable Long id) throws NotFound {
        return service.getOneUser(id);
    }


    @GetMapping("/list")
    public List<UserModel> getListUser (@PathVariable Long id)  {
        return service.getListOfUser();
    }

    @PostMapping("/create")
    public UserModel create (@RequestBody UserModel request){
        return service.create(request);
    }
    @PutMapping("/create")
    public UserModel update (@RequestBody UserModel request){
        return service.update(request);
    }
    @PostMapping("/login")
    public String login (@RequestBody LoginDTO request){
        return service.login(request);
    }



}