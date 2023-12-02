package com.ganeshban.Service;

import com.ganeshban.Core.NotFound;
import com.ganeshban.DTO.ChangePasswordDTO;
import com.ganeshban.DTO.LoginDTO;
import com.ganeshban.Model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public interface UserService {
    UserModel create(UserModel userModel) throws NotFound;

    UserModel update(UserModel userModel) throws NotFound;

    UserModel getOneUser(Long id) throws NotFound;

    List<UserModel> getListOfUser(Map<String, Object> args);

    String login(LoginDTO request) throws NotFound;

    String changePassword(ChangePasswordDTO request) throws NotFound;

}
