package com.ganeshban.Service;

import com.ganeshban.Model.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    UserModel create (UserModel userModel);
}
