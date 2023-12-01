package com.ganeshban.Service;

import com.ganeshban.Core.NotFound;
import com.ganeshban.DTO.ChangePasswordDTO;
import com.ganeshban.DTO.LoginDTO;
import com.ganeshban.Model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserModel create (UserModel userModel);
    UserModel update (UserModel userModel) throws NotFound;
    UserModel getOneUser (Long id) throws NotFound;
    List<UserModel> getListOfUser ();
    String delete(Long id);

    String login(LoginDTO request);
    String changePassword(ChangePasswordDTO request);

}
