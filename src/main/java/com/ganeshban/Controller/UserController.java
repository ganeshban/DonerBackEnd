package com.ganeshban.Controller;

import com.ganeshban.Core.NotFound;
import com.ganeshban.DTO.ChangePasswordDTO;
import com.ganeshban.DTO.LoginDTO;
import com.ganeshban.Model.UserModel;
import com.ganeshban.Service.Impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Valid
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
    public List<UserModel> getListUser (@RequestParam(value = "bg",defaultValue = "") Long bloodGroup,
                                        @RequestParam(value = "city",defaultValue = "") String city
                                        )  {
        Map<String, Object> data= new HashMap<>();
        data.put("bloodGroup",bloodGroup);
        data.put("city",city);
        return service.getListOfUser(data);
    }

    @PostMapping("/create")
    public UserModel create (@RequestBody @Valid UserModel request) throws NotFound {
        return service.create(request);
    }
    @PutMapping("/update")
    public UserModel update (@RequestBody @Valid UserModel request){
        return service.update(request);
    }
    @PostMapping("/login")
    public String login (@RequestBody LoginDTO request) throws NotFound {
        return service.login(request);
    }

    @PostMapping("/change-password")
    public String changePassword (@RequestBody @Valid ChangePasswordDTO request) throws NotFound {
        return service.changePassword(request);
    }



}