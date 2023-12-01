package com.ganeshban.Service.Impl;


import com.ganeshban.Core.NotFound;
import com.ganeshban.Model.UserModel;
import com.ganeshban.Repository.UserRepository;
import com.ganeshban.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserModel create(UserModel userModel) {
        return repo.save(userModel);
    }

    @Override
    public UserModel update(UserModel userModel) {
        return repo.save(userModel);
    }

    @Override
    public UserModel getOneUser(Long id) throws NotFound {
        return repo.findById(id).orElseThrow(()-> new NotFound("User not found."));
    }

    @Override
    public List<UserModel> getListOfUser() {
        return null;
    }

    @Override
    public String delete(Long id) {
        return null;
    }
}