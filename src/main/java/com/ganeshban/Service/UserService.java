package com.ganeshban.Service;

import com.ganeshban.Core.NotFound;
import com.ganeshban.Model.UserModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserModel create (UserModel userModel);
    UserModel update (UserModel userModel);
    UserModel getOneUser (Long id) throws NotFound;
    List<UserModel> getListOfUser ();
    String delete(Long id);
}
