package com.ganeshban.Service.Impl;


import com.ganeshban.Core.NotFound;
import com.ganeshban.DTO.ChangePasswordDTO;
import com.ganeshban.DTO.LoginDTO;
import com.ganeshban.Model.UserModel;
import com.ganeshban.Repository.UserRepository;
import com.ganeshban.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
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
        return repo.findById(id).orElseThrow(() -> new NotFound("User not found."));
    }

    @Override
    public List<UserModel> getListOfUser() {
        return repo.findAll();
    }


    @Override
    public String login(LoginDTO request) throws NotFound {
        String errorMsg="username and password are incorrect";
        UserModel user= repo.findByEmail(request.getUserName()).orElseThrow(()->new NotFound(errorMsg));
        if (!user.getPassword().equals(request.getPassword())){
            throw new NotFound(errorMsg);
        }

        return "login success";
    }

    @Override
    public String changePassword(ChangePasswordDTO request) throws NotFound {
        if (!request.getConfirmPassword().equals(request.getNewPassword())) {
            throw new NotFound("both passwords didn't match");
        }
        UserModel userModel = getOneUser(request.getId());
        if (!request.getOldPassword().equals(userModel.getPassword())) {
            throw new NotFound("old password is wrong");
        }
        userModel.setPassword(request.getNewPassword());
        repo.save(userModel);
        return "password change successfully";
    }

}