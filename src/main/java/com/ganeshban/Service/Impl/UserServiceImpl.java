package com.ganeshban.Service.Impl;


import com.ganeshban.Core.NotFound;
import com.ganeshban.DTO.ChangePasswordDTO;
import com.ganeshban.DTO.LoginDTO;
import com.ganeshban.Model.UserModel;
import com.ganeshban.Repository.UserRepository;
import com.ganeshban.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repo;

    @Override
    public UserModel create(UserModel userModel) throws NotFound {
        boolean user = repo.findByEmail(userModel.getEmail()).isPresent();
        if (user){
            throw new NotFound("this email is not available");
        }
        user=repo.findByPhone(userModel.getPhone()).isPresent();
        if (user){
            throw new NotFound("this phone is not available");
        }

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
    public List<UserModel> getListOfUser(Map<String, Object> args) {
        String q="select u.* from tblUserInformation u where u.address in (select a.id from tbl_address a where a.state ='"+args.get("state").toString()+"')";
        System.out.println(args);
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